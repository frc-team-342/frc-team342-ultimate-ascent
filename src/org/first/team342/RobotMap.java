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

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //drive motor addresses old robot
    /*public static final int CAN_DEVICE_LEFT_FRONT_DRIVE_MOTOR = 5;
    public static final int CAN_DEVICE_RIGHT_FRONT_DRIVE_MOTOR = 6;
    public static final int CAN_DEVICE_RIGHT_REAR_DRIVE_MOTOR = 7;
    public static final int CAN_DEVICE_LEFT_REAR_DRIVE_MOTOR = 8;
    */
    //drive constants
    public static final double DRIVE_CENTERING_CONASTANT_PIXEL = 10.0;
    public static final double DRIVE_CENTERING_CONASTANT_DELTA = 20.0;
    //robot CAN dirve motors
    public static final int CAN_DEVICE_RIGHT_FRONT_DRIVE_MOTOR = 1;
    public static final int CAN_DEVICE_LEFT_FRONT_DRIVE_MOTOR = 2;
    public static final int CAN_DEVICE_LEFT_REAR_DRIVE_MOTOR = 3;
    public static final int CAN_DEVICE_RIGHT_REAR_DRIVE_MOTOR = 4;
    //robot PWM drive motors
    public static final int PWM_DEVICE_RIGHT_FRONT_DRIVE_MOTOR = 1;
    public static final int PWM_DEVICE_LEFT_FRONT_DRIVE_MOTOR = 2;
    public static final int PWM_DEVICE_LEFT_REAR_DRIVE_MOTOR = 3;
    public static final int PWM_DEVICE_RIGHT_REAR_DRIVE_MOTOR = 4;
    //Thrower Constants
    public static final int GYRO_DEAD_ZONE = 3;
    public static final double POTENTIOMETER_UNCERTAINTY = 1.0;
    public static final int DIO_CHANNEL_THROWER_TOP = 11;
    public static final int DIO_CHANNEL_THROWER_BOTTOM = 12;
    public static final int DIO_CHANNEL_FIRE = 10;
    public static final int ANALOG_CHANNEL_POTENTIOMETER = 3;
    //thrower motors
    public static final int CAN_DEVICE_THROWER_FRONT = 5;
    public static final int CAN_DEVICE_THROWER_BACK = 6;
    public static final int PWM_DEVICE_THROWER_FRONT = 5;
    public static final int PWM_DEVICE_THROWER_BACK = 6;    
    public static final int PWM_CHANNEL_AIM = 10;
    public static final int PWM_CHANNEL_FIRE = 9;
    //Gyro constants
    public static final int ANALOG_CHANNEL_GYRO = 1;
    //conveyor
    public static final int PWM_CHANNEL_CONVEYOR = 7;
    //elevator 
    public static final int PWM_CHANNEL_ELEVATOR = 8;
    public static final int DIO_CHANNEL_ELEVATOR_TOP = 13;
    public static final int DIO_CHANNEL_ELEVATOR_BOTTOM = 14;
    
    //LED color lights
    public static final int LIGHT_RED = 4;
    public static final int LIGHT_BLUE = 3;
    //controller location
    public static final int JOYSTICK_DRIVE_CONTROL = 1;
    //Default position in the CRIO for the side car
    public static final int DEFAULT_ANNALOG_SLOT = 1;
    //driverstation slidder to set speed
    public static final int RAMMING_SPEED = 1;
    public static final int AUTONOMOUS_CENTER = 2;
}
