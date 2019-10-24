/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This is a demo program showing the use of the RobotDrive class. The
 * SampleRobot class is the base of a robot application that will automatically
 * call your Autonomous and OperatorControl methods at the right time as
 * controlled by the switches on the driver station or the field controls.
 *
 * <p>The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 *
 * <p>WARNING: While it may look like a good choice to use for your code if
 * you're inexperienced, don't. Unless you know what you are doing, complex code
 * will be much more difficult under this system. Use TimedRobot or
 * Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";

  Spark left_m = new Spark(1);
  Spark right_m = new Spark(2);

  DifferentialDrive m_robotDrive
      = new DifferentialDrive(left_m, right_m);
  
  
  private final Joystick left_stick = new Joystick(0);
  private final Joystick right_stick = new Joystick(1);
  private final JoystickButton some_button = new JoystickButton(left_stick, 1);
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public Robot() {
    m_robotDrive.setExpiration(0.1);
  }

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto modes", m_chooser);
  }

  

  /**
   * Runs the motors with arcade steering.
   *
   * <p>If you wanted to run a similar teleoperated mode with an TimedRobot
   * you would write:
   *
   * <blockquote><pre>{@code
   * // This function is called periodically during operator control
   * public void teleopPeriodic() {
   *     myRobot.arcadeDrive(stick);
   * }
   * }</pre></blockquote>
   */
  @Override
  public void operatorControl() {
    m_robotDrive.setSafetyEnabled(true);
    while (isOperatorControl() && isEnabled()) {
      // Drive tank style
      m_robotDrive.tankDrive(-left_stick.getY(), -right_stick.getY());

      if (some_button.get())
      {
        //print("hit button");
      }

      // The motors will be updated every 5ms
      //Timer.delay(0.005);
    }
  }

  //@Override
  //public void some_button.toggleWhenPressed(Load_Cannon command)
  //{

  //}


}