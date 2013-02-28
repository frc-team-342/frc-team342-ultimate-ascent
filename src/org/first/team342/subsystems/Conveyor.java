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
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
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
    private boolean isGoingUp;
    private Victor conveyorMotor;
    private SpeedController pickupMotor;
    
    private Conveyor() {
        this.conveyorMotor = new Victor(RobotMap.PWM_CHANNEL_CONVEYOR);
        this.pickupMotor = new Victor(RobotMap.PWM_CHANNEL_CONVEYOR_PICKUP);
        this.pickupMotor.set(-1.0);
        isOn = false;
        isGoingUp = true;
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
    
//    public void updateConveyor(){
//        if (this.isOn){
//            if (this.isGoingUp){
//                conveyorMotor.set(1.0);
//        System.out.println("Conveyor going up");
//            } else {
//                conveyorMotor.set(-1.0);
//        System.out.println("Conveyor going down");
//            }
//        }else {
//            conveyorMotor.set(0.0);
//        System.out.println("Conveyor off");
//        }
//    }
//    
//    public void toggleOn(){
//        this.isOn = !this.isOn;
//        System.out.println("Conveyor toggled on");
//    }
//    
//    public void toggleDirection(){
//        this.isGoingUp = !this.isGoingUp;
//        System.out.println("Conveyor direction toggled");
//    }

    public void conveyorOff() {
        conveyorMotor.set(0.0);
        this.isOn = false;
        SmartDashboard.putBoolean("Conveyor", isOn);
    }
    
    public void conveyorOn() {
        conveyorMotor.set(-1.0);
        this.isOn = true;
//        this.isGoingUp = true;
        SmartDashboard.putBoolean("Conveyor", isOn);
    }
    public void conveyorReverse() {
        conveyorMotor.set(1.0);
        this.isOn = true;
//        this.isGoingUp = false;
        SmartDashboard.putBoolean("Conveyor Up ", isGoingUp);
    }

    public boolean isConveyorOn() {
        return this.isOn;
    }
    
//    public boolean isConveyorGoingUp(){
//        return this.isGoingUp;
//    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
