// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain;


public class drivedistance extends CommandBase {
  /** Creates a new drivedistance. */
  private final drivetrain m_Drive;
  private final double m_distance;
  private final double m_speed;


  public drivedistance(double inches, double speed, drivetrain drive) {
    m_distance = inches;
    m_speed = speed;
    m_Drive = drive;
    addRequirements(m_Drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
m_Drive.resetEncoders();
m_Drive. arcadeDrive(m_speed, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drive.resetEncoders();
    m_Drive. arcadeDrive(m_speed,0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drive. arcadeDrive(0,0);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_Drive.getAverageEncoderDistance())>= m_distance;
   }
}