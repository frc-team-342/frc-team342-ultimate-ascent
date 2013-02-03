/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.first.team342.RobotMap;

/**
 *
 * @author Charlie
 */
public class Conveyor extends Subsystem {
    private static final Conveyor INSTANCE = new Conveyor();
    
    // TODO: refactor this variable to "conveyorOn".
    private boolean isOn;
    
    private SpeedController conveyorMotor;
    
    private Conveyor() {
        this.conveyorMotor = new Talon(RobotMap.PWM_CHANNEL_CONVEYOR);
        isOn = false;
    }
    
    public static Conveyor getInstance() {
        return INSTANCE;
    }
    
//    public void conveyorToggle() {
//        if(isOn) {
//            this.conveyorOff();
//        } else {
//            // refactor these lines in to a method called "turnConveyorOn".
//            conveyorMotor.set(1.0);
//            this.isOn = true;
//        }
//    }
    
    
    public void turnConveyorOff() {
        conveyorMotor.set(0.0);
        this.isOn = false;
        SmartDashboard.putBoolean("Conveyor", isOn);
    }
    
    public void conveyorOn() {
        conveyorMotor.set(-1.0);
        this.isOn = true;
        SmartDashboard.putBoolean("Conveyor", isOn);
    }
    
    // TODO: add method "turnConveyorOn"
    
    // TODO: refactor method name to "reverseConveyor"
    public void conveyorReverse() {
        conveyorMotor.set(1.0);
        SmartDashboard.putBoolean("Conveyor", false);
    }

    public boolean isConveyorOn() {
        return this.isOn;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
