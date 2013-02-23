/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.thrower;

import edu.wpi.first.wpilibj.Timer;
import org.first.team342.abstractions.ThrowerBase;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.ThrowerCAN;

/**
 *
 * @author Charlie
 */
public class SimpleRaiseCommand extends CommandBase {

    private ThrowerBase thrower = ThrowerCAN.getInstance();
    private double speed = .1;
    private double RAMP_DELAY = .025;
    private double RAMP_INCREASE = .05;

    public SimpleRaiseCommand() {
        requires(thrower);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        thrower.simpleRaise(speed);
        if (this.speed < 1.0) {
            speed = speed + RAMP_INCREASE;
            Timer.delay(RAMP_DELAY);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !this.thrower.getSwitchTop();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
