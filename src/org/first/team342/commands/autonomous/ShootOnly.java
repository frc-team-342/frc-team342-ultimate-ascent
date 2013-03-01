/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.first.team342.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.first.team342.commands.thrower.PushStopCommand;
import org.first.team342.commands.thrower.SimpleShootForwardCommand;
import org.first.team342.commands.thrower.ThrowerOffCommand;
import org.first.team342.commands.pusher.PusherTimedForwardCommand;
import org.first.team342.commands.pusher.PusherReverseCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author Team 342
 */
public class ShootOnly extends CommandGroup {

    private static final double SHOOTER_TIMEOUT = 10.0;
    private static final double TIMEOUT = 2.0;

    public ShootOnly() {
      // Spin up Shooter.
      this.addParallel(new SimpleShootForwardCommand());
      
      this.addSequential(new WaitCommand(2.0));
      
      // Shoot First.
      this.addSequential(new PusherTimedForwardCommand(2.0));
      this.addSequential(new PusherReverseCommand());
      
       this.addSequential(new WaitCommand(2.0));
      
      // Shoot Second.
       this.addSequential(new PusherTimedForwardCommand(2.0));
       this.addSequential(new PusherReverseCommand());
       
        this.addSequential(new WaitCommand(2.0));
        
       // Shoot Third.
       this.addSequential(new PusherTimedForwardCommand(2.0));
       this.addSequential(new PusherReverseCommand());

       // Turn off the shooter.
       this.addSequential(new ThrowerOffCommand());
    }
    
    protected void initialized() {
      
    }
    
    public boolean isFinished() {
      return false;
    }
}
