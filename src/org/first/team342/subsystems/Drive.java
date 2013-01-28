/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
import org.first.team342.commands.drive.DriveWithJoystick;

/**
 *
 * @author Team 342
 */
public class Drive extends Subsystem {

    private static final Drive INSTANCE = new Drive();
    private SpeedController leftFront;
    private SpeedController rightFront;
    private SpeedController leftRear;
    private SpeedController rightRear;
    private RobotDrive robotDrive;
    private DriverStation station;

    public Drive() {
        this.leftFront = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_LEFT_FRONT_DRIVE_MOTOR);
        this.rightFront = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_RIGHT_FRONT_DRIVE_MOTOR);
        this.leftRear = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_LEFT_REAR_DRIVE_MOTOR);
        this.rightRear = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_RIGHT_REAR_DRIVE_MOTOR);
        this.robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
    }

    public static Drive getInstance() {
        return INSTANCE;
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new DriveWithJoystick());
    }

    public void driveWithJoystick(Joystick joystick) {
        this.robotDrive.tankDrive(joystick.getY() * -1, joystick.getRawAxis(4) * -1);
    }
    /*
     * drive with speed governing
     */

    public void rammingSpeed(Joystick joystick) {
        double leftStick = joystick.getY() * -(this.station.getAnalogIn(RobotMap.RAMMING_SPEED)/5);
        double rightStick = joystick.getRawAxis(4) * -(this.station.getAnalogIn(RobotMap.RAMMING_SPEED)/5);
        this.robotDrive.tankDrive(leftStick,rightStick);
    }
}
