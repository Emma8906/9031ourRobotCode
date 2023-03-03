// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain;
import java.util.function.DoubleSupplier;

public class defaultdrive extends CommandBase {
  /** Creates a new defaultdrive. */
private final drivetrain m_Drive;
private final DoubleSupplier m_forward;
private final DoubleSupplier m_rotation;



  public defaultdrive
  (drivetrain subsystem, DoubleSupplier forward, DoubleSupplier rotation)  
   {m_Drive = subsystem;
    m_forward = forward;
    m_rotation = rotation;
    addRequirements(m_Drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drive.arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
