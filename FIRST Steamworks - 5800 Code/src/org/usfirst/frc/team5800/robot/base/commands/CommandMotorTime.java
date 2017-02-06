package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;
import org.usfirst.frc.team5800.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.VictorSP;

public class CommandMotorTime extends Command5800
{
	public VictorSP motor;
	public double speed;
	
	public CommandMotorTime(Subsystem5800 requiredSubsystem, VictorSP motor, double speed, double timeout) {
		super(requiredSubsystem);
		this.setTimeout(speed);
		this.motor = motor;
		this.speed = speed;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		motor.set(speed);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		motor.set(0);
	}
}
