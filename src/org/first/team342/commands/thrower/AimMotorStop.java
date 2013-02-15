/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.thrower;

import org.first.team342.abstractions.Thrower;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.ThrowerCAN;
import org.first.team342.abstractions.ThrowerBase;
/**
 *
 * @author Charlie
 */
public class AimMotorStop extends CommandBase {
    Thrower thrower = ThrowerCAN.getInstance();
    
    public AimMotorStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        thrower.aimMotorStop();
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
