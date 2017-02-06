package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.OI;
import org.usfirst.frc.team5800.robot.base.commands.CommandBase;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

/**
 *
 * @author Sean Zammit
 */
public class CommandDrive extends Command5800
{
	
	public static int chassiDirection = 1;
	
	public static final double minR = 0.4D, difR = 0.5D;
	
	public CommandDrive() {
		super(driver);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		if (chassiDirection == 1) {
			arcadeDrive(OI.axis_j_Y.get(), -OI.axis_j_Rotate.get());
		} else if (chassiDirection == -1) {
			arcadeDrive(-OI.axis_j_Y.get(), -OI.axis_j_Rotate.get());
		}
	}
			
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}
	
	/**
	 * Pseudo-arcade drive method of control. Calculate adjustments to the inputs in this method.
	 * 
	 * @param sp The parallel speed and direction of the robot.
	 * @param rotation The speed at which the robot should rotate.
	 */
	public void arcadeDrive(double sp, double rotation) {
		double mod = minR + difR * Math.pow(1 - Math.abs(sp), 2);
		double r = Math.pow(rotation, 3) * mod;
		CommandBase.driver.tankDrive(- sp - r, - sp + r);
	}

	protected void onCompletion() {}
}
