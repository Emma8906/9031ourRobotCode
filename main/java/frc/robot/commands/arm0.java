package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class arm0 extends CommandBase {

private final ArmSubsystem m_ArmSubsystem;

public arm0(ArmSubsystem subsystem){


    
m_ArmSubsystem = subsystem;
addRequirements(m_ArmSubsystem);

}

@Override
public void initialize(){
    m_ArmSubsystem.ArmSet0();
}

@Override
public boolean isFinished(){
    
    return true;
}

    }
