package org.usfirst.frc.team949.robot.subsystems;

import org.usfirst.frc.team949.robot.RobotMap;
import org.usfirst.frc.team949.robot.commands.JoyStickArm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Arm extends Subsystem {

    // Initialize your subsystem here
	private Encoder s = new Encoder();
	private WPI_TalonSRX armMotor;
    public Arm() {
    	armMotor = new WPI_TalonSRX(RobotMap.armMotor);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new JoyStickArm());
    }
    
    public ADXRS450_Gyro getGyro() {
    	return g;
    }
    
    
    /**
     * Default .set() method
     * @param moveValue -1.0 to 1.0
     */
    public void move(double moveValue) {
    	armMotor.set(moveValue);
    }
    
    
}
