package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandTimedTurn extends Command5800
{
	double l;
	double r;

	public CommandTimedTurn(double time, double left, double right) {
		super(driver);
		setTimeout(time);
		l = left;
		r = right;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		driver.tankDrive(l, r);
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
