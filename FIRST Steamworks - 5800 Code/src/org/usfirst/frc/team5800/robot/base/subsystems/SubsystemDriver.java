package org.usfirst.frc.team5800.robot.base.subsystems;

import static org.usfirst.frc.team5800.robot.RobotMap.*;

import org.usfirst.frc.team5800.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class SubsystemDriver extends Subsystem5800
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	private VictorSP l = new VictorSP(driveMotorL1ID);
	private VictorSP l2 = new VictorSP(driveMotorL2ID);
	
	private VictorSP r = new VictorSP(driveMotorR1ID);
	private VictorSP r2 = new VictorSP(driveMotorR2ID);

	private RobotDrive driveRear = new RobotDrive(l, r);
	private RobotDrive driveFront = new RobotDrive(l2, r2);
	
	
	public SubsystemDriver() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}
	
	public void tankDrive(double l, double r) {
		driveFront.tankDrive(l, r);
		driveRear.tankDrive(l, r);
	}

	public void arcadeDrive(double speed, double d) {
		driveFront.arcadeDrive(speed, d);
		driveRear.arcadeDrive(speed, d);
	}
}
