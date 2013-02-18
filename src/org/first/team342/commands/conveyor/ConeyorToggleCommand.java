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
public class ConeyorToggleCommand extends CommandBase {
    private Conveyor conveyor = Conveyor.getInstance();
    private boolean conveyorStatus;
    
    public ConeyorToggleCommand() {
        requires(conveyor);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        conveyorStatus = conveyor.isConveyorOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(conveyorStatus){
            conveyor.turnConveyorOff();
        } else {
            conveyor.turnConveyorOn();
        }
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
