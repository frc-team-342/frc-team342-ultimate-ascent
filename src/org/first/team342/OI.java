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
import org.first.team342.commands.PrintCommand;
import org.first.team342.commands.conveyor.ConveyorOnCommand;
import org.first.team342.commands.conveyor.ConveyorReverseCommand;
import org.first.team342.commands.elevator.ElevatorLowerCommand;
import org.first.team342.commands.elevator.ElevatorRaiseCommand;
import org.first.team342.commands.elevator.ElevatorStopCommand;
import org.first.team342.commands.thrower.*;

public class OI{

    private Controller driveController;
    private static final OI INSTANCE = new OI();

    private OI() {
        driveController = new Controller(RobotMap.JOYSTICK_DRIVE_CONTROL);

        JoystickButton elevatorRaise = new JoystickButton(driveController, 10);
        JoystickButton elevatorLower = new JoystickButton(driveController, 9);
        JoystickButton conveyorToggleOn = new JoystickButton(driveController, 3);
        JoystickButton conveyorRev = new JoystickButton(driveController, 2);
//        JoystickButton center = new JoystickButton(driveController, 10);
//        JoystickButton flash = new JoystickButton(driveController, 4);
//        JoystickButton redOn = new JoystickButton(driveController, 5);
//        JoystickButton blueOn = new JoystickButton(driveController, 6);
//        JoystickButton bothOn = new JoystickButton(driveController, 7);
        JoystickButton simpleShootForward = new JoystickButton(driveController, 6);
        JoystickButton throwerRaiseSimple = new JoystickButton(driveController, 4);
        JoystickButton throwerLowerSimple = new JoystickButton(driveController, 1);
        JoystickButton pushDisc = new JoystickButton(driveController, 5);
        JoystickButton moveToAngle = new JoystickButton(driveController, 7);
//        JoystickButton potentiometerTest = new JoystickButton(driveController, 10);
        
        JoystickButton potentiometerTest = new JoystickButton(driveController, 8);

        elevatorRaise.whileHeld(new ElevatorRaiseCommand());
        elevatorRaise.whenReleased(new ElevatorStopCommand());

        elevatorLower.whileHeld(new ElevatorLowerCommand());
        elevatorLower.whenReleased(new ElevatorStopCommand());

        conveyorToggleOn.whenPressed(new ConveyorOnCommand());

        conveyorRev.whenPressed(new ConveyorReverseCommand());

//        center.whileHeld( new CenterRobotCommand());
//        center.whenReleased(new DriveWithJoystick());
//        
//        flash.whileHeld(new FlashAlternatingCommand());
//        flash.whenReleased(new BothLightsOffCommand());
//        
//        redOn.whenPressed(new RedLightOnCommand());
//        redOn.whenReleased(new BothLightsOffCommand());
//        
//        blueOn.whenPressed(new BlueLightOnCommand());
//        blueOn.whenReleased(new BothLightsOffCommand());
        
        simpleShootForward.whenPressed(new SimpleShootForwardCommand());
        simpleShootForward.whenReleased(new ThrowerOffCommand());
        
        throwerRaiseSimple.whenPressed(new SimpleRaiseCommand());
        throwerRaiseSimple.whenReleased(new AimMotorStop());
        
        throwerLowerSimple.whenPressed(new SimpleLowerCommand());
        throwerLowerSimple.whenReleased(new AimMotorStop());

        pushDisc.whileHeld(new PushLimitSwitchCommand());
        pushDisc.whenReleased(new PushUntilReturnCommand());
        
        moveToAngle.whileHeld(new MoveToAngleCommand(1.0, 40.0));
        moveToAngle.whenReleased(new AimMotorStop());
        
//        potentiometerTest.whenPressed(new RedLightOnCommand());
//        potentiometerTest.whenReleased(new BothLightsOffCommand());
        //JoystickButton targeting = new JoystickButton(driveController, 4);
        
        //targeting.whileHeld(new CenterRobotCommand());
        //targeting.whenReleased(new DriveWithJoystick());

        potentiometerTest.whenPressed(new PotentiometerTestCommand());
    }

    public static OI getInstance() {
        return INSTANCE;
    }

    public Controller getDriveController() {
        return driveController;
    }
}
