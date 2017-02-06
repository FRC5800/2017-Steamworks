package org.usfirst.frc.team5800.robot.base.commands.autonomous;

import org.usfirst.frc.team5800.robot.base.commands.drive.CommandTimedTurn;
import org.usfirst.frc.team5800.robot.base.commands.drive.CommandEncoderMove;
import org.usfirst.frc.team5800.robot.base.commands.drive.CommandTurnDegrees;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class Autonomous extends Command5800
{
	public Autonomous() {super(null);}
	protected void execute() {}
	protected boolean isDone() {return true;}
	protected void onCompletion() {}
	
	public static Autonomous[] autonomous = new Autonomous[5];
	
	public static void initAutonomous() {
		//Set the sequence of commands run by each version of autonomous here.
		
		//Do nothing
		autonomous[0] = new Autonomous();
		
		//Center gear autonomous
		autonomous[1] = (Autonomous) new Autonomous().setSequential(
				new CommandEncoderMove(300,0.5),
				new CommandTurnDegrees(180,0.6,-0.6),
				new CommandEncoderMove(-300,0.5)
				);
		
		//Right gear autonomous
		autonomous[2] = (Autonomous) new Autonomous().setSequential(
				new CommandEncoderMove(230,0.6),
				new CommandTurnDegrees(90,0.4,-0.4)
		);
		
		//Low bar autonomous
		autonomous[3] = (Autonomous) new Autonomous().setSequential(
				new CommandTimedTurn(5, 0.6D, 0.63D)
		);
		
		//Defense autonomous
		autonomous[4] = (Autonomous) new Autonomous().setSequential(
				new CommandTimedTurn(5, 1, 1)
		);
	}
}
