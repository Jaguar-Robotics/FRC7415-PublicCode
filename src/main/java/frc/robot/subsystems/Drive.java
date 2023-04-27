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
FRC7415-2022 - Robot2022 - Drive.java

*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX; // Import CAN TalonFX
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup; // Import MotorControllerGroup
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive; // Import DifferentialDrive


public class Drive {

    private WPI_TalonFX m_leftOne; 
    private WPI_TalonFX m_leftTwo;
    private WPI_TalonFX m_leftThree;
    private WPI_TalonFX m_rightOne;
    private WPI_TalonFX m_rightTwo;
    private WPI_TalonFX m_rightThree;
    private final MotorControllerGroup m_leftMotors; 
    private final MotorControllerGroup m_rightMotors; 
    private final DifferentialDrive m_robotDrive; 
    

    /**
     * Constructs a drivetrain. 
     * 
     * @param lA 1st motor on the left.
     * @param lB 2nd motor on the left.
     * @param lC 3rd motor on the left.
     * @param rA 1st motor on the right.
     * @param rB 2nd motor on the right. 
     * @param rC 3rd motor on the right. 
     */
    public Drive(int lA, int lB, int lC, int rA, int rB, int rC) {
        m_leftOne = new WPI_TalonFX(lA);
        m_leftTwo = new WPI_TalonFX(lB);
        m_leftThree = new WPI_TalonFX(lC);

        m_rightOne = new WPI_TalonFX(rA);
        m_rightTwo = new WPI_TalonFX(rB);
        m_rightThree = new WPI_TalonFX(rC); 

        m_leftOne.setNeutralMode(NeutralMode.Coast);
        m_leftTwo.setNeutralMode(NeutralMode.Coast);
        m_leftThree.setNeutralMode(NeutralMode.Coast);
        m_rightOne.setNeutralMode(NeutralMode.Coast);
        m_rightTwo.setNeutralMode(NeutralMode.Coast);
        m_rightThree.setNeutralMode(NeutralMode.Coast);

        m_leftOne.setStatusFramePeriod(1, 255); 
        m_leftOne.setStatusFramePeriod(2, 255);
        m_leftTwo.setStatusFramePeriod(1, 255); 
        m_leftTwo.setStatusFramePeriod(2, 255);
        m_leftThree.setStatusFramePeriod(1, 255); 
        m_leftThree.setStatusFramePeriod(2, 255);
        m_rightOne.setStatusFramePeriod(1, 255); 
        m_rightOne.setStatusFramePeriod(2, 255);
        m_rightTwo.setStatusFramePeriod(1, 255); 
        m_rightTwo.setStatusFramePeriod(2, 255);
        m_rightThree.setStatusFramePeriod(1, 255); 
        m_rightThree.setStatusFramePeriod(2, 255);

        m_leftMotors = new MotorControllerGroup(m_leftOne, m_leftTwo, m_leftThree);
        m_rightMotors = new MotorControllerGroup(m_rightOne, m_rightTwo, m_rightThree);

        m_robotDrive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    
    }

    /**
     * Creates an arcade drive on the drivetrain.
     * 
     * @param joystickX X-axis of the joystick.
     * @param joystickY Y-axis of the joystick.
     */
    public void setArcadeDrive(double joystickX, double joystickY) {
        m_robotDrive.arcadeDrive(joystickY, joystickX);
    }

    public void autonDrive(){
        
    }

    public void zeroEncoders(){
        m_leftOne.setSelectedSensorPosition(0);
        m_leftTwo.setSelectedSensorPosition(0);
        m_leftThree.setSelectedSensorPosition(0);
        m_rightOne.setSelectedSensorPosition(0);
        m_rightTwo.setSelectedSensorPosition(0);
        m_rightThree.setSelectedSensorPosition(0);
    }

    public double leftOneEncoder(){
        return m_leftOne.getSelectedSensorPosition()/Constants.DRIVERATIO;
    }

    public double leftTwoEncoder(){
        return m_leftTwo.getSelectedSensorPosition()/Constants.DRIVERATIO;
    }

    public double leftThreeEncoder(){
        return m_leftThree.getSelectedSensorPosition()/Constants.DRIVERATIO;
    }

    public double rightOneEncoder(){
        return m_rightOne.getSelectedSensorPosition()/Constants.DRIVERATIO;
    }

    public double rightTwoEncoder(){
        return m_rightTwo.getSelectedSensorPosition()/Constants.DRIVERATIO;
    }

    public double rightThreeEncoder(){
        return m_rightThree.getSelectedSensorPosition()/Constants.DRIVERATIO;
    }

    /**
     * Manually sets power to the drivetrain. 
     * 
     * @param left Power to be set to left motors.
     * @param right Power to be set to right motors.
     */
    public void setPower(double left, double right) {
        m_leftMotors.set(left);
        m_rightMotors.set(right);
    }

    

}