package org.usfirst.frc.team949.robot.subsystems;

import org.usfirst.frc.team949.robot.RobotMap;
import org.usfirst.frc.team949.robot.commands.ClimberControl;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	private WPI_TalonSRX climberMotor;
	
	private Servo hookLock;
	
	public void initDefaultCommand() {
		setDefaultCommand(new ClimberControl());
	}

	public Climber() {
		climberMotor = new WPI_TalonSRX(RobotMap.climberMotor);
		
		hookLock = new Servo(RobotMap.hookLockServo);
		
		// IMPORTANT TO RUN ONE BACKWARDS AND ONE FORWARDS (GEARBOX DESIGN)
		climberMotor.setInverted(true);
	}

	/**
	 * Calls the .set() method on both pickup motors
	 * 
	 * @param rate
	 *            the double that goes in someMotor.set(rate); as parameter.
	 */
	public void setClimbMotor(double rate) {
		climberMotor.set(rate);
	}
	public void lockHook() 
	{
		hookLock.set(0);
	}
	public void releaseHook() 
	{
		hookLock.set(90);
	}
}
