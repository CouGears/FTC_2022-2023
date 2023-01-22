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
public class MotorTest extends LinearOpMode {

    private DcMotor clawLeft, clawRight;
    private AutonMethods robot = new AutonMethods();

    @Override
    public void runOpMode() {


        clawLeft = hardwareMap.get(DcMotor.class, "clawLeft");
        clawRight = hardwareMap.get(DcMotor.class, "clawRight");
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                clawLeft.setPower(1);
                clawRight.setPower(1);
                telemetry.addData("Left Position", clawLeft.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Right Position", clawRight.getCurrentPosition());
                telemetry.update();
            }
            else if (gamepad1.dpad_down) {
                clawLeft.setPower(-1);
                clawRight.setPower(-1);
                telemetry.addData("Left Position", clawLeft.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Right Position", clawRight.getCurrentPosition());
                telemetry.update();
            }
            else if (gamepad1.dpad_right) {
                clawLeft.setPower(0);
                clawRight.setPower(1);
                telemetry.addData("Left Position", clawLeft.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Right Position", clawRight.getCurrentPosition());
                telemetry.update();
            }
            else if (gamepad1.dpad_left) {
                clawLeft.setPower(1);
                clawRight.setPower(0);
                telemetry.addData("Left Position", clawLeft.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Right Position", clawRight.getCurrentPosition());
                telemetry.update();
            }
            else if (gamepad1.a) {
                clawRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                clawLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                telemetry.addData("Left Position", "restting encoder");
                telemetry.addLine();
                telemetry.addData("Right Position", "restting encoder");
                telemetry.update();
                clawRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                clawLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }
            else {
                clawLeft.setPower(0);
                clawRight.setPower(0);
                telemetry.addData("Left Position", clawLeft.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Right Position", clawRight.getCurrentPosition());
                telemetry.update();
            }
        }
    }
}
