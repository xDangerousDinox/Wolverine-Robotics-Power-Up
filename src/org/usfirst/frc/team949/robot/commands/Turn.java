package org.usfirst.frc.team949.robot.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team949.robot.Robot;

/**
 *
 */
public class Turn extends Command {
	
	private ADXRS450_Gyro g;
	private PIDController pid;
	private double output;
	private double deg;
	
	public Turn(double degree) {
		requires(Robot.driveTrain);
		g = Robot.driveTrain.getGyro();
		deg = degree;
		pid = new PIDController(1/ (deg * 1.5), 0.000465, 0, g, d -> output = d);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		pid.setSetpoint(g.getAngle() + deg);
		pid.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.drive(0,  output);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Math.abs(g.getAngle() - pid.getSetpoint()) < 0.3;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		pid.reset();
		output = 0;
		Robot.driveTrain.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
