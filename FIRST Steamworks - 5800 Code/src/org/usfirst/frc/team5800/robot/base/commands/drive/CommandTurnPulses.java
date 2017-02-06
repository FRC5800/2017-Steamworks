package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandTurnPulses extends Command5800
{
	int pulsesToTurn;
	double speed;
	
	public CommandTurnPulses(int pulses, double sp) {
		super(driver);
		pulsesToTurn = pulses;
		speed = sp;
		this.setTimeout(0.1D);
	}
	
	protected void onStart() {
		sensors.driveEncoderL.reset();
		sensors.driveEncoderR.reset();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		driver.tankDrive(speed, -speed);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return Math.abs(sensors.driveEncoderL.get()) > pulsesToTurn && Math.abs(sensors.driveEncoderR.get()) > pulsesToTurn;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
