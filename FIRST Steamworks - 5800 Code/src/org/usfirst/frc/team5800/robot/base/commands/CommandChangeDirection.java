package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;
import org.usfirst.frc.team5800.robot.base.commands.drive.CommandDrive;

public class CommandChangeDirection extends Command5800
{
	public CommandChangeDirection() {
		super(null);

	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		if(CommandDrive.chassiDirection == 1){
			CommandDrive.chassiDirection = -1;
		}else if(CommandDrive.chassiDirection == -1){
			CommandDrive.chassiDirection = 1;
		}
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {

	}
}
