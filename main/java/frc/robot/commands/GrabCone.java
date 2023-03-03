
package frc.robot.commands;


import frc.robot.subsystems.Claw;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class GrabCone extends CommandBase {
  
  private final Claw m_claw;

  /** Creates a new GrabCone. */
  public GrabCone(Claw claw) {
    // Use addRequirements() here to declare subsystem dependencies.
     

    m_claw = claw;
    addRequirements(m_claw);
  
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_claw.GrabCone();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}