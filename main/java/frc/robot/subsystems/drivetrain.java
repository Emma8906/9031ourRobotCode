// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.DriveConstant;
import com.revrobotics.RelativeEncoder;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;
import edu.wpi.first.wpilibj.smartdashboard.*;


public class drivetrain extends SubsystemBase {
  
  //set up left front motor/ encoder
  private CANSparkMax lf_motor= new CANSparkMax(DriveConstant. LeftFrontMotor, MotorType.kBrushless);
  public RelativeEncoder l_Encoder;

  // set up back left motor
  private CANSparkMax lb_motor= new CANSparkMax(DriveConstant. LeftBackMotor, MotorType.kBrushless);

  //set up right front motor  
  private CANSparkMax rf_motor= new CANSparkMax(DriveConstant.RightFrontMotor, MotorType.kBrushless);
  public RelativeEncoder r_encoder;

  //set up right back motor 
  private CANSparkMax rb_motor= new CANSparkMax(DriveConstant. RightBackMotor, MotorType.kBrushless);

  // create drive 
private final DifferentialDrive m_Drive = new DifferentialDrive(lf_motor, rf_motor);
  



  //set up average encoder 
public double getAverageEncoderPosition;

  /** pigeon instance, this is instantiated later, leave this alone */
  
  int _pigeonTalon = (DriveConstant.PigeonId);
  WPI_PigeonIMU _pidgey= new WPI_PigeonIMU(_pigeonTalon);
  //new WPI_TalonSRX(0);

public double averageEncoder;
public double angle;
public double Pitch;
public double Roll;
public double Yaw;
  

  public drivetrain() {

    //We need to invert one side of the drive trian so that positive voltages 
    //result in both sides moving forwards. Depending on how your robot's
    //gearbox is constructed, you might have to invert the left side instead.
  lf_motor. setInverted(true);

  //set up followers 
  rb_motor.follow(rf_motor);
  lb_motor.follow(lf_motor);

  _pidgey = new WPI_PigeonIMU(_pigeonTalon);

//getting encoder number for right 
r_encoder =rf_motor.getEncoder();

//getting encoder number for left 
l_Encoder = lf_motor.getEncoder();
  }
public double getAverageEncoderPosition(){
  return (l_Encoder. getPosition()+(r_encoder.getPosition())* -1) /2.0;
  }

 // public void resetEncoders(){

   // r_encoder.setPosition(0);
   // l_Encoder.setPosition(0);
 // }
  public void arcadeDrive (double fwd, double rot){
    m_Drive.arcadeDrive(fwd, rot*0.4);
  }

  @Override
  public void periodic() {
    angle=_pidgey.getAngle();
    Pitch=_pidgey.getPitch();
    Roll=_pidgey.getRoll();
    Yaw=_pidgey.getYaw();
    averageEncoder = (l_Encoder. getPosition()-(r_encoder.getPosition())* -1) /2.0;
    SmartDashboard.putNumber("Left Encoder Position", averageEncoder);
    SmartDashboard.putNumber("angle", angle);
    SmartDashboard.putNumber("pitch", Pitch);
    SmartDashboard.putNumber("roll", Roll);
    SmartDashboard.putNumber("yaw", Yaw);

    

    // This method will be called once per scheduler run
  }
  public double getAverageEncoderDistance() {
    return (l_Encoder. getPosition()-(r_encoder.getPosition())* -1) /2.0;
  }
public void resetEncoders() {
}
}
