package org.first.team342.commands.pusher;

import org.first.team342.commands.CommandBase;
import org.first.team342.subsystems.Pusher;
import edu.wpi.first.wpilibj.Timer;

public class PusherTimedForwardCommand extends CommandBase {
  
  private Pusher pusher = Pusher.getInstance();
  
  private double seconds;
  
  private Timer timer;
  
  private double startTime;
  
  public PusherTimedForwardCommand(double seconds) {
    requires(this.pusher);
    this.seconds = seconds;
    this.timer = new Timer();
  }
  
  public void start() {
    
  }
  
  protected void initialize() {
    System.out.println("initialize()");
    this.timer.start();
    this.startTime = timer.get();
    System.out.println("start() --> " + this.startTime);
  }
  
  protected void execute() {
    this.pusher.forward();
  }
  
  protected boolean isFinished() {
    double currentTime = this.timer.get();
    System.out.println("isFinished() --> " + currentTime + " - " + ((currentTime - startTime) > this.seconds));
    return (currentTime - startTime) > this.seconds;
  }
  
  protected void interrupted() {
  }
  
  protected void end() {
    this.pusher.stop();
  }
}