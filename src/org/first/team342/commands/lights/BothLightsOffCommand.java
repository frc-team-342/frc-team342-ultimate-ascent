/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.lights;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Lights;

/**
 *
 * @author Charlie
 */
public class BothLightsOffCommand extends CommandBase {
    private Lights lights = Lights.getInstance();
    
    public BothLightsOffCommand() {
        requires(lights);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        lights.bothOff();
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
