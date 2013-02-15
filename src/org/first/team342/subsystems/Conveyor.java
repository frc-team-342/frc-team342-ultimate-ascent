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
    
    public void turnConveyorOn() {
        conveyorMotor.set(-1.0);
        this.isOn = true;
        SmartDashboard.putBoolean("Conveyor", isOn);
    }
    public void reverseConveyor() {
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
