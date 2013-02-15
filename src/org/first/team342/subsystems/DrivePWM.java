/*
 * Copyright 2013 FRC Team 342
 * 
 * This file is part of "FRC Team 342 Ultimate Ascent Robot".
 * 
 * "FRC Team 342 Ultimate Ascent Robot" is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * "FRC Team 342 Ultimate Ascent Robot" is distributed in the hope that it
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "FRC Team 342 Ultimate Ascent Robot".  If not, see 
 * <http://www.gnu.org/licenses/>.
 */

package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import org.first.team342.Controller;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
import org.first.team342.abstractions.DriveBase;
import org.first.team342.commands.drive.DriveWithJoystick;

/**
 *
 * @author Team 342
 */
public class DrivePWM extends DriveBase {

    private static final DriveBase INSTANCE = new DrivePWM();
    private SpeedController leftFront;
    private SpeedController rightFront;
    private SpeedController leftRear;
    private SpeedController rightRear;
    private RobotDrive robotDrive;
    private DriverStation station;

    private DrivePWM() {
        super();
        this.leftFront = new Jaguar(RobotMap.PWM_DEVICE_LEFT_FRONT_DRIVE_MOTOR);
        this.rightFront = new Jaguar(RobotMap.PWM_DEVICE_RIGHT_FRONT_DRIVE_MOTOR);
        this.leftRear = new Jaguar(RobotMap.PWM_DEVICE_LEFT_REAR_DRIVE_MOTOR);
        this.rightRear = new Jaguar(RobotMap.PWM_DEVICE_RIGHT_REAR_DRIVE_MOTOR);
        this.robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
        this.robotDrive.setSafetyEnabled(false);
    }

    public static DriveBase getInstance() {
        return INSTANCE;
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new DriveWithJoystick());
    }

    public void driveWithJoystick(Controller joystick) {
        this.robotDrive.tankDrive(joystick.getLeftY() * -1, joystick.getRightY() * -1);
        try {
            System.out.println("PWMMode = " + SmartDashboard.getBoolean("PWMMode"));
        } catch (TableKeyNotDefinedException ex) {
            System.out.println("No PWMMode value");
        }
    }
    /*
     * drive with speed governing
     */

    public void rammingSpeed(Controller joystick) {
        double leftStick = joystick.getLeftY() * -(this.station.getAnalogIn(RobotMap.RAMMING_SPEED) / 5);
        double rightStick = joystick.getRightY() * -(this.station.getAnalogIn(RobotMap.RAMMING_SPEED) / 5);
        this.robotDrive.tankDrive(leftStick, rightStick);
    }

    public void turn(double speed) {
        this.robotDrive.tankDrive(speed, -speed);
    }
    // TO DO MAKE WORK, aka ADD DISTANCE 
    public void forward(double speed, double distance) {
        this.forward(speed);
    }
    // TO DO MAKE WORK, aka ADD DISTANCE 
    public void reverse(double speed, double distance) {
        this.reverse(speed);
    }

    public void forward(double speed) {
        this.robotDrive.tankDrive(speed, speed);
    }

    public void reverse(double speed) {
        this.robotDrive.tankDrive(-speed, -speed);
    }
}
