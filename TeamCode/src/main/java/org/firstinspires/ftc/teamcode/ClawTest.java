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

            if(gamepad1.a)
            {claw.setPosition(0);
                telemetry.addData("Button" , "A");
                telemetry.update();}
            if(gamepad1.b)claw.setPosition(1);
            if(gamepad1.x)claw.setPosition(-1);
            if(gamepad1.y)claw.setPosition(0);
            if(gamepad1.dpad_up)claw.setPosition(.5);
            if(gamepad1.dpad_down)claw.setPosition(-.5);
        }
    }
}