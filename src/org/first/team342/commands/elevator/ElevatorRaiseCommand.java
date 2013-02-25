/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.elevator;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Elevator;


/**
 *
 * @author Charlie
 */
public class ElevatorRaiseCommand extends CommandBase {
    private Elevator elevator = Elevator.getInstance();
    
    public ElevatorRaiseCommand() {
        requires(elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        System.out.println("up initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        elevator.raise(1.0);
//        System.out.println("Executed Up");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !elevator.getSwitchTop();
//        if (elevator.getSwitchTop()){
//            return false;
//        }else{
//            return true;
//        }
    }

    // Called once after isFinished returns true
    protected void end() {
//        System.out.println("Up turned off");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
