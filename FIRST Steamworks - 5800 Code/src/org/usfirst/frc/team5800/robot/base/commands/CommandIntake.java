package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandIntake extends Command5800
{
	public CommandIntake() {
		super(intake);
		this.requires(shooter);
		this.setSequential(
				new CommandWait(1.5D), 
				new CommandMotorTime(null, intake.intake, 0, 0.5D).setParallel(
						new CommandMotor(shooter, shooter.shooter, 0D)
				)
		);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		intake.intake.set(1.0D);
		shooter.shooter.set(1.0D);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
