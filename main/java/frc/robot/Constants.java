// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }
 
  public static final class DriveConstant{
   
    public static final int LeftFrontMotor = 36;
    public static final int LeftBackMotor = 17;
    public static final int RightFrontMotor = 12;
    public static final int RightBackMotor = 39; 
    public static final int PigeonId = 1;

  }
  public static final class ArmConstants{
// arm motor ID
    public static final int ArmMotorLead = 11;
   //PID constants 
    public static final int ArmMotorFollow = 2;
    public static final double kMinOutput = -0.25;
    public static final double kMaxOutput = 0.25;
    public static final double kFF = 0;
    public static final double kIz = 0;
    public static final double kD = 0;
    public static final double kI = 0;
    public static final double kP = 0.1;
   
  
  }
public static final class PneumaticsConstants{

public static final int PH_CAN_ID = 1;
public static final int clawForwardChannel = 12;
public static final int clawReverseChannel = 13;

public static final int funnelForwardChannel = 4;
public static final int funnelReverseChannel = 0;

public static final int deckForwardChannel = 14;
public static final int deckReverseChannel = 15;

public static final int tailGateForwardChannel = 1;
public static final int tailGateReverseChannel = 2;

public static final int flagConeForwardChannel = 3;
public static final int flagConeReverseChannel = 8;

public static final int flagCubeForwardChannel = 11;
public static final int flagCubeReverseChannel = 10;

}
  public static final class AutoConstants{

    public static final double kAutoBackupDistanceInches = 10;
    public static final double kAutoDriveDistanceInches = 40;
    public static final double kAutoDriveSpeed = -0.5;
    public static final double kAutoBackupSpeed = 0.5;
  }

public static final class DriveConstants{

    public static final double kTurnP = 0.1;
    public static final double kTurnI = 0;
    public static final double kTurnD = 0;
    public static final double kFF = 0;
    public static final double kIz = 0;
    public static final double kMaxOutput = -0.5;
    public static final double kMinOutput = 0.5;


}

}