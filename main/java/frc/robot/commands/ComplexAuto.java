// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.poopDeck;
import frc.robot.Constants.AutoConstants;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ComplexAuto extends SequentialCommandGroup {
  /** Creates a new ComplexAuto. */
  public ComplexAuto(drivetrain drive, poopDeck deck) {
    // Use addRequirements() here to declare subsystem dependencies.
addCommands(

  new drivedistance(AutoConstants.kAutoDriveDistanceInches,AutoConstants.kAutoDriveSpeed,drive),

  //we reversed things
  new poopDeckUp(deck),

  new drivedistance(AutoConstants.kAutoBackupDistanceInches,AutoConstants.kAutoDriveSpeed,drive)
);

  }
}
  