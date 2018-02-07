package org.usfirst.frc.team949.robot.commands;

import org.usfirst.frc.team949.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoyStickArm extends Command {
	
	private ADXRS450_Gyro g;
	private PIDController pid;
	private double output;
	
	public JoyStickArm() {
		requires(Robot.arm);
		g = Robot.arm.getGyro();
		pid = new PIDController(1/  1.5, 0.000465, 0, g, d -> output = d);
		pid.enable();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		pid.setSetpoint(Robot.oi.getArmY());
		Robot.arm.setArm(output);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
