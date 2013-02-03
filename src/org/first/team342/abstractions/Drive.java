/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.abstractions;

import edu.wpi.first.wpilibj.Joystick;
import org.first.team342.Controller;

/**
 *
 * @author Charlie
 */
public interface Drive {
    public void driveWithJoystick(Controller joystick);
    public void rammingSpeed(Joystick joystick);
    public void turn(double speed);
    public void turnLeft(double speed, double angle);
    public void turnRight(double speed, double angle);
    public void turnLeft(double speed);
    public void turnRight(double speed);
    public void center();
    public void forward(double speed, double distance);
    public void reverse(double speed, double distance);
    public void forward(double speed);
    public void reverse(double speed);
}
