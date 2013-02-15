/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Relay;
import org.first.team342.RobotMap;

/**
 *
 * @author Becwar
 */
public class Lights extends Subsystem {
    private static final Lights INSTANCE = new Lights();
    private Relay red;
    private Relay blue;
//    private Timer timer;
    
    private Lights() {
        super();
        this.red = new Relay(RobotMap.LIGHT_RED);
        this.red.setDirection(Relay.Direction.kForward);
        this.blue = new Relay(RobotMap.LIGHT_BLUE);
        this.blue.setDirection(Relay.Direction.kForward);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static Lights getInstance(){
        return INSTANCE;
    }
    
    public void redOn(){
        blue.set(Relay.Value.kReverse);
        blue.set(Relay.Value.kOn);
//        blue.set(Relay.Value.kOff);
    }
    
    public void blueOn(){
        blue.set(Relay.Value.kForward);
        blue.set(Relay.Value.kOn);
//        red.set(Relay.Value.kOff);
    }
    
    public void bothOn(){
        red.set(Relay.Value.kOn);
        blue.set(Relay.Value.kOn);
    }
    
    public void bothOff(){
        red.set(Relay.Value.kOff);
        blue.set(Relay.Value.kOff);
    }

    public void bothFlashAlternate(double interval){
        redOn();
        Timer.delay(interval);
        blueOn();
        Timer.delay(interval);
    }
   
}
