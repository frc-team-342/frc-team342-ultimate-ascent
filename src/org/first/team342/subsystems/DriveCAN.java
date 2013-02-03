/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import org.first.team342.Controller;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
import org.first.team342.commands.drive.DriveWithJoystick;

/**
 *
 * @author Team 342
 */
public class DriveCAN extends Subsystem {

    private static final DriveCAN INSTANCE = new DriveCAN();
    private SpeedController leftFront;
    private SpeedController rightFront;
    private SpeedController leftRear;
    private SpeedController rightRear;
    private RobotDrive robotDrive;
    private DriverStation station;

    private DriveCAN() {
        this.leftFront = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_LEFT_FRONT_DRIVE_MOTOR);
        this.rightFront = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_RIGHT_FRONT_DRIVE_MOTOR);
        this.leftRear = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_LEFT_REAR_DRIVE_MOTOR);
        this.rightRear = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_RIGHT_REAR_DRIVE_MOTOR);
        this.robotDrive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
        this.robotDrive.setSafetyEnabled(false);
    }

    public static DriveCAN getInstance() {
        return INSTANCE;
    }

    protected void initDefaultCommand() {
        this.setDefaultCommand(new DriveWithJoystick());
    }

    public void driveWithJoystick(Controller joystick) {
        this.robotDrive.tankDrive(joystick.getLeftY() * -1, joystick.getRightY() * -1);
        try {
            System.out.println("CANMode = "+ SmartDashboard.getBoolean("CANMode"));
        } catch (TableKeyNotDefinedException ex) {
            System.out.println("No CANMode value");
        }
    }
    /*
     * drive with speed governing
     */

    public void rammingSpeed(Controller joystick) {
        double leftStick = joystick.getLeftY() * -(this.station.getAnalogIn(RobotMap.RAMMING_SPEED)/5);
        double rightStick = joystick.getRightY() * -(this.station.getAnalogIn(RobotMap.RAMMING_SPEED)/5);
        this.robotDrive.tankDrive(leftStick,rightStick);
    }
    public void turn(double speed){
        this.robotDrive.tankDrive(speed, -speed);
    }
}
