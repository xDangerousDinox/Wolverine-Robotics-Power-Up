package org.usfirst.frc.team949.robot.autocommands;

import org.usfirst.frc.team949.robot.Constants;
import org.usfirst.frc.team949.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class MotionProfile extends Command {

	double kp = 0;
	double ki = 0;
	double kd = 0;
	double kv = 0;
	double ka = 0;

	public MotionProfile() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);

		// Create the Trajectory Configuration
		//
		// Arguments:
		// Fit Method: HERMITE_CUBIC or HERMITE_QUINTIC
		// Sample Count: SAMPLES_HIGH (100 000)
		// SAMPLES_LOW (10 000)
		// SAMPLES_FAST (1 000)
		// Time Step: 0.05 Seconds
		// Max Velocity: 1.7 m/s
		// Max Acceleration: 2.0 m/s/s
		// Max Jerk: 60.0 m/s/s/s
		Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
				Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);

		// Create Waypoints
		Waypoint[] points = new Waypoint[] { new Waypoint(-4, -1, Pathfinder.d2r(-45)), new Waypoint(-2, -2, 0),
				new Waypoint(0, 0, 0) };

		// Generate trajectory with given waypoints and configuration
		Trajectory trajectory = Pathfinder.generate(points, config);

		// Wheelbase Width = 0.5969m
		TankModifier modifier = new TankModifier(trajectory).modify(0.5969);

		// Do something with the new Trajectories...
		Trajectory left = modifier.getLeftTrajectory();
		Trajectory right = modifier.getRightTrajectory();

		EncoderFollower leftFollower = new EncoderFollower(left);
		EncoderFollower rightFollower = new EncoderFollower(right);
		leftFollower.configurePIDVA(kp, ki, kd, kv, ka);
		rightFollower.configurePIDVA(kp, ki, kd, kv, ka);
		leftFollower.configureEncoder(0, 4096, Constants.wheel_diameter);
		rightFollower.configureEncoder(0, 4096, Constants.wheel_diameter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
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
