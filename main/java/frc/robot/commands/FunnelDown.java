

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Funnel;

public class FunnelDown extends CommandBase {
  /** Creates a new FunnelDown. */
  private final Funnel m_funnel;

  public FunnelDown(Funnel funnel) {
    // Use addRequirements() here to declare subsystem dependencies.
  
    m_funnel = funnel;
    addRequirements(m_funnel);
  
 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  m_funnel.FunnelDown();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
