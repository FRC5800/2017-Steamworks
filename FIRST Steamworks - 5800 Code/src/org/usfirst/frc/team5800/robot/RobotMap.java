package org.usfirst.frc.team5800.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //PWMs (0 - 9)
    public static final int
    	driveMotorR1ID = 0,
    	driveMotorR2ID = 1,
    	driveMotorL1ID = 2,
    	driveMotorL2ID = 3,
    	intakeMotorID = 4,
    	shooterMotorID = 6;
    
    //Digital I/Os (0 - 9)
    public static final int
    	driveEncoderL3ID = 0,
    	driveEncoderL1ID = 1,
    	driveEncoderR3ID = 2,
    	driveEncoderR1ID = 3;
}