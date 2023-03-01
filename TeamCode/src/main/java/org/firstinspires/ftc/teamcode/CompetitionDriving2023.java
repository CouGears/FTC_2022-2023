package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.AutonMethods;
import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;

//TODO: Uncomment the following line to use
@TeleOp
public class CompetitionDriving2023 extends LinearOpMode {

    public static DcMotor motorBR, motorBL, motorFL, motorFR, LiftRight, LiftLeft;
    public static Servo intake, armL, armR;
    private AutonMethods robot = new AutonMethods();
    public int driveswitch = 1;
    private int topLiftEncoder = 7475;
    private double botR = 1;
    private double topR = 0;
    private double botL = .35;
    private double topL = 0;
    private double right = 0;
    private double left = 0;

    @Override
    public void runOpMode() {
        //region hardware map
        LEDMethods LED = new LEDMethods();
        motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        LiftLeft = hardwareMap.get(DcMotor.class, "LiftLeft");
        LiftRight = hardwareMap.get(DcMotor.class, "LiftRight");

        intake = hardwareMap.get(Servo.class, "intake");
        armL = hardwareMap.get(Servo.class, "armL");
        armR = hardwareMap.get(Servo.class, "armR");

        LiftLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LiftRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LiftLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LiftRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LiftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LiftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorFL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorFR.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBR.setDirection(DcMotorSimple.Direction.FORWARD);
        LiftLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        LiftRight.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            if (driveswitch == 0) {
                motorFL.setPower(((this.gamepad1.right_stick_y) - (this.gamepad1.right_stick_x) + ((this.gamepad1.left_stick_y)) - (this.gamepad1.left_stick_x)));
                motorBL.setPower(-(-(this.gamepad1.right_stick_y) + (this.gamepad1.right_stick_x) - (this.gamepad1.left_stick_y) - (this.gamepad1.left_stick_x)));
                motorBR.setPower((-(this.gamepad1.right_stick_y) - (this.gamepad1.right_stick_x) - (this.gamepad1.left_stick_y) + (this.gamepad1.left_stick_x)));
                motorFR.setPower(-((this.gamepad1.right_stick_y) + (this.gamepad1.right_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.left_stick_x)));

            } else if (driveswitch == 1) {
                motorFL.setPower(((this.gamepad1.right_stick_y) - (this.gamepad1.right_stick_x) + ((this.gamepad1.left_stick_y)) - (this.gamepad1.left_stick_x)) * .6);
                motorBL.setPower(-(-(this.gamepad1.right_stick_y) + (this.gamepad1.right_stick_x) - (this.gamepad1.left_stick_y) - (this.gamepad1.left_stick_x)) * .6);
                motorBR.setPower((-(this.gamepad1.right_stick_y) - (this.gamepad1.right_stick_x) - (this.gamepad1.left_stick_y) + (this.gamepad1.left_stick_x)) * .6);
                motorFR.setPower(-((this.gamepad1.right_stick_y) + (this.gamepad1.right_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.left_stick_x)) * .6);
            } else if (driveswitch == 2) {
                motorFL.setPower(((this.gamepad1.right_stick_y) - (this.gamepad1.right_stick_x) + ((this.gamepad1.left_stick_y)) - (this.gamepad1.left_stick_x)) * .33);
                motorBL.setPower(-(-(this.gamepad1.right_stick_y) + (this.gamepad1.right_stick_x) - (this.gamepad1.left_stick_y) - (this.gamepad1.left_stick_x)) * .33);
                motorBR.setPower((-(this.gamepad1.right_stick_y) - (this.gamepad1.right_stick_x) - (this.gamepad1.left_stick_y) + (this.gamepad1.left_stick_x)) * .33);
                motorFR.setPower(-((this.gamepad1.right_stick_y) + (this.gamepad1.right_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.left_stick_x)) * .33);
            }
            if (gamepad1.a) {
                driveswitch = 2;
            }
            else if (gamepad1.x) {
                driveswitch = 1;
            }
           else if (gamepad1.y) {
                driveswitch = 0;
            }
            if (gamepad1.dpad_up && LiftRight.getCurrentPosition() <= topLiftEncoder) {
                //if(LiftRight.getCurrentPosition() <= topLiftEncoder) {
                LiftLeft.setPower(1);
                LiftRight.setPower(1);
                left = robot.maps(LiftRight.getCurrentPosition(), 0, topLiftEncoder, botL, topL);
                right = robot.maps(LiftRight.getCurrentPosition(), 0, topLiftEncoder, botR, topR);
                ;
                armL.setPosition(left);
                armR.setPosition(right);
                telemetry.addData("Left - motor", LiftLeft.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Right - motor", LiftRight.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Left - Servo", left);
                telemetry.addLine();
                telemetry.addData("Right - Servo", right);
                telemetry.addLine();
                telemetry.addData("Left - Servo Actual", armL.getPosition());
                telemetry.addLine();
                telemetry.addData("Right - Servo Actual", armR.getPosition());
                telemetry.update();
                //}
            } else if (gamepad1.dpad_down && LiftRight.getCurrentPosition() >= 0) {
                //if(LiftRight.getCurrentPosition() >= 0){
                LiftLeft.setPower(-1);
                LiftRight.setPower(-1);
                left = robot.maps(LiftRight.getCurrentPosition(), 0, topLiftEncoder, botL, topL);
                right = robot.maps(LiftRight.getCurrentPosition(), 0, topLiftEncoder, botR, topR);
                ;
                armL.setPosition(left);
                armR.setPosition(right);
                telemetry.addData("Left - motor", LiftLeft.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Right - motor", LiftRight.getCurrentPosition());
                telemetry.addLine();
                telemetry.addData("Left - Servo", left);
                telemetry.addLine();
                telemetry.addData("Right - Servo", right);
                telemetry.addLine();
                telemetry.addData("Left - Servo Actual", armL.getPosition());
                telemetry.addLine();
                telemetry.addData("Right - Servo Actual", armR.getPosition());
                telemetry.update();
            }
            else {
                LiftLeft.setPower(0);
                LiftRight.setPower(0);
            }
            if (gamepad1.right_trigger > 0.5) {
                intake.setPosition(.35);
            } else if (gamepad1.left_trigger > 0.5) {
                intake.setPosition(0);
            }
        }
    }
}





