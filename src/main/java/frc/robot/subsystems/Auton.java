/*

 ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄     ▄▄▄▄      ▄▄▄▄▄▄▄▄▄▄▄ 
▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░▌       ▐░▌  ▄█░░░░▌    ▐░░░░░░░░░░░▌
▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌ ▐░░▌▐░░▌    ▐░█▀▀▀▀▀▀▀▀▀ 
▐░▌          ▐░▌       ▐░▌▐░▌                        ▐░▌ ▐░▌       ▐░▌  ▀▀ ▐░░▌    ▐░█▄▄▄▄▄▄▄▄▄ 
▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌                       ▐░▌  ▐░█▄▄▄▄▄▄▄█░▌     ▐░░▌    ▐░░░░░░░░░░░▌
▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌                      ▐░▌   ▐░░░░░░░░░░░▌     ▐░░▌     ▀▀▀▀▀▀▀▀▀█░▌
▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀ ▐░▌                     ▐░▌     ▀▀▀▀▀▀▀▀▀█░▌     ▐░░▌              ▐░▌
▐░▌          ▐░▌     ▐░▌  ▐░▌                    ▐░▌               ▐░▌     ▐░░▌              ▐░▌
▐░▌          ▐░▌      ▐░▌ ▐░█▄▄▄▄▄▄▄▄▄          ▐░▌                ▐░▌ ▄▄▄▄█░░█▄▄▄  ▄▄▄▄▄▄▄▄▄█░▌
▐░▌          ▐░▌       ▐░▌▐░░░░░░░░░░░▌        ▐░▌                 ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
 ▀            ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀          ▀                   ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ 
(C) FRC 7415 Jaguar Robotics - All rights reserved.
FRC7415-2022 - Robot2022 - Auton.java

*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;

public class Auton {
    
    Drive drivetrain;
    Shooter shooter;
    Intake intake;

    public Auton (Drive driver, Shooter shot, Intake take) {
        drivetrain = driver;
        shooter = shot;
        intake = take;
    }

    public void singleball(Timer autoTime){
      
        if(shooter.elevationLimit() == false){
            shooter.elevateZero();
          }
          
          if(autoTime.get() < 2 && autoTime.get() > 0){
           shooter.autoElevateDown(-100);
          }else if(autoTime.get() >= 2 && autoTime.get() <= 7) {
            shooter.autoElevateUp(71);
          }else if (autoTime.get() >= 7 && autoTime.get() < 9){
            shooter.flywheelsOut();
          }else if (autoTime.get() >= 9 && autoTime.get() < 13){ 
            shooter.flywheelsOut();
            shooter.wheelsOut();
          }else if(autoTime.get() >= 13 && autoTime.get() < 13.4){
            shooter.wheelsOff();
            shooter.flywheelsOff();
            intake.retract();  
            drivetrain.setPower(.25, -.25);
          } else if(autoTime.get() >= 9 && autoTime.get() < 9.7){
            shooter.wheelsOff();
            shooter.flywheelsOff();
            drivetrain.setPower(.2, .2);
          }else {
            shooter.wheelsOff();
            shooter.flywheelsOff();
            drivetrain.setPower(0, 0);
          }
    }


    public void backup(Timer autoTime){
      if(autoTime.get() > 0 && autoTime.get() < 1){
        drivetrain.setPower(.25, -.25);
      }else{
        drivetrain.setPower(0, 0);
      }
    }



public void lowBall(Timer autoTime){
      
  if(shooter.elevationLimit() == false){
      shooter.elevateZero();
    }
    
    if(autoTime.get() < 2 && autoTime.get() > 0){
     shooter.autoElevateDown(-100);
    }else if(autoTime.get() >= 2 && autoTime.get() <= 7) {
      shooter.autoElevateUp(60); //60
      shooter.flywheelsOut();
    }else if (autoTime.get() >= 7 && autoTime.get() < 8){ 
      shooter.flywheelsOut();
      shooter.wheelsOut();
    }else if(autoTime.get() >= 8 && autoTime.get() < 9){
      shooter.wheelsOff();
      shooter.flywheelsOff();
      intake.retract();  
      drivetrain.setPower(.25, -.25);
    } else if(autoTime.get() >= 11 && autoTime.get() < 11.7){
      shooter.wheelsOff();
      shooter.flywheelsOff();
      drivetrain.setPower(.2, .2);
    }else {
      shooter.wheelsOff();
      shooter.flywheelsOff();
      drivetrain.setPower(0, 0);
    }
}
}