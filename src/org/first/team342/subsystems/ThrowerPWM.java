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

import edu.wpi.first.wpilibj.Jaguar;
import org.first.team342.RobotMap;
import org.first.team342.abstractions.ThrowerBase;

/**
 *
 * @author Team 342
 */
public class ThrowerPWM extends ThrowerBase {

    protected static final ThrowerBase INSTANCE = new ThrowerPWM();
    protected Jaguar front;
    protected Jaguar back;

    protected ThrowerPWM() {
        super();
        this.front = new Jaguar(RobotMap.PWM_DEVICE_THROWER_FRONT);
        this.back = new Jaguar(RobotMap.PWM_DEVICE_THROWER_BACK);
    }

    protected void initDefaultCommand() {
    }

    public static ThrowerBase getInstance() {
        return INSTANCE;
    }

    public void throwForward(double value) {
         
            if (this.front != null) {
                this.front.set(value);
            }

            if (this.back != null) {
                this.back.set(value);
            
        }
    }

    public void throwReverse(double value) {
            if (this.front != null) {
                this.front.set(-value);
            }

            if (this.back != null) {
                this.back.set(-value);
            }
    }

    public void stop() {
            if (this.front != null) {
                this.front.set(0.0);
            }

            if (this.back != null) {
                this.back.set(0.0);
            }
    }

    public void reverse() {
    }

    public double getFrontSpeed() {
        return 0.0;
    }

}
