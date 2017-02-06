package org.usfirst.frc.team5800.robot;

import static org.usfirst.frc.team5800.robot.RobotMap.*;
import static org.usfirst.frc.team5800.robot.base.commands.CommandBase.*;

import java.io.File;

import org.usfirst.frc.team5800.robot.base.buttons.*;
import org.usfirst.frc.team5800.robot.base.commands.*;
import org.usfirst.frc.team5800.robot.base.commands.autonomous.Autonomous;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.communication.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control of the robot.
 *
 */
@SuppressWarnings("unused")
public class OI
{
	public OI() {
		Autonomous.initAutonomous();
		
		//Set what commands will run when buttons are pressed/held/released here.
		whenPressed(j_Fire,	new CommandChangeDirection());
		
	}
	
	//Set up joysticks and buttons here.
	private static final Joystick stick_j = new Joystick (0);
	
	public static final JoystickAxis
		axis_j_X = new JoystickAxis(stick_j, 0),
		axis_j_Y = new JoystickAxis(stick_j, 1),
		axis_j_Rotate = new JoystickAxis(stick_j, 2),
		axis_j_Slider = new JoystickAxis(stick_j, 3);
	
	public static final Button
		j_Fire = new JoystickButton(stick_j, 1),
		j_Thumb = new JoystickButton(stick_j, 2),
		j_Three = new JoystickButton(stick_j, 3),
		j_Four = new JoystickButton(stick_j, 4),
		j_Five = new JoystickButton(stick_j, 5),
		j_Six = new JoystickButton(stick_j, 6),
		j_Seven = new JoystickButton(stick_j, 7),
		j_Eight = new JoystickButton(stick_j, 8),
		j_Nine = new JoystickButton(stick_j, 9),
		j_Ten = new JoystickButton(stick_j, 10),
		j_Eleven = new JoystickButton(stick_j, 11),
		j_Twelve = new JoystickButton(stick_j, 12);
	
	private static final Joystick stick_d = new Joystick(1);
	
	public static final JoystickAxis
		axis_d_LX = new JoystickAxis(stick_d, 0),
		axis_d_LY = new JoystickAxis(stick_d, 1),
		axis_d_LT = new JoystickAxis(stick_d, 2),
		axis_d_RT = new JoystickAxis(stick_d, 3), //
		axis_d_RX = new JoystickAxis(stick_d, 4),
		axis_d_RY = new JoystickAxis(stick_d, 5); //

	public static final Button
		d_A = new JoystickButton(stick_d, 1),
		d_B = new JoystickButton(stick_d, 2),
		d_X = new JoystickButton(stick_d, 3),
		d_Y = new JoystickButton(stick_d, 4),
		d_LB = new JoystickButton(stick_d, 5),
		d_RB = new JoystickButton(stick_d, 6),
		d_Back = new JoystickButton(stick_d, 7),
		d_Start = new JoystickButton(stick_d, 8),
		d_LStick = new JoystickButton(stick_d, 9),
		d_RStick = new JoystickButton(stick_d, 10),

		d_POV_U = new JoystickPOVButton(stick_d, 0),
		d_POV_R = new JoystickPOVButton(stick_d, 90),
		d_POV_D = new JoystickPOVButton(stick_d, 180),
		d_POV_L = new JoystickPOVButton(stick_d, 270),

		d_LT = new JoystickAxisButton(axis_d_LT, false, 0.5D),
		d_RT = new JoystickAxisButton(axis_d_RT, false, 0.5D);
	
	
	private void whenPressed(Button button, Command5800 command) {
		button.whenPressed(command);
	}

	private void whenHeld(Button button, Command5800 command) {
		button.whenPressed(command.setCancelWhenReleased(button));
	}

	private void whenReleased(Button button, Command5800 command) {
		button.whenReleased(command);
	}

	private void cancelWhenPressed(Button button, Command5800 command) {
		button.cancelWhenPressed(command);
	}

	private void toggleWhenPressed(Button button, Command5800 command) {
		button.toggleWhenPressed(command);
	}
	
	private void pulseWhileHeld(Button button, Command5800 command) {
		button.whileHeld(command);
	}
}
