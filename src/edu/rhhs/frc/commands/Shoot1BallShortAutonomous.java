package edu.rhhs.frc.commands;

import edu.rhhs.frc.subsystems.Chassis;
import edu.rhhs.frc.subsystems.Pivot;
import edu.rhhs.frc.subsystems.Winch;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;

/**
 * @author rhhs
 */
public class Shoot1BallShortAutonomous extends CommandGroup {
    
    public Shoot1BallShortAutonomous() {     
        addParallel(new PivotSetAngle(Pivot.PIVOT_POSITION_FORWARD_SHORT_SHOT));
        addParallel(new ChassisMove(158, Chassis.MOVE_AUTON_SPEED, true)); 
        addSequential(new WaitForChildren());
        addSequential(new ChassisMoveForTime(1.0, -0.5));

        addSequential(new ShootSequence(Winch.WINCH_DISTANCE_SHORT_SHOT));
    }
}

