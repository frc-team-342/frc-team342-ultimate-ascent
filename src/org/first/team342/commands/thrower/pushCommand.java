/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.thrower;

import org.first.team342.abstractions.ThrowerBase;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.ThrowerCAN;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Charlie
 */
public class pushCommand extends CommandBase {

    private ThrowerBase thrower = ThrowerCAN.getInstance();

    public pushCommand() {
        requires(thrower);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //thrower.pushMotorSet(-1.0);
        //Timer.delay(0.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        thrower.push(-1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
//            return true;
//        } else {
//            return false;
//        }
    }

    // Called once after isFinished returns true
    protected void end() {
        thrower.pushMotorSet(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
