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
FRC7415-2022 - Robot2022 - Shooter.java

*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Shooter {
    private WPI_TalonFX elevateMotor;
    private WPI_TalonFX wheelslMotor;
    //private WPI_TalonFX wheelsrMotor;
    private WPI_TalonFX flywheelslMotor;
    private WPI_TalonFX flywheelsrMotor;
    private DigitalInput elevateLimit;
    private MotorControllerGroup wheels;
    private MotorControllerGroup flywheels;

    public Shooter(int elevate, int flywheelsr, int flywheelsl, int wheelsr, int wheelsl, int limit){
        elevateMotor = new WPI_TalonFX(elevate);
        wheelslMotor = new WPI_TalonFX(wheelsl);
        //wheelsrMotor = new WPI_TalonFX(wheelsr);
        flywheelslMotor = new WPI_TalonFX(flywheelsl);
        flywheelsrMotor = new WPI_TalonFX(flywheelsr);
        elevateLimit = new DigitalInput(limit);
        elevateMotor.setNeutralMode(NeutralMode.Brake);
        //wheelsrMotor.setNeutralMode(NeutralMode.Coast);
        wheelslMotor.setNeutralMode(NeutralMode.Coast);
        wheelslMotor.setInverted(true);
        flywheelslMotor.setInverted(true);
        flywheelsrMotor.setNeutralMode(NeutralMode.Coast);
        flywheelslMotor.setNeutralMode(NeutralMode.Coast);
        //wheels = new MotorControllerGroup(wheelsrMotor, wheelslMotor);
        flywheels = new MotorControllerGroup(flywheelslMotor, flywheelsrMotor);

    }

    public void elevateUp(){
        elevateMotor.set(0.8);
    }

    public void idle(){
        elevateMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void elevateDown(){
        if(elevationLimit() == false){
            elevateMotor.set(0);
        }else{
            elevateMotor.set(-0.8);
        }
    }

    public void autoElevateUp(double x)
    {
        if(elevateEncoder() <= x){
            elevateMotor.set(0.8);
        }else if (elevateEncoder() > x ){
            elevateMotor.set(0);
        }else {
           
            elevateMotor.set(0);
        }
        //}
        //elevateMotor.set(0);
    }

    public void autoElevateDown(double x)
    {
        if(elevateEncoder() >= x && elevationLimit() == true){
            elevateMotor.set(-0.8);
        }else{
            elevateMotor.set(0);
        }
        //}
        //elevateMotor.set(0);
    }

    
    public void elevateOff(){
        elevateMotor.set(0);
    }

    public double elevateEncoder(){
        return(elevateMotor.getSelectedSensorPosition()/(2048*480)/(.25/90));
    }

    public void elevateZero(){
        elevateMotor.setSelectedSensorPosition(0);
    }

    public void wheelsIn(){
        wheels.set(0.25);
    }

    public void wheelsOut(){
        wheels.set(-0.25);
    }

    public void wheelsOff(){
        wheelslMotor.set(0);
    }

    public void flywheelsIn(){
        flywheels.set(-0.50);
    }

    public void flywheelsOut(){
        flywheels.set(1);
    }

    public void flywheelsOff(){
        flywheels.set(0);
    }

    public boolean elevationLimit(){
        return(elevateLimit.get());
    }
}
