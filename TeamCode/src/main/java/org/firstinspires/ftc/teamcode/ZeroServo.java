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

    private Servo servo;
    private AutonMethods robot = new AutonMethods();
    public int driveswitch = 1;


    @Override
    public void runOpMode() {
        //region hardware map

        servo = hardwareMap.get(Servo.class, "servo");


        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        servo.setPosition(0);
        telemetry.addData("Status", "Zeroed");
        telemetry.update();
        while (opModeIsActive()) {

        }
    }
}




