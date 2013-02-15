/*
 * Copyright 2013 FRC Team 342
 * 
 * This file is part of "FRC Team 342 Ultimate Ascent Robot".
 * 
 * "FRC Team 342 Ultimate Ascent Robot" is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * "FRC Team 342 Ultimate Ascent Robot" is distributed in the hope that it
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "FRC Team 342 Ultimate Ascent Robot".  If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.first.team342.commands.drive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
import org.first.team342.abstractions.DriveBase;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.DriveCAN;

/**
 *
 * @author Team 342
 */
public class CenterRobotCommand extends CommandBase {
    private int lastPosition;
    private Timer time;;
    private DriveBase drive = DriveCAN.getInstance();
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
        this.lastPosition = currentPosition;
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
