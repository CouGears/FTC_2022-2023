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

    private Servo clawLift;
    private AutonMethods robot = new AutonMethods();

    @Override
    public void runOpMode() {


        clawLift = hardwareMap.get(Servo.class, "clawLift");

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {

            if(gamepad1.a)
            {clawLift.setPosition(0);
                telemetry.addData("Button" , "A");
                telemetry.update();}
            if(gamepad1.b)
            {clawLift.setPosition(1);
                telemetry.addData("Button" , "B");
                telemetry.update();}
            if(gamepad1.x)
            {clawLift.setPosition(-1);
                telemetry.addData("Button" , "Y");
                telemetry.update();}
            if(gamepad1.dpad_up)
            {clawLift.setPosition(0.5);
                telemetry.addData("Button" , "Up");
                telemetry.update();}
            if(gamepad1.dpad_down)
            {clawLift.setPosition(-0.5);
                telemetry.addData("Button" , "Down");
                telemetry.update();}
        }
    }
}