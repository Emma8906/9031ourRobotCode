
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticHub;

import edu.wpi.first.wpilibj.DoubleSolenoid;

//import frc.robot.Constants.HatchConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsConstants;

public class poopDeck extends SubsystemBase {
  

//deck
 


  PneumaticHub m_pH = new PneumaticHub(PneumaticsConstants.PH_CAN_ID);
  DoubleSolenoid m_doubleSolenoid = m_pH.makeDoubleSolenoid(PneumaticsConstants.deckForwardChannel,PneumaticsConstants.deckReverseChannel);


  //tailgate
  

  PneumaticHub m_pH2 = new PneumaticHub(PneumaticsConstants.PH_CAN_ID);
  DoubleSolenoid m_doubleSolenoid2 = m_pH2.makeDoubleSolenoid(PneumaticsConstants.tailGateForwardChannel,PneumaticsConstants.tailGateReverseChannel);
  

  public void deckDown() {
      
    m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    
  }

  /** Releases the cone. */
  public void deckUp() {
    m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    

  }

  public void tailgateUp() {
   
    m_doubleSolenoid2.set(DoubleSolenoid.Value.kForward);

  }
  public void tailgateDown() {
    
    m_doubleSolenoid2.set(DoubleSolenoid.Value.kReverse);
    

  }
}
