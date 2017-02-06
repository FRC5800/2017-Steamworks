package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CommandReadSensors extends Command5800
{
	public CommandReadSensors() {
		super(sensors);
	}
	
	int tick = 0;

	//Set up what the robot will do while this command is running.
	protected void execute() {		
		//Put any code here needed to handle readings from sensors.
		SmartDashboard.putNumber("Gyro", sensors.gyro.getAngle());
				
		SmartDashboard.putNumber("Drive Encoder L", sensors.driveEncoderL.get());
		SmartDashboard.putNumber("Drive Encoder R", sensors.driveEncoderR.get());
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
