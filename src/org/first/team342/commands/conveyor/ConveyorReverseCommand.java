/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.conveyor;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Conveyor;

/**
 *
 * @author Charlie
 */
public class ConveyorReverseCommand extends CommandBase {
    private Conveyor conveyor = Conveyor.getInstance();
    
    public ConveyorReverseCommand() {
        requires(conveyor);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        this.conveyor.reverseConveyor();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
