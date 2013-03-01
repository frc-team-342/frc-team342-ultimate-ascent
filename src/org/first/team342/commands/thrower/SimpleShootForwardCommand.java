/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.thrower;

import edu.wpi.first.wpilibj.DriverStation;
import org.first.team342.abstractions.ThrowerBase;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.ThrowerCAN;

/**
 *
 * @author Charlie
 */
public class SimpleShootForwardCommand extends CommandBase {
    private ThrowerBase thrower = ThrowerCAN.getInstance();
    private DriverStation driver = DriverStation.getInstance();
    
    public SimpleShootForwardCommand() {
        requires(thrower);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        this.thrower.throwForward(driver.getAnalogIn(4)/5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        this.thrower.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
