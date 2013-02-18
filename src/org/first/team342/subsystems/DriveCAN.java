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

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import org.first.team342.Controller;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
import org.first.team342.abstractions.DriveBase;
import org.first.team342.commands.drive.DriveWithJoystick;

/**
 *
 * @author Team 342
 */
public class DriveCAN extends DriveBase {

    private static final DriveBase INSTANCE = new DriveCAN();
    private CANJaguar leftFront;
    private CANJaguar rightFront;
    private CANJaguar leftRear;
    private CANJaguar rightRear;
    private RobotDrive robotDrive;
    private DriverStation station;
    private final double DISTANCE_PER_ROTATION = 1.4995668990882067; //inches [6in * pi / 12.57gearratio] 

    private DriveCAN() {
        super();
        try {
            this.leftFront = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_LEFT_FRONT_DRIVE_MOTOR);
            this.rightFront = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_RIGHT_FRONT_DRIVE_MOTOR);
            this.leftRear = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_LEFT_REAR_DRIVE_MOTOR);
            this.rightRear = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_RIGHT_REAR_DRIVE_MOTOR);
            this.robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
            this.robotDrive.setSafetyEnabled(false);
            this.leftFront.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            this.rightFront.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            this.leftRear.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            this.rightRear.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
            this.leftFront.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            this.rightFront.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            this.leftRear.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
            this.rightRear.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);

        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    private void setControlModePosition() {
        try {
            this.leftFront.changeControlMode(CANJaguar.ControlMode.kPosition);
            this.leftRear.changeControlMode(CANJaguar.ControlMode.kPosition);
            this.rightFront.changeControlMode(CANJaguar.ControlMode.kPosition);
            this.leftFront.changeControlMode(CANJaguar.ControlMode.kPosition);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    private void setControlModeSpeed() {
        try {
            this.leftFront.changeControlMode(CANJaguar.ControlMode.kSpeed);
            this.leftRear.changeControlMode(CANJaguar.ControlMode.kSpeed);
            this.rightFront.changeControlMode(CANJaguar.ControlMode.kSpeed);
            this.leftFront.changeControlMode(CANJaguar.ControlMode.kSpeed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public static DriveBase getInstance() {
        return INSTANCE;
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new DriveWithJoystick());
    }

    public void driveWithJoystick(Controller joystick) {
        this.robotDrive.tankDrive(joystick.getLeftY() * -1, joystick.getRightY() * -1);
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

    public void turn(double speed, double distance) {
        this.setControlModePosition();
        distance = distance / DISTANCE_PER_ROTATION;
        try {
            this.leftFront.setX(-distance);
            this.rightFront.setX(distance);
            this.leftRear.setX(-distance);
            this.rightRear.setX(distance);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    /*
     * TO DO MAKE WORK, aka add startX(distance*k) k = constant value add for
     * all motors
     */

    public void forward(double speed, double distance) {
        this.setControlModePosition();
        byte syncGroup = 1;
        distance = distance / DISTANCE_PER_ROTATION;
        try {
            this.leftFront.setX(distance, syncGroup);
            this.rightFront.setX(distance, syncGroup);
            this.leftRear.setX(distance, syncGroup);
            this.rightRear.setX(distance, syncGroup);
            CANJaguar.updateSyncGroup(syncGroup);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

    }
    // TO DO MAKE WORK, aka ADD DISTANCE 

    public void reverse(double speed, double distance) {
        this.setControlModePosition();
        byte syncGroup = 1;
        distance = distance / DISTANCE_PER_ROTATION;
        try {
            this.leftFront.setX(-distance, syncGroup);
            this.rightFront.setX(-distance, syncGroup);
            this.leftRear.setX(-distance, syncGroup);
            this.rightRear.setX(-distance, syncGroup);
            CANJaguar.updateSyncGroup(syncGroup);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

    }

    public void forward(double speed) {
        this.robotDrive.tankDrive(speed, speed);
    }

    public void reverse(double speed) {
        this.robotDrive.tankDrive(-speed, -speed);
    }
}
