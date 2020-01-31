/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */

  public CANSparkMax leftFront = new CANSparkMax(Constants.leftFrontDriveMotor, MotorType.kBrushless);
  public CANSparkMax leftRear = new CANSparkMax(Constants.leftRearDriveMotor, MotorType.kBrushless);
  public CANSparkMax rightFront = new CANSparkMax(Constants.rightFrontDriveMotor, MotorType.kBrushless);
  public CANSparkMax rightRear = new CANSparkMax(Constants.rightRearDriveMotor, MotorType.kBrushless);

  SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftFront, leftRear);
  SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightFront, rightRear);

  public DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);



  public DriveSubsystem() {


  }

  
  public void manualDrive(double move, double turn){

    if (Math.abs(move) < 0.10){
      move = 0;
    }
    if (Math.abs(turn) < 0.10){
      move = 0;
    }


    drive.arcadeDrive(move, turn);

  }


  @Override
  public void periodic() {



  }
}
