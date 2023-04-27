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
FRC7415-2022 - Robot2022 - Constants.java

*/

package frc.robot;

import java.lang.Math;

public class Constants {

    public static final int ELEVATELIMIT = 0;
    public static final double ROTATIONSTOINCHES = Math.PI * 6;
    public static final double DRIVERATIO = (5.8*2048)/ROTATIONSTOINCHES;
    public static final double DRIVEP = 0;
    public static final double DRIVEI = 0;
    public static final double DRIVED = 0;

    // Motor Controllers
    public static final int LEFTONE = 1; // Define Back Left Falcon
    public static final int LEFTTWO = 2; // Define Mid Left Falcon
    public static final int LEFTTHREE = 3; // Define Forward Left Falcon
    public static final int RIGHTONE = 4; // Define Back Right Falcon
    public static final int RIGHTTWO = 5; // Define Mid Right Falcon
    public static final int RIGHTTHREE = 6; // Define Forward Right Falcon
    public static final int SHOOTERELEVATE = 7;
    public static final int SHOOTERFLYWHEELSL = 8;
    public static final int SHOOTERFLYWHEELSR = 9;
    public static final int SHOOTERWHEELSL = 13;
    public static final int SHOOTERWHEELSR = 14; 
    public static final int CLIMBMID = 10; 
    public static final int CLIMBLEFT = 11;
    public static final int CLIMBRIGHT = 12; 
    public static final int INTAKEMOTOR = 15;

    // Solenoids
    public static final int INTAKE1 = 7; 
    public static final int INTAKE2 = 6;

    // Joysticks
    public static final int DriverJoystick = 0; // Define Driving Joystick
    public static final int OpJoystick = 1; // Define Operating Joystick

    // Limelight
    public static final double lOffset = -5; // Define Limelight Offset
    public static final double lKP = .3; // Define Limelight Dampening
    public static final double lKD = .2; // Define Derivative Dampening
    public static final double lKI = 1; // Define Limelight Positional Intergral
}
