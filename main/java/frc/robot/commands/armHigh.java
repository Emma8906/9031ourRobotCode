package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class armHigh extends CommandBase {

private final ArmSubsystem m_ArmSubsystem;

public armHigh(ArmSubsystem subsystem){


    
m_ArmSubsystem = subsystem;
addRequirements(m_ArmSubsystem);

}

@Override
public void initialize(){
    m_ArmSubsystem.ArmHigh();
}

@Override
public boolean isFinished(){
    
    return true;
}

    }
