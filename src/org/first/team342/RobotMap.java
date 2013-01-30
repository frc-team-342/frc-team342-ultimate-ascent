package org.first.team342;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //drive motor addresses old robot
    /*public static final int CAN_DEVICE_LEFT_FRONT_DRIVE_MOTOR = 5;
    public static final int CAN_DEVICE_RIGHT_FRONT_DRIVE_MOTOR = 6;
    public static final int CAN_DEVICE_RIGHT_REAR_DRIVE_MOTOR = 7;
    public static final int CAN_DEVICE_LEFT_REAR_DRIVE_MOTOR = 8;
    */
    //new robot addressses
    public static final int CAN_DEVICE_RIGHT_FRONT_DRIVE_MOTOR = 1;
    public static final int CAN_DEVICE_LEFT_FRONT_DRIVE_MOTOR = 2;
    public static final int CAN_DEVICE_LEFT_REAR_DRIVE_MOTOR = 3;
    public static final int CAN_DEVICE_RIGHT_REAR_DRIVE_MOTOR = 4;
    
    public static final int CAN_DEVICE_THROWER_FRONT = 5;
    public static final int CAN_DEVICE_THROWER_BACK = 6;
    //controller location
    public static final int JOYSTICK_DRIVE_CONTROL = 1;
    //Default position in the CRIO for the side car
    public static final int DEFAULT_ANNALOG_SLOT = 1;
    //driverstation slidder to set speed
    public static final int RAMMING_SPEED = 1;
    public static final int AUTONOMOUS_CENTER = 2;
}
