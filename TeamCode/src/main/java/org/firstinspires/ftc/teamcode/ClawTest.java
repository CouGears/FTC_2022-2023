package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.AutonMethods;
import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;

@TeleOp
//uncomment line above to use
public class ClawTest extends LinearOpMode {

    private Servo clawLeft, clawRight;
    private AutonMethods robot = new AutonMethods();

    @Override
    public void runOpMode() {


        clawLeft = hardwareMap.get(Servo.class, "clawLeft");
        clawRight = hardwareMap.get(Servo.class, "clawRight");
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {

            if(gamepad1.a)
            {clawLeft.setPosition(0);clawRight.setPosition(0);
                telemetry.addData("Position" , "0");
                telemetry.update();}
            if(gamepad1.b)
            {clawLeft.setPosition(1);clawRight.setPosition(-1);
                telemetry.addData("Position" , "1");
                telemetry.update();}
            if(gamepad1.x)
            {clawLeft.setPosition(-1);clawRight.setPosition(1);
                telemetry.addData("Position" , "-1");
                telemetry.update();}
            if(gamepad1.dpad_up)
            {clawLeft.setPosition(0.5);clawRight.setPosition(-0.5);
                telemetry.addData("Position" , "0.5");
                telemetry.update();}
            if(gamepad1.dpad_down)
            {clawLeft.setPosition(-0.5);clawRight.setPosition(0.5);
                telemetry.addData("Position" , "-0.5");
                telemetry.update();}
        }
    }
}