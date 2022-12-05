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
    private Servo claw, clawLift;
    private AutonMethods robot = new AutonMethods();
    public int driveswitch = 1;


    @Override
    public void runOpMode() {
        //region hardware map
        LEDMethods LED = new LEDMethods();
        motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        lift = hardwareMap.get(DcMotor.class, "lift");


        claw = hardwareMap.get(Servo.class, "claw");
        clawLift = hardwareMap.get(Servo.class, "clawLift");


        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        motorFL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorFR.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBR.setDirection(DcMotorSimple.Direction.FORWARD);
        lift.setDirection(DcMotorSimple.Direction.FORWARD);



        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        clawLift.setPosition(.5);
        while (opModeIsActive()) {

            //region drive code
            if (driveswitch == 0) {
                motorFL.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + ((this.gamepad1.left_stick_y)) + (this.gamepad1.right_stick_x)) * 1);
                motorBL.setPower(-((this.gamepad1.right_stick_y) - (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1*.67);
                motorBR.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) - (this.gamepad1.right_stick_x)) * 1*.67);
                motorFR.setPower(-((this.gamepad1.right_stick_y) - (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) - (this.gamepad1.right_stick_x)) * 1);
//               motorFL.setPower(Math.max(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (-this.gamepad1.right_stick_x)) * 1,((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (-this.gamepad1.right_stick_x)) * d2beta));
//                motorBL.setPower(Math.max((-(this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (-this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1,(-(this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (-this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1*d2beta));
//                motorBR.setPower(Math.max(-((this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1,-((this.gamepad1.right_stick_y) + (-this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * d2beta));
//                motorFR.setPower(Math.max(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * 1,((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * d2beta));


            } else if (driveswitch == 1) {
                motorFL.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + ((this.gamepad1.left_stick_y)) + (this.gamepad1.right_stick_x)) * .6);
                motorBL.setPower(-((this.gamepad1.right_stick_y) - (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * .6*.67);
                motorBR.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) - (this.gamepad1.right_stick_x)) * .6*.67);
                motorFR.setPower(-((this.gamepad1.right_stick_y) - (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) - (this.gamepad1.right_stick_x)) * .6);
            }
            else if (driveswitch == 2) {
                motorFL.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + ((this.gamepad1.left_stick_y)) + (this.gamepad1.right_stick_x)) * .3);
                motorBL.setPower(-((this.gamepad1.right_stick_y) - (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) + (this.gamepad1.right_stick_x)) * .3*.67);
                motorBR.setPower(((this.gamepad1.right_stick_y) + (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) - (this.gamepad1.right_stick_x)) * .3*.67);
                motorFR.setPower(-((this.gamepad1.right_stick_y) - (this.gamepad1.left_stick_x) + (this.gamepad1.left_stick_y) - (this.gamepad1.right_stick_x)) * .3);
            }
            if (gamepad1.a)
            {
                driveswitch=2;
            }
            if (gamepad1.x)
            {
                driveswitch=1;
            }
            if (gamepad1.y)
            {
                driveswitch=0;
            }
            if (gamepad2.dpad_up||gamepad1.dpad_up)
            {
                lift.setPower(-1);//may need to speed up or slow down

            }
            else if (gamepad2.dpad_down||gamepad1.dpad_down)
            {
                lift.setPower(1);//may need speed up or slow down
            }
            else
            {
                lift.setPower(0);

            }

            }
            /*if (gamepad2.dpad_left)
            {
                if (clawCounter == 0)
                {
                    clawCounter = 1;
                }
                else if (clawCounter == 1)
                {
                    clawCounter = 0;
                }
            }*/

            if (gamepad2.right_bumper ||gamepad1.right_bumper) {
                claw.setPosition(1);//need to tune this it is a servo from 0-1 0 = 0 degrees 1 = 180
            }
            else {
                claw.setPosition(-1);//need to tune this it is a servo from 0-1 0 = 0 degrees 1 = 180
            }
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



