package org.usfirst.frc.team949.robot.subsystems;

import org.usfirst.frc.team949.robot.Robot;
import org.usfirst.frc.team949.robot.RobotMap;
import org.usfirst.frc.team949.robot.commands.JoyStickArm;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

	// Initialize your subsystem here
	private WPI_TalonSRX armMotor;
	private final double ratio = 3.6*4096*2*Math.PI;//encode tick per arm rev

	public Arm() {
		armMotor = new WPI_TalonSRX(RobotMap.armMotor);

		armMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		armMotor.setSensorPhase(false);
		armMotor.setSelectedSensorPosition(0, 0, 0);
		
	}

	public void initDefaultCommand() {
		setDefaultCommand(new JoyStickArm());
	}

	public double getEncoderPosition() {
		return armMotor.getSelectedSensorPosition(0)/ratio;
	}

	public double getEncoderVelocity() {
		return armMotor.getSelectedSensorVelocity(0)/ratio;
	}

	/**
	 * Default .set() method
	 * 
	 * @param moveValue
	 *            -1.0 to 1.0
	 */
	public void move(double moveValue) {
		armMotor.set(moveValue);
	}

}
