/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;



/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // change Spark to SparkSRX in actual code, drivers for CAN motors only work on Windows computers
  
  // use the following two lines for new robot:
  PWMVictorSPX leftController = null;
  PWMVictorSPX rightController = null;

  // use the following two lines for old robot (don't forget to uncomment lines 43 & 44):
  //Spark leftController = null;
  //Spark rightController = null;

  DifferentialDrive differentialDrive = null;
//changed to constructor(DriveTrain)
  public DriveTrain() {
    // use following 2 lines for new robot:
    leftController = new PWMVictorSPX(RobotMap.DRIVETRAIN_LEFT_FRONT_PWMVICTORSPX); // port numbers defined in RobotMap
    rightController = new PWMVictorSPX(RobotMap.DRIVETRAIN_RIGHT_FRONT_PWMVICTORSPX); 

    // use following 2 lines for old robot (don't forget to uncomment lines 32 & 33):
    //leftController = new Spark(RobotMap.DRIVETRAIN_LEFT_FRONT_PWMVICTORSPX);
    //rightController = new Spark(RobotMap.DRIVETRAIN_RIGHT_FRONT_PWMVICTORSPX); 

    differentialDrive = new DifferentialDrive(leftController, rightController);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void initDefaultCommand() { 
    setDefaultCommand(new DriveArcade());

    // runs automatically everytime the subsystem is called
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}