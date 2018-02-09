package org.usfirst.frc.team949.robot.subsystems;

import org.usfirst.frc.team949.robot.RobotMap;
import org.usfirst.frc.team949.robot.commands.JoyStickArm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Initialize your subsystem here
//	private final ADXRS450_Gyro g = new ADXRS450_Gyro();
	private WPI_TalonSRX armMotor;
    public Arm() {
    	armMotor = new WPI_TalonSRX(RobotMap.armMotor);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoyStickArm());
    }
    
    
    /**
     * Default .set() method
     * @param moveValue -1.0 to 1.0
     */
    public void move(double moveValue) {
    	armMotor.set(moveValue);
    }
    
    
}
