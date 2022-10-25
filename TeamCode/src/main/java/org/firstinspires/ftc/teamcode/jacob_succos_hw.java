package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;
import org.firstinspires.ftc.robotcore.external.Telemetry;
//can you do it with a name cause it wasn't working
@TeleOp
public class jacob_succos_hw extends LinearOpMode {
DcMotor motor1;

    @Override
    public void runOpMode()  {
        waitForStart();
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setTargetPosition(2500);
        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //waitforstart   can have if want

        //motor1.setPower(.9283948293);
    }
}
