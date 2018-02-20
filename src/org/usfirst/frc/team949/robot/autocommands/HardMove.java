package org.usfirst.frc.team949.robot.autocommands;

import org.usfirst.frc.team949.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class HardMove extends TimedCommand {

	private double targetInches;
	private final double startingInches;
	
	public HardMove(double duration, double inches) {
		super(duration);
		requires(Robot.driveTrain);
		targetInches = inches;
		startingInches = (Robot.driveTrain.getLeftPosition() + Robot.driveTrain.getRightPosition()) / 2.0;
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.encoderPDrive(targetInches, startingInches);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return super.isTimedOut() || Robot.driveTrain.distanceWithinTolerance(targetInches, startingInches);
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
