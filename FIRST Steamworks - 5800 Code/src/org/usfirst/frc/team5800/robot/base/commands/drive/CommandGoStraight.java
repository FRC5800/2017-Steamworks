package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.Robot;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandGoStraight extends Command5800
{
	double speed;
	double angle;
	int pulses;

	public CommandGoStraight(int sp) {
		super(driver);
		this.speed = sp;
	}
	
	protected void onStart() {
		sensors.gyro.reset();
		sensors.gyro.calibrate();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		while(Robot.isAuto){
			double parameter = 0.025;
			double error = sensors.gyro.getAngle();
			driver.tankDrive(this.speed + (parameter * error), this.speed - (parameter * error));
		}
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors used in this command.
	protected void onCompletion() {
	}
}
