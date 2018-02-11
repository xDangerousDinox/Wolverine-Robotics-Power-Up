package org.usfirst.frc.team949.robot.commands;

import org.usfirst.frc.team949.robot.Constants;
import org.usfirst.frc.team949.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickupControl extends Command {

    public PickupControl() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pickup);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	double[] leftRightInputs = Constants.arcadeToTank(Robot.oi.getOperatorY(), Robot.oi.getOperatorZ());
//    	Robot.pickup.setPickup(leftRightInputs[0], leftRightInputs[1]);
    	int pov = Robot.oi.getOperatorPOV();
    	
    	// Hand logic
    	if(Robot.oi.isOperatorButtonDown(12))
    	{
    		Robot.pickup.setBothMotors(-1.0);
    	}
    	else if(Robot.oi.isOperatorButtonDown(11)) // In
    	{
    		Robot.pickup.setBothMotors(1.0);
    	}
    	else if(Robot.oi.isOperatorButtonDown(10)) // Right 
    	{
    		Robot.pickup.setRotateBothMotors(1.0);
    	}
    	else if(Robot.oi.isOperatorButtonDown(9)) // Left
    	{
    		Robot.pickup.setRotateBothMotors(-1.0);
    	}
    	else
    	{
    		Robot.pickup.stop();
    	}
    	
    	// Wrist logic
    	if(Robot.oi.isOperatorButtonDown(3)) // Down
    	{
    		Robot.pickup.setWrist(-1.0);
    	}
    	else if(Robot.oi.isOperatorButtonDown(5)) // Up
    	{
    		Robot.pickup.setWrist(1.0);
    	}
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
