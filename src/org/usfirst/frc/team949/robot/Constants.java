package org.usfirst.frc.team949.robot;

public class Constants {

	// Stored in inches
	public final static double wheelbase = 23.5;
	public final static int wheel_diameter = 6;
	
	public double in2cm(double in)
	{
		return in * 2.54;
	}
	
	public double cm2in(double cm)
	{
		return cm / 2.54;
	}
	
}
