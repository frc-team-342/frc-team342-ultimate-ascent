/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.drive;

import org.first.team342.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import org.first.team342.abstractions.DriveBase;
import org.first.team342.subsystems.DriveCAN;

/**
 *
 * @author Charlie
 */
public class DriveForward extends CommandBase {
    DriveBase drive = DriveCAN.getInstance();
    Timer timer;
    double speed;
    double distance;
    
    public DriveForward(double speed, double distance) {
        requires(drive);
        this.speed = speed;
        this.distance = distance;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.forward(this.speed, this.distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished(double time) {
        return true;
//        if(timer.get() > time){
//            return true;
//        }else{
//            return false;
//        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
