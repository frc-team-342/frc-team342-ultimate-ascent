/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.first.team342.RobotMap;
import org.first.team342.RobotUtilities;
/**
 *
 * @author Team 342
 */
public class Thrower extends Subsystem {
    private SpeedController front;
    private SpeedController rear;
    private Thrower() {
        this.front = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_THROWER_FRONT);
        this.front = RobotUtilities.initializeCANJaguar(RobotMap.CAN_DEVICE_THROWER_BACK);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
