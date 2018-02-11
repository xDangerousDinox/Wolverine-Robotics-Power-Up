package org.usfirst.frc.team949.robot.subsystems;

import org.usfirst.frc.team949.robot.RobotMap;
import org.usfirst.frc.team949.robot.commands.ClimberControl;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    private WPI_TalonSRX climberMotor1;
    private WPI_TalonSRX climberMotor2;
	
    public void initDefaultCommand() {
        setDefaultCommand(new ClimberControl());
    }
    
    public Climber() 
    {
    	climberMotor1 = new WPI_TalonSRX(RobotMap.climberMotor1);
    	climberMotor2 = new WPI_TalonSRX(RobotMap.climberMotor2);
    	
    	climberMotor1.setInverted(true);
    	climberMotor2.setInverted(true);
    }
    
    /**
	 * Calls the .set() method on both pickup motors
	 * @param rate the double that goes in someMotor.set(rate); as parameter.
	 */
    public void setBothMotors(double rate) 
    {
    	climberMotor1.set(rate);
    	climberMotor2.set(rate);
    }
}

