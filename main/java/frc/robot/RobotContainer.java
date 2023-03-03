// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


// arm 
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.commands.armUp;
import frc.robot.commands.armDown;
import frc.robot.commands.armStop;
import frc.robot.commands.armHigh;
import frc.robot.commands.armMid;
import frc.robot.commands.armPick;
import frc.robot.commands.arm0;
import frc.robot.commands.ArmDrive;

//autos
import frc.robot.commands.Autos;
import frc.robot.commands.ComplexAuto;
import frc.robot.commands.drivedistance;
import frc.robot.Constants.AutoConstants;

//claw
import frc.robot.commands.GrabCone;
import frc.robot.commands.ReleaseCone;
import frc.robot.subsystems.Claw;

//Funnel
import frc.robot.commands.FunnelUp;
import frc.robot.commands.FunnelDown;
import frc.robot.subsystems.Funnel;

//poopdeck and tailgate
import frc.robot.commands.tailgateUp;
import frc.robot.commands.tailgateDown;
import frc.robot.commands.poopDeckDown;
import frc.robot.commands.poopDeckUp;
import frc.robot.subsystems.poopDeck;

//drive
import frc.robot.commands.driveStraight;
import frc.robot.commands.defaultdrive;
import frc.robot.commands.halfDriveSpeed;
import frc.robot.subsystems.drivetrain;

//flag cones and cube
import frc.robot.subsystems.FlagCube;
import frc.robot.subsystems.FlagCone;
import frc.robot.commands.RaiseConeFlag;
//import frc.robot.commands.RaiseCubeFlag;
//import frc.robot.commands.LowerConeFlag;
import frc.robot.commands.LowerCubeFlag;

//networktables, controlers and constants
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants.OperatorConstants;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {


  // The robot's subsystems and commands are defined here...
  
  private final drivetrain m_Drivetrain = new drivetrain();
  private final Claw m_claw = new Claw();
  private final ArmSubsystem m_robotArm = new ArmSubsystem();
  private final poopDeck m_poopDeck = new poopDeck();
  private final FlagCone m_flagCone = new FlagCone();
  private final FlagCube m_flagCube = new FlagCube();
  private final Funnel m_funnel = new Funnel();
  


  //auto routines

  //simple Routine
  private final Command m_simpleAuto=
  new drivedistance(AutoConstants.kAutoDriveDistanceInches, AutoConstants.kAutoDriveSpeed, m_Drivetrain);
private final Command m_complexAuto = new ComplexAuto(m_Drivetrain, m_poopDeck);

  private final Command m_autos = new Autos(m_Drivetrain, m_poopDeck);

  //a choser for auto

  SendableChooser<Command> m_chooser= new SendableChooser<>();
  
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

      private final CommandXboxController m_OperatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_Drivetrain.setDefaultCommand(

    new defaultdrive(m_Drivetrain, m_driverController:: getRightY, m_driverController:: getLeftX));
    
   
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("<variablename>").getDouble(0);
                
//add commands to the autonous command choser 
m_chooser.setDefaultOption("simple auto", m_simpleAuto);
m_chooser.addOption("complex auto", m_complexAuto);
m_chooser.addOption("autos", m_autos);

Shuffleboard.getTab("Autonomous").add(m_chooser);
}


  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
 

   m_driverController.leftTrigger().onTrue(new armUp(m_robotArm));
   m_driverController.rightTrigger().onTrue(new armDown(m_robotArm));
    m_driverController.leftBumper().whileTrue(new GrabCone(m_claw));
    m_driverController.rightBumper().whileTrue(new ReleaseCone(m_claw));

    
    
    m_driverController.rightTrigger().or( m_driverController.leftTrigger()).or(m_driverController.x()).or(m_driverController.a()).or(m_driverController.y()).or(m_driverController.b()).whileFalse(new armStop(m_robotArm));
    //for ArmDrive intead of armStop
    m_driverController.rightTrigger().or( m_driverController.leftTrigger()).or(m_driverController.x()).or(m_driverController.a()).or(m_driverController.y()).or(m_driverController.b()).whileFalse(new ArmDrive(m_robotArm));

   m_driverController.x().onTrue(new arm0(m_robotArm));
   m_driverController.a().onTrue(new armHigh(m_robotArm));
   m_driverController.y().onTrue(new armMid(m_robotArm));
   m_driverController.b().onTrue(new armPick(m_robotArm));

   m_driverController.rightStick().onTrue(new halfDriveSpeed(m_Drivetrain));
   m_driverController.leftStick().onTrue(new driveStraight(m_Drivetrain));
        // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
        // cancelling on release.
  

    m_OperatorController.leftStick().onTrue(new poopDeckUp(m_poopDeck));
    m_OperatorController.rightStick().onTrue(new poopDeckDown(m_poopDeck));
    m_OperatorController.leftBumper().onTrue(new tailgateUp(m_poopDeck));
    m_OperatorController.rightBumper().onTrue(new tailgateDown(m_poopDeck));
    
   // m_OperatorController.x().onTrue(new RaiseCubeFlag(m_flagCube));
    m_OperatorController.a().onTrue(new LowerCubeFlag(m_flagCube));
    m_OperatorController.y().onTrue(new RaiseConeFlag(m_flagCone));
   // m_OperatorController.b().onTrue(new LowerConeFlag(m_flagCone));
    
   m_OperatorController.x().onTrue(new FunnelUp(m_funnel));
   m_OperatorController.b().onTrue(new FunnelDown(m_funnel));


  }


   /* button 2 will zero Pigeon */
 //if (m_driverController.getkA()) {
  /** Zero yaw, this has to be done using the pigeon, not the motor controller */
 // _pidgey.setYaw(0, kTimeoutMs);
//  _pidgey.setAccumZAngle(0, kTimeoutMs); 
 

 
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
   return m_chooser.getSelected();
  }
}