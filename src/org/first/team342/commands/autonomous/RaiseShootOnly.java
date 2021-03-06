/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.first.team342.commands.PrintCommand;
import org.first.team342.commands.elevator.ElevatorRaiseCommand;
import org.first.team342.commands.elevator.ElevatorStopCommand;
import org.first.team342.commands.thrower.PushStopCommand;
import org.first.team342.commands.thrower.SimpleShootForwardCommand;
import org.first.team342.commands.thrower.ThrowerOffCommand;
import org.first.team342.commands.thrower.pushCommand;

/**
 *
 * @author Team 342
 */
public class RaiseShootOnly extends CommandGroup {
    final long timeout = (long) 10.0;
    Timer timer;
    public RaiseShootOnly() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        addParallel(new SimpleShootForwardCommand());
        addSequential(new ElevatorRaiseCommand());
        addSequential(new PrintCommand("[Auto] After Raise, before push"));
        addSequential(new pushCommand());
        addSequential(new PrintCommand("[Auto] After Push, before delay"));
        addSequential(new WaitCommand(timeout));
        addSequential(new PrintCommand("[Auto] After Delay, before off"));
        addSequential(new ThrowerOffCommand());
        addParallel(new ElevatorStopCommand());
        addParallel(new PushStopCommand());
    }
}
