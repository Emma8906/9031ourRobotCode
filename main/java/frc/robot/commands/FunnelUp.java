

package frc.robot.commands;


import frc.robot.subsystems.Funnel;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class FunnelUp extends CommandBase {
  /** Creates a new FunnelUp. */
  private final Funnel m_funnel;
  
  public FunnelUp(Funnel funnel) {
    // Use addRequirements() here to declare subsystem dependencies.
  
  m_funnel = funnel;
  addRequirements(m_funnel);
  
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_funnel.FunnelUp();
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
