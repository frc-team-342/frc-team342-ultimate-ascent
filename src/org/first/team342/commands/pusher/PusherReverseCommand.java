/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.pusher;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Pusher;

/**
 *
 * @author Charlie
 */
public class PusherReverseCommand extends CommandBase {
    
    private Pusher pusher = Pusher.getInstance();
    
    public PusherReverseCommand() {
        requires(this.pusher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        this.pusher.reverse();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.pusher.isBack();
    }

    // Called once after isFinished returns true
    protected void end() {
        this.pusher.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
