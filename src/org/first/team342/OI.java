package org.first.team342;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    private Controller driveController;
    private static final OI INSTANCE = new OI();

    private OI() {
        driveController = new Controller(RobotMap.JOYSTICK_DRIVE_CONTROL);
        //JoystickButton targeting = new JoystickButton(driveController, 4);
        
        //targeting.whileHeld(new CenterRobotCommand());
        //targeting.whenReleased(new DriveWithJoystick());
    }

    public static OI getInstance() {
        return INSTANCE;
    }

    public Controller getDriveController() {
        return driveController;
    }
}
