/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.first.team342.commands.drive.SimpleDriveForward;
import org.first.team342.commands.drive.SimpleTurnCommand;
import org.first.team342.commands.elevator.ElevatorRaiseCommand;
import org.first.team342.commands.thrower.SimpleShootForwardCommand;
import org.first.team342.commands.thrower.pushCommand;

/**
 *
 * @author Charlie
 */
public class DriveAndShootTime extends CommandGroup {
    
    public DriveAndShootTime() {
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
        addSequential(new SimpleDriveForward(1.0), 5.0);
  //      addSequential
        addSequential(new SimpleTurnCommand(-1.0), 2.0);
        addSequential(new SimpleDriveForward(1.0), 5.0);
        addSequential(new SimpleTurnCommand(1.0), 2.0);
        addParallel(new SimpleShootForwardCommand());
        addSequential(new ElevatorRaiseCommand());
        addSequential(new pushCommand());
    }
}
