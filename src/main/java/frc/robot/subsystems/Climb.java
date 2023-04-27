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
FRC7415-2022 - Robot2022 - Climb.java

*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Climb {

    WPI_TalonFX climbMid;
    WPI_TalonFX climbLeft;
    WPI_TalonFX climbRight;
    MotorControllerGroup climbVertical;
    Shooter shooter;

    public Climb (int climb1, int climb2, int climb3, Shooter shot){
        shooter = shot; 
        climbMid = new WPI_TalonFX(climb1); 
        climbLeft = new WPI_TalonFX(climb2);
        climbRight = new WPI_TalonFX(climb3);
        climbLeft.setInverted(true);
        climbMid.setInverted(true);
        climbMid.setNeutralMode(NeutralMode.Brake);
        climbLeft.setNeutralMode(NeutralMode.Brake);
        climbRight.setNeutralMode(NeutralMode.Brake);
        climbVertical = new MotorControllerGroup(climbLeft, climbRight);
    }

    
    public void midClimb(){
        if(midEncoder() >= 8){
            climbMid.set(0);
        }else{
            climbMid.set(.5);
        }
    }

    public void midUnClimb(){
        if(midEncoder() <= 0.25){
            climbMid.set(0);
        }else{
            climbMid.set(-.5);
        }
    }

    public void midOff(){
        climbMid.set(0);
    }
    

    public void autonSet(double x){

            

            if((leftEncoder()+rightEncoder())/2 < x){
            while((leftEncoder()+rightEncoder())/2 <= x-0.1){
                    climbLeft.set(.75);
                    climbRight.set(.75);
                }
            }
            else if((leftEncoder()+rightEncoder())/2 > x){
            while((leftEncoder()+rightEncoder())/2 >= x+0.1){
                climbLeft.set(-.75);
                climbRight.set(-.75);
            }
            }
            climbLeft.set(0);
            climbRight.set(0);
            
            
        

    }

    /*
    public void midAutonSet(double x){

            if(midEncoder() < x){
            while(midEncoder() <= x-0.1){
                    climbMid.set(.75);
                }
            }
            else if(midEncoder() > x){
            while(midEncoder() >= x+0.1){
                climbMid.set(-.75);
            }
    }
    climbMid.set(0);
        }
        */

    public void vertClimb(){
        if(leftEncoder() >= 8.4){ //7.1
            climbLeft.set(0);
        }else{
            climbLeft.set(0.5);
        }

        if(rightEncoder() >= 8.4){
            climbRight.set(0);
        }else{
            climbRight.set(.5);
        }
    }

    public void vertUnClimb(){
        if(leftEncoder() <= 0.25){
            climbLeft.set(0);
        }else{
            climbLeft.set(-.5);
        }

        if(rightEncoder() <= 0.25){
            climbRight.set(0);
        }else{
            climbRight.set(-.5);
        }
    }

    public void vertOff(){
        climbVertical.set(0);
    }

    
    public double midEncoder(){
        return(climbMid.getSelectedSensorPosition()/(2048* 15));
    }
    public double leftEncoder(){
        return(climbLeft.getSelectedSensorPosition()/(2048*15));
    }

    public double rightEncoder(){
        return(climbRight.getSelectedSensorPosition()/(2048*15));
    }

    public void zeroEncoders(){
        //climbMid.setSelectedSensorPosition(0);
        climbLeft.setSelectedSensorPosition(0);
        climbRight.setSelectedSensorPosition(0);
    }
}
