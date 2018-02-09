package org.usfirst.frc.team949.robot.subsystems;

import org.usfirst.frc.team949.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pickup extends Subsystem {
	private WPI_TalonSRX rightPickupMotor;
	private WPI_TalonSRX leftPickupMotor;
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public Pickup() 
	{
		this.rightPickupMotor = new WPI_TalonSRX(RobotMap.rightPickupMotor);
		this.leftPickupMotor = new WPI_TalonSRX(RobotMap.leftPickupMotor);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void takeIn(){
    	setBothMotors(-1.0);
	}
	public void putOut(){
		setBothMotors(1.0);
	}
	public void stop(){
		setBothMotors(0.0);
	}
	/**
	 * Calls the .set() method on both pickup motors
	 * @param rate the double that goes in someMotor.set(rate); as parameter.
	 */
	public void setBothMotors(double rate) 
	{
		setPickup(rate, rate);
	}
	public void setPickup(double leftRate, double rightRate) 
	{
		this.rightPickupMotor.set(leftRate);
		this.leftPickupMotor.set(rightRate);
	}
	
}

