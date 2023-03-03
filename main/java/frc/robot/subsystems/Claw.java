
package frc.robot.subsystems;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PneumaticHub;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants.PneumaticsConstants;
//import frc.robot.Constants.HatchConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class Claw extends SubsystemBase {
// Creates a new claw
 


  PneumaticHub m_pH = new PneumaticHub(PneumaticsConstants.PH_CAN_ID);
  DoubleSolenoid m_doubleSolenoid = m_pH.makeDoubleSolenoid(PneumaticsConstants.clawForwardChannel, PneumaticsConstants.clawReverseChannel);
  
  /**Grabs cone */
  public void GrabCone() {
      
    m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  /** Releases the cone. */
  public void ReleaseCone() {
    
    m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  @Override
  public void periodic() {
    
  }
}
