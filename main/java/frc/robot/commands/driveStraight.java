
package frc.robot.commands;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.SparkMaxPIDController;


public class driveStraight extends CommandBase{

  //private SparkMaxPIDController m_pidController;
  //private final drivetrain m_Drive;

  public driveStraight( drivetrain drive) {
    
    

      //  m_pidController.setP(DriveConstants.kTurnP);
      // m_pidController.setI(DriveConstants.kTurnI);
      //m_pidController.setD(DriveConstants.kTurnD);
      //  m_pidController.setIZone(DriveConstants.kIz);
      //m_pidController.setFF(DriveConstants.kFF);
      //m_pidController.setOutputRange(DriveConstants.kMinOutput, DriveConstants.kMaxOutput);

      //m_Drive = drive;
    //addRequirements(m_Drive);
    
  }
  @Override
  public void initialize() {
   
  }


  @Override
  public void execute() {}

  


  @Override
  public boolean isFinished() {
    return false;
  }
}
