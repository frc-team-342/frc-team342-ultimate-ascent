/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.elevator;

import org.first.team342.Controller;
import org.first.team342.OI;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Elevator;

/**
 *
 * @author Charlie
 */
public class ElevateWithJoystick extends CommandBase {

    private Elevator elevator = Elevator.getInstance();
    private Controller joystick;

    public ElevateWithJoystick() {
        requires(this.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        OI oi = OI.getInstance();
        this.joystick = oi.getDriveController();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        this.elevator.elevateWithJoystick(this.joystick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
