
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticHub;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.PneumaticsConstants;

//import frc.robot.Constants.HatchConstants;



public class Funnel extends SubsystemBase {
  /** Creates a new Funnel. */
  
  PneumaticHub m_pH = new PneumaticHub(PneumaticsConstants.PH_CAN_ID);
  DoubleSolenoid m_doubleSolenoid = m_pH.makeDoubleSolenoid(PneumaticsConstants.funnelForwardChannel, PneumaticsConstants.funnelReverseChannel);
  
  public void FunnelUp() {
    
    m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void FunnelDown() {

    m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
