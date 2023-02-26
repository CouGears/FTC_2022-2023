package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;

//uncomment following line to use
//@TeleOp
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
    private double debounceUp = 0;
    private double debounceDown = 0;
    private final ElapsedTime runtime = new ElapsedTime();
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
                if(runtime.seconds()>debounceUp+2){
                right= right+.01;
                left=left-.01;
                debounceUp = runtime.seconds();}
            } else if (gamepad1.dpad_down) {
                if(runtime.seconds()>debounceDown+2) {
                    left = left + .01;
                    right = right - .01;
                    debounceDown = runtime.seconds();
                }
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




