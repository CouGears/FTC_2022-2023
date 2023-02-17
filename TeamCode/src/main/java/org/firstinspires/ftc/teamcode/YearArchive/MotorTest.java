package org.firstinspires.ftc.teamcode.YearArchive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.AutonMethods;
import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;

//uncomment the following to use
//@TeleOp
public class MotorTest extends LinearOpMode {

    private DcMotor lift1, lift2;
    private Servo shoulder1, shoulder2;
    private AutonMethods robot = new AutonMethods();


    @Override
    public void runOpMode() {
        //region hardware map
        LEDMethods LED = new LEDMethods();
        lift1 = hardwareMap.get(DcMotor.class, "lift1");
        lift2 = hardwareMap.get(DcMotor.class, "lift2");

        shoulder1 = hardwareMap.get(Servo.class, "shoulder1");
        shoulder2 = hardwareMap.get(Servo.class, "shoulder2");


        lift1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lift1.setDirection(DcMotorSimple.Direction.FORWARD);
        lift2.setDirection(DcMotorSimple.Direction.FORWARD);



        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                lift1.setPower(.2);
                lift2.setPower(.2);
                telemetry.addData("Lift1 position, Lift2 Position - " + lift1.getCurrentPosition() + "," + lift2.getCurrentPosition(), 0);
                telemetry.update();
            }
            else if (gamepad1.b) {
                lift1.setPower(.4);
                lift2.setPower(.4);
                telemetry.addData("Lift1 position, Lift2 Position - " + lift1.getCurrentPosition() + "," + lift2.getCurrentPosition(), 0);
                telemetry.update();
            }
            else if (gamepad1.x) {
                lift1.setPower(.6);
                lift2.setPower(.6);
                telemetry.addData("Lift1 position, Lift2 Position - " + lift1.getCurrentPosition() + "," + lift2.getCurrentPosition(), 0);
                telemetry.update();
            }
            else if (gamepad1.y) {
                lift1.setPower(.8);
                lift2.setPower(.8);
                telemetry.addData("Lift1 position, Lift2 Position - " + lift1.getCurrentPosition() + "," + lift2.getCurrentPosition(), 0);
                telemetry.update();
            }
            else{
                lift1.setPower(0);
                lift2.setPower(0);
            }

            if(gamepad1.left_bumper)
            {shoulder1.setPosition(0);shoulder2.setPosition(0);
                telemetry.addData("Position" , "0");
                telemetry.update();}
            if(gamepad1.right_bumper)
            {shoulder1.setPosition(1);shoulder2.setPosition(1);
                telemetry.addData("Position" , "1");
                telemetry.update();}
            if(gamepad1.dpad_right)
            {shoulder1.setPosition(0.9);shoulder2.setPosition(0.9);
                telemetry.addData("Position" , "0.9");
                telemetry.update();}
            if(gamepad1.dpad_left)
            {shoulder1.setPosition(0.2);shoulder2.setPosition(0.2);
                telemetry.addData("Position" , "0.2");
                telemetry.update();}
            if(gamepad1.dpad_up)
            {shoulder1.setPosition(0.5);shoulder2.setPosition(0.5);
                telemetry.addData("Position" , "0.5");
                telemetry.update();}
            if(gamepad1.dpad_down)
            {shoulder1.setPosition(0.1);shoulder2.setPosition(0.1);
                telemetry.addData("Position" , "0.1");
                telemetry.update();}
        }
    }
}





