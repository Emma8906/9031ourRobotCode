// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;

public class ArmSubsystem extends SubsystemBase{

   private CANSparkMax a_leadMotor = new CANSparkMax(ArmConstants. ArmMotorLead, MotorType.kBrushless);
   private CANSparkMax a_followMotor = new CANSparkMax(ArmConstants. ArmMotorFollow, MotorType.kBrushless);
   private SparkMaxPIDController m_pidController;

   

   public void ArmUp() {
    
    a_followMotor.follow(a_leadMotor,true);
    
    a_leadMotor.set(.25);
    
  }

  public void ArmDown() {
    
    a_followMotor.follow(a_leadMotor,true);
    
    a_leadMotor.set(-.25);
   }

   public void ArmStop() {

    
    a_followMotor.follow(a_leadMotor,true);
    
    a_leadMotor.set(0);
    
   }

   public void ArmHigh() {

    
    m_pidController = a_leadMotor.getPIDController();
    a_followMotor.follow(a_leadMotor,true);
   

    m_pidController.setP(ArmConstants.kP);
    m_pidController.setI(ArmConstants.kI);
    m_pidController.setD(ArmConstants.kD);
    m_pidController.setIZone(ArmConstants.kIz);
    m_pidController.setFF(ArmConstants.kFF);
    m_pidController.setOutputRange(ArmConstants.kMinOutput, ArmConstants.kMaxOutput);

  
 
    // This method will be called once per scheduler run
    m_pidController.setReference(-28, CANSparkMax.ControlType.kPosition);
    
   }

   public void ArmMid() {

    
    m_pidController = a_leadMotor.getPIDController();
    a_followMotor.follow(a_leadMotor,true);
   

    m_pidController.setP(ArmConstants.kP);
    m_pidController.setI(ArmConstants.kI);
    m_pidController.setD(ArmConstants.kD);
    m_pidController.setIZone(ArmConstants.kIz);
    m_pidController.setFF(ArmConstants.kFF);
    m_pidController.setOutputRange(ArmConstants.kMinOutput, ArmConstants.kMaxOutput);

  
 
    // This method will be called once per scheduler run
    m_pidController.setReference(-22, CANSparkMax.ControlType.kPosition);
    
   }

   public void ArmSet0() {

    
    m_pidController = a_leadMotor.getPIDController();
    a_followMotor.follow(a_leadMotor,true);
   

    m_pidController.setP(ArmConstants.kP);
    m_pidController.setI(ArmConstants.kI);
    m_pidController.setD(ArmConstants.kD);
    m_pidController.setIZone(ArmConstants.kIz);
    m_pidController.setFF(ArmConstants.kFF);
    m_pidController.setOutputRange(ArmConstants.kMinOutput, ArmConstants.kMaxOutput);

  
 
    // This method will be called once per scheduler run
    m_pidController.setReference(0, CANSparkMax.ControlType.kPosition);
    
   }

   public void ArmPick() {

    
    m_pidController = a_leadMotor.getPIDController();
    a_followMotor.follow(a_leadMotor,true);
   

    m_pidController.setP(ArmConstants.kP);
    m_pidController.setI(ArmConstants.kI);
    m_pidController.setD(ArmConstants.kD);
    m_pidController.setIZone(ArmConstants.kIz);
    m_pidController.setFF(ArmConstants.kFF);
    m_pidController.setOutputRange(ArmConstants.kMinOutput, ArmConstants.kMaxOutput);

  
 
    // This method will be called once per scheduler run
    m_pidController.setReference(-22, CANSparkMax.ControlType.kPosition);

   }
    
   public void armDrive() {

    
    m_pidController = a_leadMotor.getPIDController();
    a_followMotor.follow(a_leadMotor,true);
   

    m_pidController.setP(ArmConstants.kP);
    m_pidController.setI(ArmConstants.kI);
    m_pidController.setD(ArmConstants.kD);
    m_pidController.setIZone(ArmConstants.kIz);
    m_pidController.setFF(ArmConstants.kFF);
    m_pidController.setOutputRange(ArmConstants.kMinOutput, ArmConstants.kMaxOutput);

    // This method will be called once per scheduler run
    m_pidController.setReference(-2, CANSparkMax.ControlType.kPosition);
   }

  }
