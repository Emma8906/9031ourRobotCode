// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.poopDeck;
import frc.robot.Constants.AutoConstants;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** A complex auto command that drives forward, releases a hatch, and then drives backward. */
public class Autos extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param deck The hatch subsystem this command will run on
   */
  public Autos(drivetrain drive, poopDeck deck) {
    addCommands(
        // Drive forward the specified distance
        

        // Release the hatch
        
        new poopDeckUp(deck),
        
        new drivedistance(
          AutoConstants.kAutoDriveDistanceInches, AutoConstants.kAutoDriveSpeed , drive),

        new poopDeckDown(deck),
      

        // Drive backward the specified distance
        new drivedistance(
            AutoConstants.kAutoBackupDistanceInches, AutoConstants.kAutoBackupSpeed, drive));
  }
}

