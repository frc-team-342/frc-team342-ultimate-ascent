/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.abstractions;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;

/**
 *
 * @author Team 342
 */
public abstract class ThrowerBase extends Subsystem implements Thrower {
    private double targetAngle;
    private SpeedController aim;
    private Gyro gyro;
    
    protected ThrowerBase(){
        this.targetAngle = 0.0;
        this.aim = new Victor(RobotMap.PWM_CHANNEL_AIM);
        this.gyro = new Gyro(RobotMap.ANALOG_CHANNEL_GYRO);
    }

    public void initDefaultCommand() {
    }
    
    public void moveToAngle(double angle){
        if (this.gyro.getAngle() - RobotMap.GYRO_DEAD_ZONE < angle){
            this.aim.set(.5);
            this.targetAngle = this.gyro.getAngle();
        }else if (this.gyro.getAngle() + RobotMap.GYRO_DEAD_ZONE > angle){
            this.aim.set(-.5);
            this.targetAngle = this.gyro.getAngle();
        }else {
            this.aim.set(0.0);
        }
    }

    public void increseAngle(double angle) {
        this.targetAngle =(this.targetAngle + angle);
       if (this.gyro.getAngle() - RobotMap.GYRO_DEAD_ZONE < this.targetAngle){
            this.aim.set(.5);
        }else if (this.gyro.getAngle() + RobotMap.GYRO_DEAD_ZONE > this.targetAngle){
            this.aim.set(-.5);
        }else {
            this.aim.set(0.0);
        }
    }

    public void decreaseAngle(double angle) {
         this.targetAngle =(this.targetAngle - angle);
       if (this.gyro.getAngle() - RobotMap.GYRO_DEAD_ZONE < this.targetAngle){
            this.aim.set(.5);
            this.targetAngle = this.gyro.getAngle();
        }else if (this.gyro.getAngle() + RobotMap.GYRO_DEAD_ZONE > this.targetAngle){
            this.aim.set(-.5);
            this.targetAngle = this.gyro.getAngle();
        }else {
            this.aim.set(0.0);
        }
    }

    public void simpleRaise(double speed) {
        this.aim.set(speed);
    }

    public void simpleLower(double speed) {
        this.aim.set(-speed);
    }
    public void resetGyro(){
        this.gyro.reset();
    }
}
