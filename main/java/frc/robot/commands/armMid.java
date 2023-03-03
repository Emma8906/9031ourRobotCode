package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class armMid extends CommandBase {

private final ArmSubsystem m_ArmSubsystem;

public armMid(ArmSubsystem subsystem){


    
m_ArmSubsystem = subsystem;
addRequirements(m_ArmSubsystem);

}

@Override
public void initialize(){
    m_ArmSubsystem.ArmMid();
}

@Override
public boolean isFinished(){
    
    return true;
}

    }
