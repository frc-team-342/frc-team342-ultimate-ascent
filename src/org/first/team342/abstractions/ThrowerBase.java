/*
 * Copyright 2013 FRC Team 342
 * 
 * This file is part of "FRC Team 342 Ultimate Ascent Robot".
 * 
 * "FRC Team 342 Ultimate Ascent Robot" is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *
 * "FRC Team 342 Ultimate Ascent Robot" is distributed in the hope that it
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty 
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "FRC Team 342 Ultimate Ascent Robot".  If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.first.team342.abstractions;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;

/**
 *
 * @author Team 342
 */
public abstract class ThrowerBase extends Subsystem implements Thrower {
    
    private double targetAngle;
    private SpeedController aim;
//    private Gyro gyro;
    private DigitalInput top;
    private DigitalInput bottom;
    protected Victor pushMotor;
    protected AnalogChannel potentiometer;
    protected DigitalInput pushLimitSwitch;
    protected Timer timer;
    protected DriverStation driver;
    
    protected ThrowerBase() {
        super();
        this.targetAngle = 0.0;
        this.aim = new Victor(RobotMap.PWM_CHANNEL_AIM);
//        this.gyro = new Gyro(RobotMap.ANALOG_CHANNEL_GYRO);
        this.top = new DigitalInput(RobotMap.DIO_CHANNEL_THROWER_TOP);
        this.bottom = new DigitalInput(RobotMap.DIO_CHANNEL_THROWER_BOTTOM);
        this.pushMotor = new Victor(RobotMap.PWM_CHANNEL_FIRE);
        this.pushLimitSwitch = new DigitalInput(RobotMap.DIO_CHANNEL_FIRE);
        this.potentiometer = new AnalogChannel(RobotMap.ANALOG_CHANNEL_POTENTIOMETER);
        this.driver = DriverStation.getInstance();
    }

//    public void moveToAngle(double angle) {
//        if (this.top.get()) {
//            this.aim.set(0.0);
//        } else if (this.bottom.get()) {
//            this.aim.set(0.0);
//            this.gyro.reset();
//        } else if (this.gyro.getAngle() - RobotMap.GYRO_DEAD_ZONE < angle) {
//            this.aim.set(.5);
//            this.targetAngle = this.gyro.getAngle();
//        } else if (this.gyro.getAngle() + RobotMap.GYRO_DEAD_ZONE > angle) {
//            this.aim.set(-.5);
//            this.targetAngle = this.gyro.getAngle();
//        } else {
//            this.aim.set(0.0);
//        }
//    }
//    
//    public void increseAngle(double angle) {
//        this.targetAngle = (this.targetAngle + angle);
//        if (this.top.get()) {
//            this.aim.set(0.0);
//        } else if (this.gyro.getAngle() - RobotMap.GYRO_DEAD_ZONE < this.targetAngle) {
//            this.aim.set(.5);
//        } else if (this.gyro.getAngle() + RobotMap.GYRO_DEAD_ZONE > this.targetAngle) {
//            this.aim.set(-.5);
//        } else {
//            this.aim.set(0.0);
//        }
//    }
//
//    public void decreaseAngle(double angle) {
//        this.targetAngle = (this.targetAngle - angle);
//        if (this.bottom.get()) {
//            this.aim.set(0.0);
//            this.gyro.reset();
//        } else if (this.gyro.getAngle() - RobotMap.GYRO_DEAD_ZONE < this.targetAngle) {
//            this.aim.set(.5);
//            this.targetAngle = this.gyro.getAngle();
//        } else if (this.gyro.getAngle() + RobotMap.GYRO_DEAD_ZONE > this.targetAngle) {
//            this.aim.set(-.5);
//            this.targetAngle = this.gyro.getAngle();
//        } else {
//            this.aim.set(0.0);
//        }
//    }
    public void simpleRaise(double speed) {
        if (!this.top.get()) {
            this.aim.set(0.0);
        } else {
            this.aim.set(speed);
        }
    }
    
    public void moveToAngle(double angle) {
        /*
         * double uncertainty = 1.0; if (!this.top.get()) { this.aim.set(0.0); }
         * else if (!this.bottom.get()) { this.aim.set(0.0); } else if
         * (this.convertAngle(this.potentiometer.getVoltage()) + uncertainty <
         * angle) { this.aim.set(.5); } else if
         * (this.convertAngle(this.potentiometer.getVoltage()) - uncertainty >
         * angle) { this.aim.set(-.5); } else { this.aim.set(0.0); }
         */
        double aimOut = (this.driver.getAnalogIn(3) / 10) * (angle - this.convertAngle());
        if (aimOut > 1){
            aimOut = 1;
        }
       if (aimOut < .3) {
            aimOut = .3;
        }
       this.aim.set(-aimOut);
       System.out.println("Aim Out :" + aimOut);
    }

    //TODO: fix target angle settings
    public void increseAngle(double angle) {
        if (!this.top.get()) {
            this.aim.set(0.0);
        } else if (this.convertAngle(this.potentiometer.getVoltage()) < this.targetAngle) {
            this.aim.set(.5);
        } else if (this.convertAngle(this.potentiometer.getVoltage()) > this.targetAngle) {
            this.aim.set(-.5);
        } else {
            this.aim.set(0.0);
        }
    }

    //TODO: fix target angle settings
    public void decreaseAngle(double angle) {
        this.targetAngle = (this.targetAngle - angle);
        if (!this.bottom.get()) {
            this.aim.set(0.0);
        } else if (this.convertAngle(this.potentiometer.getVoltage()) - RobotMap.GYRO_DEAD_ZONE < this.targetAngle) {
            this.aim.set(.5);
//            this.targetAngle = this.gyro.getAngle();
        } else if (this.convertAngle(this.potentiometer.getVoltage()) + RobotMap.GYRO_DEAD_ZONE < this.targetAngle) {
            this.aim.set(-.5);
//            this.targetAngle = this.gyro.getAngle();
        } else {
            this.aim.set(0.0);
        }
    }
    
    public void potentiometerTest() {
        double rawValue = this.potentiometer.getVoltage();
        System.out.println("Raw Value: " + rawValue);
//        SmartDashboard.putNumber("Raw Value: ", rawValue);
        double angleValue = this.convertAngle(rawValue);
//        SmartDashboard.putNumber("Angle Value: ", angleValue);
        System.out.println("Angle Value: " + angleValue);
    }
    
    public void simpleLower(double speed) {
        if (!this.bottom.get()) {
            this.aim.set(0.0);
//            this.gyro.reset();
        } else {
            this.aim.set(-speed);
        }
    }
    
    public void aimMotorStop() {
        this.aim.set(0.0);
    }
    
    public void pushMotorSet(double value) {
        pushMotor.set(value);
        System.out.println("vex motor running");
    }
    
    public void push(double value) {
        if (pushLimitSwitch.get()) {
            pushMotor.set(value);
        } else {
            pushMotor.set(0.0);
        }
    }
    
    public boolean getSwitch() {
        return pushLimitSwitch.get();
    }
    
    public double convertAngle(double input) {
        double angleConstant = 60.0;
        double angle = input * angleConstant;
        return angle;
    }

    //JH - Added method that gets pot volts on its own
    public double convertAngle() {
        double angleConstant = 60.;//JH - Move with the other constants
        double angle = angleConstant * this.potentiometer.getVoltage();
        return angle;
    }
//    public void resetGyro() {
//        this.gyro.reset();
//    }
}
