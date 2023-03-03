// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.PneumaticsConstants;




public class FlagCube extends SubsystemBase {
  /** Creates a new RecognizeCube. */
 
 
  PneumaticHub m_pH = new PneumaticHub(PneumaticsConstants.PH_CAN_ID);
  DoubleSolenoid m_doubleSolenoid = m_pH.makeDoubleSolenoid(PneumaticsConstants.flagCubeForwardChannel,PneumaticsConstants.flagCubeReverseChannel);


  public void LiftCube() {
      
    m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  /** Releases the cone. */
  public void LowerCube() {
    m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
