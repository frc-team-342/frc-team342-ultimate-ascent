/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.abstractions;

/**
 *
 * @author Team 342
 */
public interface Thrower {

    double speed = 0.0;

    public void setSpeed(double flyWheelSpeed);

    public void on();

    public void off();

    public void reverse();

    public double getSpeed();

    public void moveToAngle(double angle);

    public void increseAngle(double angle);

    public void decreaseAngle(double angle);

    public void simpleRaise(double speed);

    public void simpleLower(double speed);
    
    public void resetGyro();
}
