/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;

/**
 *
 * @author Charlie
 */
public class Pusher extends Subsystem {
    
    private static final Pusher INSTANCE = new Pusher();
    
    private Victor pusherMotor;
    
    private DigitalInput back;
    
    private DigitalInput side;
    
    private Pusher() {
        this.pusherMotor = new Victor(RobotMap.PWM_CHANNEL_FIRE);
        this.back = new DigitalInput(RobotMap.DIO_CHANNEL_FIRE_BACK);
        this.side = new DigitalInput(RobotMap.DIO_CHANNEL_FIRE);
    }
    
    public static Pusher getInstance() {
        return INSTANCE;
    }
    
    public void initDefaultCommand() {
    }
    
    public void forward() {
        if (this.side.get()) {
            this.pusherMotor.set(1.0);
        } else {
            this.stop();
        }
    }
    
    public void reverse() {
        if(!this.back.get()) {
            this.pusherMotor.set(-1.0);
        } else {
            this.stop();
        }
    }

    public void stop() {
        this.pusherMotor.set(0.0);
    }
    
    public boolean isBack() {
        return this.back.get();
    }
}
