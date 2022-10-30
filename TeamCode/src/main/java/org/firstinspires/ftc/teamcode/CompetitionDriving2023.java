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
public class CompetitionDriving2023 extends LinearOpMode {

    private DcMotor motorBR, motorBL, motorFL, motorFR, lift, release;
    private Servo claw;
    private AutonMethods robot = new AutonMethods();
    public int driveswitch = 0;


    @Override
    public void runOpMode() {
        //region hardware map
        LEDMethods LED = new LEDMethods();
        motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        lift = hardwareMap.get(DcMotor.class, "lift");
        release = hardwareMap.get(DcMotor.class, "release");

        claw = hardwareMap.get(Servo.class, "claw");


        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        release.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorFL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorFR.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBR.setDirection(DcMotorSimple.Direction.FORWARD);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);
        release.setDirection(DcMotorSimple.Direction.FORWARD);

        release.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();


        while (opModeIsActive()) {

            //region drive code
            if (driveswitch == 0) {
                motorFL.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (-this.gamepad1.right_stick_x)) * 1);
                motorBL.setPower((-(this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (-this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1);
                motorBR.setPower(-((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1);
                motorFR.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1);
//               motorFL.setPower(Math.max(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (-this.gamepad1.right_stick_x)) * 1,((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (-this.gamepad1.right_stick_x)) * d2beta));
//                motorBL.setPower(Math.max((-(this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (-this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1,(-(this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (-this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1*d2beta));
//                motorBR.setPower(Math.max(-((this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1,-((this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * d2beta));
//                motorFR.setPower(Math.max(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1,((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * d2beta));


            } else if (driveswitch == 1) {
                motorFL.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (-this.gamepad1.right_stick_x)));
                motorBL.setPower((-(this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (-this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)));
                motorBR.setPower(-((this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)));
                motorFR.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)));
            }

            if (gamepad1.dpad_up)
            {
                lift.setPower(1);//may need to speed up or slow down
            }
            else if (gamepad1.dpad_down)
            {
                lift.setPower(-1);//may need speed up or slow down
            }
            else
            {
                lift.setPower(0);
            }

            if (gamepad1.right_trigger>.5)
            {
                /*
                release.setTargetPosition(-25);//change this to make encoder make sense
                release.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                release.setPower(.6);//may need to change power*/
                release.setPower(.3);
            }
            else if (gamepad1.left_trigger>.5)
            {
                /*
                release.setTargetPosition(0);
                release.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                release.setPower(.6);//may need to change power*/

                release.setPower(-.3);
            }
            else
            {
                release.setPower(0);
            }

            if(gamepad1.right_bumper)
            {
                claw.setPosition(0);//need to tune this it is a servo from 0-1 0 = 0 degrees 1 = 180
            }
            else if(gamepad1.left_bumper)
            {
                claw.setPosition(.3);//need to tune this it is a servo from 0-1 0 = 0 degrees 1 = 180
            }


            /*if (gamepad1.b || gamepad2.a) {

            } else {

            }
            if (gamepad1.dpad_left) {

            } else if (gamepad1.dpad_right) {

            } else {

            }

            //region Real capping mechanism
            if (gamepad2.left_bumper) {

            } else if (gamepad2.left_trigger > .5) {

            } else {

            }
*/
        }

    }
}
