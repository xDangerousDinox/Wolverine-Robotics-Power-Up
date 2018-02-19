package org.usfirst.frc.team949.robot.commands;

import org.usfirst.frc.team949.robot.Constants;
import org.usfirst.frc.team949.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickupControl extends Command {

	private final static double Z_THRESHOLD = 0.9;
	private final static double MULTIPLIER = 0.5;

	public PickupControl() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.pickup);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// double[] leftRightInputs =
		// Constants.arcadeToTank(Robot.oi.getOperatorY(),
		// Robot.oi.getOperatorZ());
		// Robot.pickup.setPickup(leftRightInputs[0], leftRightInputs[1]);
		int pov = Robot.oi.getOperatorPOV();

		// Hand logic
		if (Robot.oi.isOperatorButtonDown(12)) // Out
		{
			Robot.pickup.setBothMotors(-1.0);
		} else if (Robot.oi.isOperatorButtonDown(11)) // In
		{
			Robot.pickup.setBothMotors(1.0);
		} else if (Robot.oi.isOperatorButtonDown(10)) // Right
		{
			Robot.pickup.setRotateBothMotors(0.7);
		} else if (Robot.oi.isOperatorButtonDown(9)) // Left
		{
			Robot.pickup.setRotateBothMotors(-0.7);
		} else {
			Robot.pickup.stop();
		}

		// Wrist Logic (Down)
		double zInput = Robot.oi.getOperatorZ();
		zInput = (Math.abs(zInput) < Z_THRESHOLD ? 0 : (Math.signum(zInput) * ((Math.abs(zInput)-Z_THRESHOLD) / (1 - Z_THRESHOLD))));
		Robot.pickup.setWrist(MULTIPLIER * zInput);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}
