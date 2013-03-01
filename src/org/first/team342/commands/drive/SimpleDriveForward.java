/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.drive;

import org.first.team342.abstractions.DriveBase;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.DrivePWM;

/**
 *
 * @author Charlie
 */
public class SimpleDriveForward extends CommandBase {
    private DriveBase drive = DrivePWM.getInstance();
    private double speed;
    
    public SimpleDriveForward(double speed) {
        requires(this.drive);
        this.speed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.forward(-this.speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
