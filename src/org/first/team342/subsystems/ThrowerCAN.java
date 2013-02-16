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

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
import org.first.team342.abstractions.ThrowerBase;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Team 342
 */
public class ThrowerCAN extends ThrowerBase {

    protected static final ThrowerBase INSTANCE = new ThrowerCAN();
    protected CANJaguar front;
    protected CANJaguar back;
    protected Timer timer;
    
    protected ThrowerCAN() {
        super();
        this.front = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_THROWER_FRONT);
        this.back = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_THROWER_BACK);

        try {
            if (this.front != null) {
                this.front.changeControlMode(CANJaguar.ControlMode.kSpeed);
                this.front.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
                this.front.configEncoderCodesPerRev(360);
                this.front.enableControl();
            }
            if (this.back != null) {
                this.back.changeControlMode(CANJaguar.ControlMode.kSpeed);
                this.back.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
                this.back.configEncoderCodesPerRev(360);
                this.back.enableControl();
            }

            this.updatePID();
        } catch (CANTimeoutException e) {
            System.out.println("An error occured initializing the thrower motors.");
        }
    }

    protected void initDefaultCommand() {
    }

    public static ThrowerBase getInstance() {
        return INSTANCE;
    }

    public void throwForward(double value) {
         try {
            if (this.front != null) {
                this.front.setX(value);
            }

            if (this.back != null) {
                this.back.setX(value);
            }
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void throwReverse(double value) {
        try {
            if (this.front != null) {
                this.front.setX(-value);
            }

            if (this.back != null) {
                this.back.setX(-value);
            }
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    

    public void stop() {
        try {
            if (this.front != null) {
                this.front.setX(0.0);
            }

            if (this.back != null) {
                this.back.setX(0.0);
            }
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void reverse() {
    }

    public double getFrontSpeed() {
        double value = 0.0;
        try {
            if (this.front != null) {
                value = this.front.getSpeed();
            }
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        return value;
    }

    public final void updatePID() {
        Preferences preferences = Preferences.getInstance();
        double proportionalGain = preferences.getDouble("Thrower_Proportional", 0.0);
        double integralGain = preferences.getDouble("Thrower_Integral", 0.0);
        double derivativeGain = preferences.getDouble("Thrower_Derivative", 0.0);

        try {
            if (this.front != null) {
                this.front.setPID(proportionalGain, integralGain, derivativeGain);
            }
            if (this.back != null) {
                this.back.setPID(proportionalGain, integralGain, derivativeGain);
            }
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
