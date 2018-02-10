package org.usfirst.frc.team949.robot.subsystems;

import org.usfirst.frc.team949.robot.RobotMap;
import org.usfirst.frc.team949.robot.commands.JoyStickArm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Initialize your subsystem here
	private Encoder armEnc;
	private WPI_TalonSRX armMotor;
	
    public Arm() {
    	armEnc = new Encoder(RobotMap.armEncoderForward, RobotMap.armEncoderBackward);
    	armMotor = new WPI_TalonSRX(RobotMap.armMotor);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new JoyStickArm());
    }
    
    public Encoder getEncoder() {
    	return armEnc;
    }
    
    
    /**
     * Default .set() method
     * @param moveValue -1.0 to 1.0
     */
    public void move(double moveValue) {
    	armMotor.set(moveValue);
    }
    
    
}
