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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;

/**
 *
 * @author Team 342
 */
public class Elevator extends Subsystem {

    private static final Elevator INSTANCE = new Elevator();
    private Victor elevatorMotor;
    private DigitalInput top;
    private DigitalInput bottom;

    private Elevator() {
        super();
        this.elevatorMotor = new Victor(RobotMap.PWM_CHANNEL_ELEVATOR);
        this.top = new DigitalInput(RobotMap.DIO_CHANNEL_ELEVATOR_TOP);
        this.bottom = new DigitalInput(RobotMap.DIO_CHANNEL_ELEVATOR_BOTTOM);
    }

    protected void initDefaultCommand() {
    }

    public static Elevator getInstance() {
        return INSTANCE;
    }

    public void raise(double speed) {
        boolean atTop = top.get();
        if(!atTop){
        this.elevatorMotor.set(speed);
        }else{
            this.elevatorMotor.set(0);
        }
    }    
    
    public void lower(double speed) {
        boolean atBottom = bottom.get();
        if(!atBottom){
        this.elevatorMotor.set(-speed);
        }else{
            this.elevatorMotor.set(0);
        }
    }
    
    public void stop() {
        this.elevatorMotor.set(0);
    }

}
