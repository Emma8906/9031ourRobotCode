package frc.robot.commands;


import frc.robot.subsystems.FlagCube;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LowerCubeFlag extends CommandBase {
  
  private final FlagCube m_flagCube;

  /** Creates a new GrabCone. */
  public LowerCubeFlag(FlagCube flagCube) {
    // Use addRequirements() here to declare subsystem dependencies.
     

    m_flagCube = flagCube;
    addRequirements(m_flagCube);
  
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_flagCube.LowerCube();
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