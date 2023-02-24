package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.*;

import org.firstinspires.ftc.teamcode.AutonMethods;
import org.firstinspires.ftc.teamcode.SensorSet.LEDMethods;
//uncomment following line to use
@TeleOp
public class ServoTest extends LinearOpMode {

    private Servo armL, armR;
    private AutonMethods robot = new AutonMethods();
    public int driveswitch = 1;

    private int topLiftEncoder = 7475;
    private double botR = 0.73;
    private double topR = 1;
    private double botL = 0.27;
    private double topL = 0;
    private double right = botR;
    private double left = botL;

    @Override
    public void runOpMode() {
        //region hardware map

        armL = hardwareMap.get(Servo.class, "armL");
        armR = hardwareMap.get(Servo.class, "armR");


        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                right= right+.01;
                left=left-.01;
            } else if (gamepad1.dpad_down) {
                left=left+.01;
                right=right-.01;
            }//}
            armL.setPosition(left);
            armR.setPosition(right);
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
    }
}




