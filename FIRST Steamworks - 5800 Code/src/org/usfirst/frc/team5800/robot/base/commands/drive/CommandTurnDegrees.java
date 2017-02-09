

package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import org.usfirst.frc.team5800.robot.superclasses.PID;

public class CommandTurnDegrees extends Command5800
{
	float targetAngle; // faz mais sentido ser "ângulo objetivo", do que ser "ângulo à  virar" 
	double leftValue;
	double rightValue;
	double lastAngle; //ultima leitura do giroscópio
	double PID_Compensation;
	double ErrorTolerance = 2; //Valor de tolerância
	
	public CommandTurnDegrees(int degrees, double l, double r) {
		super(driver); //? qual a utilidade disoe isso?
		targetAngle = degrees;
		PID.setSetPoint(degrees); //diz para o PID o valor-objetivo
		
		PID.setGains(10, 1/10, 1/20); 
		
		/* Estes valores tem que ser ajustado empiricamente,
		 * pede ajuda pro wayne.
		 * 
		 * e tem que verificar se os valores não estouram o máximo de velocidade do motor, pra não dar erro
		
		*/
		leftValue = l;
		rightValue = r;
		this.setTimeout(0.1D);
	}
	
	protected void onStart() {
		sensors.gyro.reset();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		driver.tankDrive(leftValue + PID_Compensation, rightValue - PID_Compensation);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		lastAngle = sensors.gyro.getAngle();
		PID.addNewSample(lastAngle);
		PID.process();
		/*poderia fazer isso antes de mandar o robô andar,
		 * mas retornaria valores bizarros se executado
		 *  antes de ter alguma amostra
		*/
		
		// verifica se o erro está na faixa aceitável ou se deu timeout
		if (((targetAngle <= lastAngle + ErrorTolerance) && (targetAngle >= lastAngle - ErrorTolerance)) || (isTimedOut())) {
			return true;
		}
		else { return false; }
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}


//Vou comentar o código original e escrever o meu acima


/*
package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandTurnDegrees extends Command5800
{
	int degreesToTurn;
	double leftValue;
	double rightValue;
	
	double originalDegrees;
	
	public CommandTurnDegrees(int degrees, double l, double r) {
		super(driver);
		degreesToTurn = degrees;
		leftValue = l;
		rightValue = r;
		this.setTimeout(0.1D);
	}
	
	protected void onStart() {
		sensors.gyro.reset();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		driver.tankDrive(leftValue, rightValue);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return Math.abs(sensors.gyro.getAngle()) > degreesToTurn && isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
 */