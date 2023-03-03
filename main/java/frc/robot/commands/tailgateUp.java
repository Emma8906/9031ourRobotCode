package frc.robot.commands;



import frc.robot.subsystems.poopDeck;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class tailgateUp extends CommandBase {
  
  private final poopDeck m_PoopDeck;

  /** Creates a new GrabCone. */
  public tailgateUp(poopDeck poopDeck) {
    // Use addRequirements() here to declare subsystem dependencies.
     

    m_PoopDeck = poopDeck;
    addRequirements(m_PoopDeck);
  
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_PoopDeck.tailgateUp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}