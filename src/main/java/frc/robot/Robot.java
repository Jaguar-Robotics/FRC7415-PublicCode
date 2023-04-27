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
FRC7415-2022 - Robot2022 - Robot.java

*/

package frc.robot; // Import Robot Package

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick; // Import Joystick
import edu.wpi.first.wpilibj.TimedRobot; // Import TimedRobot
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
  
  private Drive drivetrain = new Drive(Constants.LEFTONE, Constants.LEFTTWO, Constants.LEFTTHREE, Constants.RIGHTONE, Constants.RIGHTTWO, Constants.RIGHTTHREE);
  private Shooter shooter = new Shooter(Constants.SHOOTERELEVATE, Constants.SHOOTERFLYWHEELSR, Constants.SHOOTERFLYWHEELSL, Constants.SHOOTERWHEELSR, Constants.SHOOTERWHEELSL, Constants.ELEVATELIMIT);
  private Intake intake = new Intake(Constants.INTAKEMOTOR, Constants.INTAKE1, Constants.INTAKE2);
  private Climb climb = new Climb(Constants.CLIMBMID, Constants.CLIMBLEFT, Constants.CLIMBRIGHT, shooter);
  private Auton auton = new Auton(drivetrain, shooter, intake); 
  private final Joystick m_stick = new Joystick(Constants.DriverJoystick); // Define Joystick
  private final Joystick m_stick2 = new Joystick(Constants.OpJoystick); // Define Joystick
  private final Joystick m_stick3 = new Joystick(2);
  private Timer autoTime = new Timer();
  private double driveSens = 1;
  private String autonSelect;

  @Override
  public void teleopPeriodic() {
    drivetrain.setArcadeDrive(driveSens*m_stick.getY(), -driveSens*m_stick.getX()); // Create Arcade Drive / Reverse Y Axis  
    
    if(m_stick.getRawButtonPressed(7)){
      driveSens = .5;
    }

    if(m_stick.getRawButtonPressed(8)){
      driveSens = 1;
    }

    if(m_stick.getRawButtonPressed(9)){
      driveSens = .75;
    }

    if(shooter.elevationLimit() == false){
      shooter.elevateZero();
    }

    if(m_stick2.getRawButton(2)){
      intake.motorSuck();
      shooter.flywheelsIn();
    }else if(m_stick2.getRawButton(1)){
      shooter.flywheelsOut();
    }else{
      intake.motorOff();
      shooter.flywheelsOff();
    }

    

    if(m_stick2.getRawButton(6)){
      shooter.wheelsIn();
    }else if(m_stick2.getRawButton(4)){
      shooter.wheelsOut();
    }else{
      shooter.wheelsOff();
    }

    if(m_stick2.getRawButton(5) || m_stick3.getRawButton(6)){
      shooter.elevateDown();
    }else if(m_stick2.getRawButton(3) || m_stick3.getRawButton(5)){
      shooter.elevateUp();
    }else if(m_stick2.getRawButton(7)){
        shooter.autoElevateUp(60);
    }else if(m_stick2.getRawButton(8)){
      shooter.autoElevateUp(70);
    }else{
      shooter.elevateOff();
    }

    if(m_stick3.getRawButton(3)){
      climb.vertClimb();
    }else if(m_stick3.getRawButton(1)){
      climb.vertUnClimb();
    }else{
      climb.vertOff();
    }

    if(m_stick3.getRawButton(4)){
      climb.midClimb();
    }else if(m_stick3.getRawButton(2)){
      climb.midUnClimb();
    }else{
      climb.midOff();
    }
    
      if(shooter.elevateEncoder() >= 30){
      intake.retract();
      }else{
        intake.extend();
      }

      /*if(m_stick3.getRawButtonPressed(8)){
        shooter.idle();
      }*/
    }

  @Override
  public void autonomousInit(){
    intake.extend();
    autoTime.reset();
    autoTime.start();
  }

  @Override
  public void autonomousPeriodic() {
    //double time = autoTime.get();
    if(autonSelect.equals("SingleBall")){
      auton.singleball(autoTime);
    }else if(autonSelect.equals("Backup")){
      auton.backup(autoTime);
    }else if(autonSelect.equals("None")){
    }

    
    /*
    
    */
    
    

  }

  @Override
  public void teleopInit(){
    
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("MidClimb", climb.midEncoder());
    SmartDashboard.putNumber("LeftClimb", climb.leftEncoder());
    SmartDashboard.putNumber("RightClimb", climb.rightEncoder());
    SmartDashboard.putNumber("Elevate", shooter.elevateEncoder());
    SmartDashboard.putBoolean("Limit Switch", shooter.elevationLimit()); 
    SmartDashboard.putNumber("Match Time", DriverStation.getMatchTime());
    //SmartDashboard.putNumber("FlywheelsL", shooter.flywheelsLRPM());
    //SmartDashboard.putNumber("FlywheelsR", shooter.flywheelsRRPM());
    
    autonSelect = SmartDashboard.getString("Autonomous Selection", "");
  }

  @Override
  public void robotInit() {
    drivetrain.zeroEncoders();
    climb.zeroEncoders();
    CameraServer.startAutomaticCapture(); // Start Camera Server
    SmartDashboard.putString("Autonomous Selection", "SingleBall");
  }
}