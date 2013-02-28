/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.thrower;

import edu.wpi.first.wpilibj.command.Command;
import org.first.team342.subsystems.Pusher;

/**
 *
 * @author Charlie
 */
public class ShootCommand extends Command {
    
    private Pusher pusher;
    
    public ShootCommand() {
        pusher = Pusher.getInstance();
        requires(pusher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        this.
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
