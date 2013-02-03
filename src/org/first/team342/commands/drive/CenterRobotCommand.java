/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.drive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.DriveCAN;

/**
 *
 * @author Team 342
 */
public class CenterRobotCommand extends CommandBase {
    private int lastPosition;
    private Timer time;
    private DriveCAN drive = DriveCAN.getInstance();
    private DriverStation station;
    
    public CenterRobotCommand() {
        this.lastPosition = 0;
        this.time = new Timer();
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.time.reset();
        this.time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        int currentPosition = RobotUtilities.getIntSmartDashboard("position");
        double delta = ((this.lastPosition - currentPosition)/this.time.get());
        double speed = ((RobotMap.DRIVE_CENTERING_CONASTANT_PIXEL*currentPosition)+
                        (delta*RobotMap.DRIVE_CENTERING_CONASTANT_DELTA));
        this.drive.turn(speed);
        this.time.reset();
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
