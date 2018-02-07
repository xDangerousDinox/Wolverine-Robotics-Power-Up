package org.usfirst.frc.team949.robot.subsystems;

import org.usfirst.frc.team949.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmPID extends Subsystem {

    // Initialize your subsystem here
	private final ADXRS450_Gyro g = new ADXRS450_Gyro();
	private WPI_TalonSRX arm = new WPI_TalonSRX(RobotMap.leftPickupMotor);
    public ArmPID() {
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public ADXRS450_Gyro getGyro() {
    	return g;
    }
    
    public void setArm(double moveValue) {
    	arm.set(moveValue);
    }
    
    
}
