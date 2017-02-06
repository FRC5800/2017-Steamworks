package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

/**
 * @author Sean Zammit
 */
public class CommandOuttakeOnly extends Command5800
{
	public CommandOuttakeOnly() {
		super(intake);
		this.setSequential(

		);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {

	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {

	}
}
