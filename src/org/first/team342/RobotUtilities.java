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
package org.first.team342;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 * Random utilities for robot operation.
 * 
 * @author FIRST Team 342
 */
public class RobotUtilities {
    /**
     * Initialize a CAN Jaguar device with the given device address.
     * 
     * @param deviceNumber the CAN device address.
     * 
     * @return the initialized CAN device.  If an error occurs then <code>null<code> is returned.
     */
    public static CANJaguar initializeCANJaguar(int deviceNumber) {
        CANJaguar jaguar = null;

        try {
            jaguar = new CANJaguar(deviceNumber);
        } catch (CANTimeoutException ex) {
            System.out.println(ex.getMessage() + " - Device Number: " + deviceNumber);
        }

        return jaguar;
    }
    public static int getIntSmartDashboard(String key){
        double value = 0.0;
        try{
        value = SmartDashboard.getNumber(key);
        }catch(TableKeyNotDefinedException ex){
            System.out.println("can not find key:" + key);
        }
        return (int)value;
    }
}
