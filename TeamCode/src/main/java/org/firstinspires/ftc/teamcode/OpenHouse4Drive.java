package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;


@TeleOp
public class OpenHouse4Drive extends LinearOpMode {

    private DcMotor motorBR, motorBL, motorFL, motorFR;
    private AutonMethods robot = new AutonMethods();

    double ticks = 1124; // ticks for cap motor; half rotation of arm

    @Override
    public void runOpMode() {
        //region hardware map
        motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        motorFR = hardwareMap.get(DcMotor.class, "motorFR");



        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorFL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorFR.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBR.setDirection(DcMotorSimple.Direction.FORWARD);
        //endregion

        telemetry.addData("Status", "Initialized");
        telemetry.update();

//      intakeServo.setPosition(1);
        waitForStart();

        while (opModeIsActive()) {


                motorFL.setPower(((this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1);
                motorBL.setPower(((this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (-this.gamepad1.right_stick_x)) * 1);
                motorBR.setPower(((-this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (-this.gamepad1.left_stick_y) + (-this.gamepad1.right_stick_x)) * 1);
                motorFR.setPower(((-this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (-this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1);
//
        }
    }
}
