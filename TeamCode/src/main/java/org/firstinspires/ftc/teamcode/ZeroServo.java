package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.AutonMethods;
import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;

@TeleOp
public class ZeroServo extends LinearOpMode {

    private Servo armL, armR;
    private AutonMethods robot = new AutonMethods();
    public int driveswitch = 1;


    @Override
    public void runOpMode() {
        //region hardware map

        armL = hardwareMap.get(Servo.class, "armL");
        armR = hardwareMap.get(Servo.class, "armR");


        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        armL.setPosition(0);
        armR.setPosition(0);
        telemetry.addData("Status", "Zeroed");
        telemetry.update();
        while (opModeIsActive()) {
            armL.setPosition(0);
            armR.setPosition(0);
        }
    }
}




