/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.thrower;

import org.first.team342.RobotMap;
import org.first.team342.abstractions.ThrowerBase;
import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.PiStreem;
import org.first.team342.subsystems.ThrowerCAN;

/**
 *
 * @author Charlie
 */
public class MoveToAngleCameraCommand extends CommandBase {
    private int targetPixel = RobotMap.AIM_CENTER_TARGET_PIXEL_VERTICAL;
    private int currentPixel;
    private double speed;
    private PiStreem piStream = PiStreem.getInstance();
    private ThrowerBase thrower = ThrowerCAN.getInstance();

    public MoveToAngleCameraCommand(double speed) {
        requires(thrower);
        this.speed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    System.out.println("[DEBUG] MoveToAngleCommand initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        this.currentPixel =  4; //(int) piStream.getData();
        this.thrower.moveToAngleCamera(this.speed, this.targetPixel, this.currentPixel);
        System.out.println("[DEBUG] MoveToAngleCommand executed");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
