
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "BlueHomeRunv022122.java", group = "")
public class BlueHomeRunv022122 extends LinearOpMode {

  private DcMotor Rightfrontmotor;
  private DcMotor Rightbackmotor;
  private DcMotor Leftfrontmotor;
  private DcMotor Leftbackmotor;
  private DcMotor CarouselMotor;
  private DcMotor ArmMotor;
  private Servo GripperMotor;

  private void goForward(){
    Leftfrontmotor.setPower(1);
    Leftbackmotor.setPower(1);
    Rightfrontmotor.setPower(1);
    Rightbackmotor.setPower(1);
  }
  
  private void goBackwards(){
    Leftfrontmotor.setPower(-1);
    Leftbackmotor.setPower(-1);
    Rightfrontmotor.setPower(-1);
    Rightbackmotor.setPower(-1);
  }
  
  private void goLeft(){
    Leftfrontmotor.setPower(-1);
    Leftbackmotor.setPower(1);
    Rightfrontmotor.setPower(1);
    Rightbackmotor.setPower(-1);
  }
  private void goRight(){
    Leftfrontmotor.setPower(1);
    Leftbackmotor.setPower(-1);
    Rightfrontmotor.setPower(-1);
    Rightbackmotor.setPower(1);
  }
  
  private void useSpin() {
    CarouselMotor.setPower(-0.6);
  }
  
  private void stopSpin() {
    CarouselMotor.setPower(0);
  }
  
  private void endMotion() {
    Leftfrontmotor.setPower(0);
    Leftbackmotor.setPower(-0);
    Rightfrontmotor.setPower(-0);
    Rightbackmotor.setPower(0);
  }
  
  private void useGripper() {
    GripperMotor.setPosition(9);
    waitForStart();
    GripperMotor.setPosition(9);
    ArmMotor.setPower(0.4);
    
    sleep(1600);
    GripperMotor.setPosition(0);
    sleep(900);
    
    ArmMotor.setPower(-0.4);
    sleep(1600);
  }
  
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    Rightfrontmotor = hardwareMap.dcMotor.get("Rightfrontmotor");
    Rightbackmotor = hardwareMap.dcMotor.get("Rightbackmotor");
    Leftfrontmotor = hardwareMap.dcMotor.get("Leftfrontmotor");
    Leftbackmotor = hardwareMap.dcMotor.get("Leftbackmotor");
    CarouselMotor = hardwareMap.dcMotor.get("Carousel Motor");
    ArmMotor = hardwareMap.dcMotor.get("Arm Motor");
    GripperMotor = hardwareMap.servo.get("Gripper Motor");
    
    // GRIPPER! [
    
    //GripperMotor.setPosition(9);
    //waitForStart();
    //GripperMotor.setPosition(9);
    //ArmMotor.setPower(0.4);
    
    //sleep(1600);
    //GripperMotor.setPosition(0);
    //sleep(900);
    
    //ArmMotor.setPower(-0.4);
    //sleep(1600);
    
    //]
    
    
    Rightfrontmotor.setDirection(DcMotorSimple.Direction.REVERSE);
    Rightbackmotor.setDirection(DcMotorSimple.Direction.REVERSE);
    GripperMotor.setPosition(9);
    waitForStart();
    
    
    if (opModeIsActive()) {
      goBackwards();
      sleep(950);
      useSpin();
      sleep(4500);
      stopSpin();
      goRight();
      sleep(750);
      endMotion();
    }
  }
}

