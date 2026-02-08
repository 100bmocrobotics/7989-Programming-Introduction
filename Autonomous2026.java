package org.firstinspires.ftc.teamcode;

import android.graphics.Camera;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;



@Autonomous(name = "Debug Autonomous")
public class Autonomous2026 extends LinearOpMode {
	/* 
	start up the variables so they can be referenced without causing any errors
	but, you cannot do hardwareMap.get() until you're inside of the runOpMode
	*/
	
	DcMotor rbMotor;
	DcMotor rfMotor;
	DcMotor lfMotor;
	DcMotor lbMotor;

	DcMotor intakeL;
	DcMotor intakeR;

	DcMotor shootL;
	
	/*
	General Functions
	mainly for percise movement but you'd wanna have the sequences in their own thing
	since it visually looks better for reference
	*/
	
	public void reset(){
		lfMotor.setPower(0);
		lbMotor.setPower(0);
		rfMotor.setPower(0);
		rbMotor.setPower(0);
	}

	public void resetSecondaries(){
		intakeL.setPower(0);
		intakeR.setPower(0);
	}

	public void move(String dir, long len){
		if (dir == "fwd")
		{
			lfMotor.setPower(1);
			lbMotor.setPower(1);
			rfMotor.setPower(1);
			rbMotor.setPower(1);
		} else if (dir == "back")
		{
			lfMotor.setPower(-1);
			lbMotor.setPower(-1);
			rfMotor.setPower(-1);
			rbMotor.setPower(-1);
		} else if (dir == "right")
		{
			lfMotor.setPower(1);
			lbMotor.setPower(1);
			rfMotor.setPower(-1);
			rbMotor.setPower(-1);
		} else if (dir == "left")
		{
			lfMotor.setPower(-1);
			lbMotor.setPower(-1);
			rfMotor.setPower(1);
			rbMotor.setPower(1);
		}

		sleep(len);

		reset();
	}

	public void turn(String dir, long len){
		if (dir == "left")
		{
			lfMotor.setPower(-1);
			lbMotor.setPower(-1);
			rfMotor.setPower(1);
			rbMotor.setPower(1);
		} else if (dir == "right")
		{
			lfMotor.setPower(1);
			lbMotor.setPower(1);
			rfMotor.setPower(-1);
			rbMotor.setPower(-1);
		}

		sleep(len);

		reset();
	}

	public void strafe(String dir, long len){
		if (dir == "left")
		{
			lfMotor.setPower(1);
			lbMotor.setPower(-1);
			rfMotor.setPower(-1);
			rbMotor.setPower(1);
		} else if (dir == "right")
		{
			lfMotor.setPower(-1);
			lbMotor.setPower(1);
			rfMotor.setPower(1);
			rbMotor.setPower(-1);
		}

		sleep(len);

		reset();
	}

	public void intake(long len){
		intakeL.setPower(1);
		intakeR.setPower(1);

		sleep(len);

		resetSecondaries();
	}

	public void shoot(long len, boolean continuousMotion){
		shootL.setPower(1);
		sleep(len);

		resetSecondaries();
	}

	/*
	Sequences
	for reference, use blue mainly and also they're literally inversed for turns
	*/
	


	@Override
	public void runOpMode() {
		rbMotor = hardwareMap.get(DcMotor.class, "Rbmotor");
		rfMotor = hardwareMap.get(DcMotor.class, "Rfmotor");
		lfMotor = hardwareMap.get(DcMotor.class, "Lfmotor");
		lbMotor = hardwareMap.get(DcMotor.class, "Lbmotor");
	
		intakeL = hardwareMap.get(DcMotor.class, "intakeL");
		intakeR = hardwareMap.get(DcMotor.class, "intakeR");
	
		shootL = hardwareMap.get(DcMotor.class, "shootL");
		
		// if below changed then change it for controller first and then copy here

		shootL.setDirection(DcMotorSimple.Direction.REVERSE);
		
		rfMotor.setDirection(DcMotorSimple.Direction.REVERSE);
		lfMotor.setDirection(DcMotorSimple.Direction.REVERSE);

		shootL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

		// ok thats enough things that are shared

		waitForStart();
		/*
		100 sleep = 1 second
		*/
		if (opModeIsActive()) {
			// insert code here
		}
	}
}//

