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
package org.first.team342;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.first.team342.commands.conveyor.ConveyorOnCommand;
import org.first.team342.commands.conveyor.ConveyorStopCommand;
import org.first.team342.commands.drive.CenterRobotCommand;
import org.first.team342.commands.drive.DriveWithJoystick;
import org.first.team342.commands.elevator.ElevatorLowerCommand;
import org.first.team342.commands.elevator.ElevatorRaiseCommand;
import org.first.team342.commands.elevator.ElevatorStopCommand;
import org.first.team342.commands.lights.*;
import org.first.team342.commands.thrower.AimMotorStop;
import org.first.team342.commands.thrower.MoveToAngleCommand;
import org.first.team342.commands.thrower.SimpleRaiseCommand;
import org.first.team342.commands.thrower.pushCommand;

public class OI {

    private Controller driveController;
    private static final OI INSTANCE = new OI();

    private OI() {
        driveController = new Controller(RobotMap.JOYSTICK_DRIVE_CONTROL);
        
        JoystickButton elevatorRaise = new JoystickButton(driveController, 1);
        JoystickButton elevatorLower = new JoystickButton(driveController, 2);
        JoystickButton conveyorOn = new JoystickButton(driveController, 3);
        JoystickButton center = new JoystickButton(driveController, 10);
        JoystickButton flash = new JoystickButton(driveController, 4);
        JoystickButton redOn = new JoystickButton(driveController, 5);
        JoystickButton blueOn = new JoystickButton(driveController, 6);
//        JoystickButton bothOn = new JoystickButton(driveController, 7);
        JoystickButton throwerRaiseSimple = new JoystickButton(driveController, 7);
        JoystickButton pushDisc = new JoystickButton(driveController, 8);
        JoystickButton moveToAngle = new JoystickButton(driveController, 9);
        
        elevatorRaise.whileHeld(new ElevatorRaiseCommand());
        elevatorRaise.whenReleased(new ElevatorStopCommand());
        
        elevatorLower.whileHeld(new ElevatorLowerCommand());
        elevatorLower.whenReleased(new ElevatorStopCommand());
        
        conveyorOn.whenPressed(new ConveyorOnCommand());
        conveyorOn.whenReleased(new ConveyorStopCommand());
        
        center.whileHeld( new CenterRobotCommand());
        center.whenReleased(new DriveWithJoystick());
        
        flash.whileHeld(new FlashAlternatingCommand());
        flash.whenReleased(new BothLightsOffCommand());
        
        redOn.whenPressed(new RedLightOnCommand());
        redOn.whenReleased(new BothLightsOffCommand());
        
        blueOn.whenPressed(new BlueLightOnCommand());
        blueOn.whenReleased(new BothLightsOffCommand());
        
        throwerRaiseSimple.whenPressed(new SimpleRaiseCommand());
        throwerRaiseSimple.whenReleased(new AimMotorStop());
        
        pushDisc.whenPressed(new pushCommand());
        
        moveToAngle.whenPressed(new MoveToAngleCommand());
        moveToAngle.whenReleased(new AimMotorStop());
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
