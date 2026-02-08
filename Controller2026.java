package org.firstinspires.ftc.teamcode;

import android.graphics.Camera;
import com.qualcomm.robotcore.hardware.CRServo;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Controller")
public class Controller2026 extends LinearOpMode {
  	DcMotor rbMotor;
		DcMotor rfMotor;
		DcMotor lfMotor;
		DcMotor lbMotor;

		DcMotor intakeL;
		DcMotor intakeR;

		DcMotor shootL;
	@Override
	public void runOpMode() {
		// config for yes
		rbMotor = hardwareMap.get(DcMotor.class, "Rbmotor");
		rfMotor = hardwareMap.get(DcMotor.class, "Rfmotor");
		lfMotor = hardwareMap.get(DcMotor.class, "Lfmotor");
		lbMotor = hardwareMap.get(DcMotor.class, "Lbmotor");

		intakeL = hardwareMap.get(DcMotor.class, "intakeL");
		intakeR = hardwareMap.get(DcMotor.class, "intakeR");

		shootL = hardwareMap.get(DcMotor.class, "shootL");

		rfMotor.setDirection(DcMotorSimple.Direction.REVERSE);
		lfMotor.setDirection(DcMotorSimple.Direction.REVERSE);

		intakeL.setDirection(DcMotorSimple.Direction.REVERSE);
		
		waitForStart();

		while (opModeIsActive())  {
				// gamepad 1 controls

				rfMotor.setPower((gamepad1.right_stick_y/sens));
				rbMotor.setPower((gamepad1.right_stick_y/sens));
				lfMotor.setPower((gamepad1.left_stick_y/sens));
				lbMotor.setPower((gamepad1.left_stick_y/sens));

				if (gamepad1.left_bumper)
				{
					lfMotor.setPower(1);
					lbMotor.setPower(-1);
					rfMotor.setPower(-1);
					rbMotor.setPower(1);
				}

				if (gamepad1.right_bumper)
				{
					lfMotor.setPower(-1);
					lbMotor.setPower(1);
					rfMotor.setPower(1);
					rbMotor.setPower(-1);
				}

				// gamepad 2 controls

				double lsy = (gamepad2.left_stick_y/sens);
				
				intakeL.setPower(gamepad2.left_stick_y);
				intakeR.setPower(gamepad2.left_stick_y);
				
				if (gamepad2.right_stick_y > 0.01 || gamepad2.right_stick_y < 0.01)
				{
					shootL.setPower(gamepad2.right_stick_y);
					intakeL.setPower(0);
					intakeR.setPower(0);
				} else if (gamepad2.left_stick_y > 0.01 || gamepad2.left_stick_y < 0.01)
				{
					shootL.setPower(0);
					intakeL.setPower(gamepad2.left_stick_y);
					intakeR.setPower(gamepad2.left_stick_y);
				} else
				{
					shootL.setPower(0);
					intakeL.setPower(0);
					intakeR.setPower(0);
				}
				double leftWheelsAvrg = (lbMotor.getPower()+lfMotor.getPower())/2;
				double rightWheelsAvrg = (rbMotor.getPower()+rfMotor.getPower())/2;

				telemetry.addData("Controls", "Gamepad 1");

				telemetry.addData("Left Side Wheels", "Left Joystick");
				telemetry.addData("Right Right Wheels", "Right Joystick");

				telemetry.addData("Strafe Left", "Left Bumper");
				telemetry.addData("Strafe Right", "Right Bumper");

				telemetry.addData("Controls", "Gamepad 2");
      
				telemetry.addData("Intake Motor", "Left Joystick");
				telemetry.addData("Shoot Motor", "Right Joystick");

				telemetry.addData("Personal Configuration", "Gamepad 1");

				telemetry.addData("Values", "----");

				telemetry.addData("Left Joystick (GP2)", gamepad2.left_stick_y);
				telemetry.addData("Right Joystick (GP2)", gamepad2.right_stick_y);

				telemetry.addData("Left Wheels Average Power", leftWheelsAvrg);
				telemetry.addData("Right Wheels Average Power", rightWheelsAvrg);
				telemetry.addData("Shooter Power", shootL.getPower());
				telemetry.addData("Overall Wheels Average Power", (leftWheelsAvrg+rightWheelsAvrg)/2);
      
				telemetry.update();
			}
	}
}//

