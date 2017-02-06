package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandTurnToOrientation extends Command5800
{
	double speed;
	double aim;
	
	public CommandTurnToOrientation(double sp, double orientation) {
		super(driver);
		speed = sp;
		aim = orientation % 360;
	}
	
	protected void onStart() {
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		if(sensors.gyro.getAngle() % 360 > aim) driver.tankDrive(-speed, speed);
		else driver.tankDrive(speed, -speed);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return Math.abs(sensors.gyro.getAngle() % 360 - aim) < 1;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
