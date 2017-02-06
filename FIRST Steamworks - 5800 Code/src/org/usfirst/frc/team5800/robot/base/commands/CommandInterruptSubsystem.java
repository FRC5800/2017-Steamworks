package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CommandInterruptSubsystem extends Command5800
{
	Subsystem subsystem;
	
	public CommandInterruptSubsystem(Subsystem sub) {
		super(null);
		subsystem = sub;
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
		subsystem.getCurrentCommand().cancel();
	}
}
