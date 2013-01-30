/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Team 342
 */
public class Controller extends Joystick{

    public Controller(int port) {
        super(port);
    }
    
    public double getLeftY(){
        return this.getY();
    }
    public double getLeftX(){
        return this.getX();
    }
    public double getRightY(){
        return this.getRawAxis(4);
    }
    public double getRightX(){
        return this.getZ();
    }
}
