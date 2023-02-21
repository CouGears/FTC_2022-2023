package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.AutonMethods;
import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;

@TeleOp
public class Liftthingtest extends LinearOpMode {

    public static DcMotor motorBR, motorBL, motorFL, motorFR, LiftRight, LiftLeft;
    public static Servo intake, armL, armR;
    private AutonMethods robot = new AutonMethods();
    public int driveswitch = 1;
    public int total = 0;
    public int topLiftEncoder = 10000;

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
            if (gamepad1.x) {
                driveswitch = 1;
            }
            if (gamepad1.y) {
                driveswitch = 0;
            }
            if (gamepad1.dpad_up){
                if( LiftLeft.getCurrentPosition() <= topLiftEncoder)
                {
                    LiftLeft.setPower(.3);
                    LiftRight.setPower(.3);
                    armL.setPosition(robot.maps(LiftLeft.getCurrentPosition(), 0, topLiftEncoder, 0, 1 ));
                    armR.setPosition(robot.maps(LiftLeft.getCurrentPosition(), 0, topLiftEncoder, 0, (270/180)));
                }

            }
            else if(gamepad1.dpad_down){
                if(LiftLeft.getCurrentPosition()>=0)
                {
                    LiftLeft.setPower(-.3);
                    LiftRight.setPower(-.3);
                    armL.setPosition(robot.maps(LiftLeft.getCurrentPosition(), 0, topLiftEncoder, 0, 1 ));
                    armR.setPosition(robot.maps(LiftLeft.getCurrentPosition(), 0, topLiftEncoder, 0, (270/180)));
                }

            }
            else
            {
                LiftLeft.setPower(0);
                LiftRight.setPower(0);
            }
            if(gamepad1.right_bumper){
                armL.setPosition(-1);
                armR.setPosition(1);
            }
            else if(gamepad1.b){
                armL.setPosition(1);
                armR.setPosition(-1);
            }
            if(gamepad1.left_bumper){
                intake.setPosition(1);
            }
            if(gamepad1.left_trigger>0.4){
                intake.setPosition(-1);
            }
            telemetry.addData("tot", total);
            telemetry.update();
        }
    }
}




