package frc.robot.commands;


import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class halfDriveSpeed extends CommandBase {
  private final drivetrain m_drive;

  public halfDriveSpeed(drivetrain drive) {
    m_drive = drive;
  }

  @Override
  public void initialize() {
    m_drive.arcadeDrive(0.5, 0.25);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(1, 0.5);
  }
}
