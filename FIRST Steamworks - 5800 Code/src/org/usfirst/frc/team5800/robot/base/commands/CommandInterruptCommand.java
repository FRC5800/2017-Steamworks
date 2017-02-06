package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.command.Command;

public class CommandInterruptCommand extends Command5800
{
	Command comToInterrupt;
	
	public CommandInterruptCommand(Command command) {
		super(null);
		comToInterrupt = command;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return true;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		comToInterrupt.cancel();
	}
}
