/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.drive;

import edu.wpi.first.wpilibj.DriverStation;
import org.first.team342.RobotMap;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Drive;

/**
 *
 * @author Team 342
 */
public class CenterRobotCommand extends CommandBase {
    private Drive drive = Drive.getInstance();
    private DriverStation station;
    
    public CenterRobotCommand() {
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        this.drive.turn((station.getAnalogIn(RobotMap.AUTONOMOUS_CENTER)-2.5)/2.5);
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
