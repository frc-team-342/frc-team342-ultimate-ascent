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
/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.first.team342;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.first.team342.abstractions.Thrower;
import org.first.team342.commands.autonomous.DriveAndShoot;
import org.first.team342.commands.autonomous.ShootOnly;
import org.first.team342.commands.drive.DriveWithJoystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class UltimateAscent extends IterativeRobot {

    private Command autonomousCommand;
    private Command joystickCommand;
    private Thrower thrower;
    private SendableChooser autonomousChooser;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        joystickCommand = new DriveWithJoystick();
        System.out.println("Autonomous mode chooser:");
        this.autonomousChooser = new SendableChooser();
        this.autonomousChooser.addDefault("Shoot Only, Default ", new ShootOnly());
        this.autonomousChooser.addObject("Drive Forward and shoot ", new DriveAndShoot());
        SmartDashboard.putData("Autonomous Mode", this.autonomousChooser);
        System.out.println("Autonomous choice sent to Dashboard");

    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        joystickCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
    }
}
