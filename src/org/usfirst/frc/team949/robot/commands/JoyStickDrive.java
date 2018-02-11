package org.usfirst.frc.team949.robot.commands;

import org.usfirst.frc.team949.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Teleop command to drive the robot via Joystick.
 */
public class JoyStickDrive extends Command {

	private final static double Y_THRESHOLD = 0.3;
	private final static double Z_THRESHOLD = 0.3;

	private final static double Y_NERF = 0.8;
	private final static double Z_NERF = 0.6;

	public JoyStickDrive() {
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double yInput = Robot.oi.getDriveY();
		double zInput = Robot.oi.getDriveZ();

		yInput = Y_NERF * (Math.abs(yInput) < Y_THRESHOLD ? 0 : yInput);
		zInput = Z_NERF * (Math.abs(zInput) < Z_THRESHOLD ? 0 : zInput);

		Robot.driveTrain.arcade(yInput, zInput);
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
