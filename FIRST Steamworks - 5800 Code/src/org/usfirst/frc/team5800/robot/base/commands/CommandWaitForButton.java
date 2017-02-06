package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.buttons.Button;

public class CommandWaitForButton extends Command5800
{
	Button b;
	
	public CommandWaitForButton(Button button) {
		super(null);
		b = button;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return b.get();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
