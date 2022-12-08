package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.AutonMethods;
import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;

@TeleOp
//Hi Oran
public class ClawTest extends LinearOpMode {

    private Servo claw;
    private AutonMethods robot = new AutonMethods();

    @Override
    public void runOpMode() {


        claw = hardwareMap.get(Servo.class, "claw");

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.right_bumper) {
                claw.setPosition(1);//need to tune this it is a servo from -1 -> 1 -1 = 0 degrees 1 = 180
            } else {
                claw.setPosition(-1);//need to tune this it is a servo from -1 -> 1 -1 = 0 degrees 1 = 180
            }
        }
    }
}