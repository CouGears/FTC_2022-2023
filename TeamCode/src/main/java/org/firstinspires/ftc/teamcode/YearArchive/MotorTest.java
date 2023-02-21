package org.firstinspires.ftc.teamcode.YearArchive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.AutonMethods;
import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;

//uncomment the following to use
@TeleOp
public class MotorTest extends LinearOpMode {

    private DcMotor LiftRight, LiftLeft;
    private Servo armL, armR;
    private AutonMethods robot = new AutonMethods();


    @Override
    public void runOpMode() {
        //region hardware map
        LEDMethods LED = new LEDMethods();
        LiftLeft = hardwareMap.get(DcMotor.class, "LiftLeft");
        LiftRight = hardwareMap.get(DcMotor.class, "LiftRight");

        armR = hardwareMap.get(Servo.class, "armR");
        armL = hardwareMap.get(Servo.class, "armL");


        LiftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LiftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        LiftLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        LiftRight.setDirection(DcMotorSimple.Direction.FORWARD);



        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                LiftLeft.setPower(-.2);
                LiftRight.setPower(-.2);
                telemetry.addData("Lift1 position, Lift2 Position - " + LiftLeft.getCurrentPosition() + "," , LiftRight.getCurrentPosition());
                telemetry.update();
            }
            else if (gamepad1.b) {
                LiftLeft.setPower(.4);
                LiftRight.setPower(.4);
                telemetry.addData("Lift1 position, Lift2 Position - " + LiftLeft.getCurrentPosition() + "," , LiftRight.getCurrentPosition());
                telemetry.update();
            }
            else if (gamepad1.x) {
                LiftLeft.setPower(.6);
                LiftRight.setPower(.6);
                telemetry.addData("Lift1 position, Lift2 Position - " + LiftLeft.getCurrentPosition() + "," + LiftRight.getCurrentPosition(), 0);
                telemetry.update();
            }
            else if (gamepad1.y) {
                LiftLeft.setPower(.2);
                LiftRight.setPower(.2);
                telemetry.addData("Lift1 position, Lift2 Position - " + LiftLeft.getCurrentPosition() + "," , LiftRight.getCurrentPosition());
                telemetry.update();
            }
            else{
                LiftRight.setPower(0);
                LiftLeft.setPower(0);
            }

            if(gamepad1.left_bumper)
            {armR.setPosition(0);armL.setPosition(0);
                telemetry.addData("Position" , "0");
                telemetry.update();}
        }
    }
}





