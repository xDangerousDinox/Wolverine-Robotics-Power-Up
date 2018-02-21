package org.usfirst.frc.team949.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommand extends CommandGroup {
	
	private void moveToLeftSwitch(char startingPosition) {
		final char L = 'L';
		final char M = 'M';
		final char R = 'R';
		if (startingPosition == L) {
			addSequential(new HardTurn(0.1, 90)); //turn toward left end switch
			addSequential(new HardMove(.10, 60)); //move to switch
			addSequential(new HardTurn(0.1, 90)); //turn forward
		} else {
			if (startingPosition == M) {
				addSequential(new HardTurn(0.1, 90)); //turn left 90
				addSequential(new HardMove(.10, 60)); //move to left end
			} else if (startingPosition == R) {
				addSequential(new HardTurn(0.1, 90)); //turn left 90
				addSequential(new HardMove(.10, 60)); //move to left end
			}
			addSequential(new HardTurn(0.1, 90)); //turn toward left end switch
			addSequential(new HardMove(.10, 60)); //move to switch
			addSequential(new HardTurn(0.1, 60)); //turn forward
		}
	}
	
	private void moveToRightSwitch(char startingPosition) {
		final char L = 'L';
		final char M = 'M';
		final char R = 'R';
		if (startingPosition == L) {
			addSequential(new HardTurn(0.1, 90)); //turn toward right end switch
			addSequential(new HardMove(.10, 60)); //move to switch
			addSequential(new HardTurn(0.1, 90)); //turn forward
		} else {
			if (startingPosition == M) {
				addSequential(new HardTurn(0.1, 90)); //turn right 90
				addSequential(new HardMove(.10, 60)); //move to right end
			} else if (startingPosition == R) {
				addSequential(new HardTurn(0.1, 90)); //turn right 90
				addSequential(new HardMove(.10, 60)); //move to right end
			}
			addSequential(new HardTurn(0.1, 90)); //turn toward right end switch
			addSequential(new HardMove(.10, 60)); //move to switch
			addSequential(new HardTurn(0.1, 60)); //turn forward
		}
	}
	
	private void shoot(double angle) {
		addParallel(new HardWristMove(60,60));
		addSequential(new HardArmMove(60, 60));
		addSequential(new HardHandRelease(60));
	}

	public AutoCommand(char startingPosition, String targetScoring, String gameData) {
		final char L = 'L';
		final char M = 'M';
		final char R = 'R';
		char firstSwitch = gameData.charAt(0);
		char scale = gameData.charAt(1);
		switch (targetScoring) {
		case "Scale":
			if (scale == L) {
				moveToLeftSwitch(startingPosition);
			} else {
				moveToRightSwitch(startingPosition);
			}
			addSequential(new HardMove(0.1, 60)); //move to scale
			addSequential(new HardTurn(0.1, 60)); //turn toward scale
			shoot(0); //angle
		case "Switch":
			if (scale == L) {
				moveToLeftSwitch(startingPosition);
			} else {
				moveToLeftSwitch(startingPosition);
			}
			shoot(1); //shoot angle
		case "Auto-Line":
			addSequential(new HardMove(Integer.MAX_VALUE, Integer.MAX_VALUE));
		}
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}
}
