package org.usfirst.frc.team949.robot.autocommands;

import org.usfirst.frc.team949.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class HardTurn extends TimedCommand {

	private boolean isTurningRight;
	
	public HardTurn(double timeout, boolean isTurningRight) {
		super(timeout);
		requires(Robot.driveTrain);
		
		this.isTurningRight = isTurningRight;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		double rotateValue = 0.4;
		if(isTurningRight) {
			Robot.driveTrain.arcade(0.0, rotateValue);
		}
		else {
			Robot.driveTrain.arcade(0.0, rotateValue);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return super.isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
