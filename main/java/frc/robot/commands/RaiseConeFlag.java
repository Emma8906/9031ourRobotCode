package frc.robot.commands;


import frc.robot.subsystems.FlagCone;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RaiseConeFlag extends CommandBase {
  
  private final FlagCone m_flagCone;

  /** Creates a new GrabCone. */
  public RaiseConeFlag(FlagCone flagCone) {
    // Use addRequirements() here to declare subsystem dependencies.
     

    m_flagCone = flagCone;
    addRequirements(m_flagCone);
  
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_flagCone.LiftCone();
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