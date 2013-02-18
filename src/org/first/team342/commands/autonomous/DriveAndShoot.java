/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.first.team342.commands.drive.DriveForward;
import org.first.team342.commands.drive.TurnCommand;

/**
 *
 * @author Charlie
 */
public class DriveAndShoot extends CommandGroup {
    
    public DriveAndShoot() {
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
        addSequential(new DriveForward(1.0, 100.0));
        addSequential(new TurnCommand(1.0, 10.0));
        addSequential(new DriveForward(1.0, 100.0));
    }
}
