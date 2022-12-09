package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class AutonMethods {

    //Constructor
    public AutonMethods() {

    }

    //Declare and initial variables
    double rev = 537.7;
    double inch = rev / (3.5 * 3.14);
    double feet = inch * 12;
    double rev2 = 2048;
    double inch2 = rev2 / (2 * 3.14);
    double feet2 = inch2 * 12;
    double FRtpos, BRtpos, FLtpos, BLtpos;
    public static DcMotor motorBR, motorBL, motorFL, motorFR;
    //public static DcMotor Forwards = intake, Sideways = carousel;
    //public static Servo servo;
    public static DistanceSensor distanceSensor, distanceSensorBack;
   // public static LED red, green, red2, green2;
    public TouchSensor armTouch;
    private final ElapsedTime runtime = new ElapsedTime();
    HardwareMap map;
    Telemetry tele;
    public int counter = 0;

    public static BNO055IMU imu;
    BNO055IMU.Parameters parameters;
    Orientation angles;

    //Initialization
    public void init(HardwareMap map, Telemetry tele, boolean auton) {
        // location[0] = 0;
        //location[1] = 0;


        motorFL = map.get(DcMotor.class, "motorFL");
        motorBL = map.get(DcMotor.class, "motorBL");
        motorBR = map.get(DcMotor.class, "motorBR");
        motorFR = map.get(DcMotor.class, "motorFR");
       // release = map.get(DcMotor.class, "release");

       /* red = map.get(LED.class, "red");
        green = map.get(LED.class, "green");
        red2 = map.get(LED.class, "red2");
        green2 = map.get(LED.class, "green2");*/

        //servo = map.get(Servo.class, "servo");


        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      //  release.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorFL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorFR.setDirection(DcMotorSimple.Direction.FORWARD);
        motorBR.setDirection(DcMotorSimple.Direction.FORWARD);
       // release.setDirection(DcMotorSimple.Direction.FORWARD);


        motorFL.setTargetPosition(0);
        motorBL.setTargetPosition(0);
        motorFR.setTargetPosition(0);
        motorBR.setTargetPosition(0);

        int relativeLayoutId = map.appContext.getResources().getIdentifier("RelativeLayout", "id", map.appContext.getPackageName());

        // tele.addData(">", "Gyro Calibrating. Do Not Move!");
        // tele.update();
    }

    public void kill() {
        motorFL.setPower(0);
        motorBL.setPower(0);
        motorBR.setPower(0);
        motorFR.setPower(0);
    }

    public long maps(long x, long in_min, long in_max, long out_min, long out_max)
    {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    /*
    public void setRed2()
    {
        green2.enable(false);
        red2.enable(true);
    }
    public void setGreen2()
    {
        red2.enable(false);
        green2.enable(true);
    }
    public void setAmber2()
    {
        red2.enable(true);
        green2.enable(true);
    }
    public void setRed()
    {
        green.enable(false);
        red.enable(true);
    }
        public void setGreen()
        {
            red.enable(false);
            green.enable(true);
        }
        public void setAmber()
        {
            red.enable(true);
            green.enable(true);
        }
*/
    //Function to move the robot in any direction
    public void drive(double forward, double sideways, double speed) {
        runtime.reset();
        while (motorFR.isBusy() || motorFL.isBusy()) {
            if (runtime.seconds() > 2) break;
        }
        motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FRtpos = forward - sideways;
        BRtpos = forward + sideways;
        FLtpos = forward - sideways;
        BLtpos = forward + sideways;

        motorFL.setTargetPosition(-(int) FLtpos);
        motorBL.setTargetPosition((int) BLtpos);
        motorFR.setTargetPosition(-(int) FRtpos);
        motorBR.setTargetPosition((int) BRtpos);

        motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        speed(speed);
    }

    public void drive2023(double forward, double sideways, double speed) {
        runtime.reset();
        while (motorFR.isBusy() || motorFL.isBusy()) {
            if (runtime.seconds() > 2) break;
        }
        forward = (forward/2)-(6.5*inch);
        sideways = (sideways/2)-(6.5*inch);
        motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FRtpos = forward - sideways;
        BRtpos = forward + sideways;
        FLtpos = forward - sideways;
        BLtpos = forward + sideways;

        motorFL.setTargetPosition((-(int) FLtpos)*2);
        motorBL.setTargetPosition(((int) BLtpos));
        motorFR.setTargetPosition((((int) FRtpos))*2);
        motorBR.setTargetPosition(-(int) BRtpos);

        motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        speed2023(speed);
    }
    //circumscribed robot has a diameter of 21 inches
    public void turn(double deg) {
        while (motorFR.isBusy() || motorFL.isBusy()) {
            if (runtime.seconds() > 2) break;
        }
        motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //for every drive function remember to reset encoder
        motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        double deltaturn = (deg / 360.0) * 21.654 * 3.14 * inch * 2.2;

        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFL.setPower(0.5);
        motorBL.setPower(0.5);
        motorFR.setPower(0.5);
        motorBR.setPower(0.5);

    }
    public void turn2023gears(double deg) {
        while (motorFR.isBusy() || motorFL.isBusy()) {
            if (runtime.seconds() > 2) break;
        }
        motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); //for every drive function remember to reset encoder
        motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        double deltaturn = (deg / 360.0) * 21.654 * 3.14 * inch * 2.2;
        motorFL.setTargetPosition(-(int) deltaturn);
        motorBL.setTargetPosition((int) (deltaturn/2));
        motorFR.setTargetPosition((int) deltaturn);
        motorBR.setTargetPosition(-(int) (deltaturn/2));
        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFL.setPower(0.5);
        motorBL.setPower(0.5);
        motorFR.setPower(0.5);
        motorBR.setPower(0.5);

    }
    public void speed2023(double spee) {
        motorFL.setPower(spee*2);
        motorBL.setPower(spee);
        motorFR.setPower(spee*2);
        motorBR.setPower(spee);
    }
    public void speed(double spee) {
        motorFL.setPower(spee);
        motorBL.setPower(spee);
        motorFR.setPower(spee);
        motorBR.setPower(spee);
    }
/*public void setRelease(int x)
{
    motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    release.setTargetPosition(x);
    motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
}*/
    public void newSleep(double timeinSeconds) {
        runtime.reset();
        while (runtime.seconds() < timeinSeconds);

    }

    //Function to have the robot sleep
    public void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            tele.addLine("Failed Sleep");
            tele.update();
        }
    }

    public void driveWithDecel(double forward, double sideways) {
        double distd = 8 * feet;
        runtime.reset();
        while (motorFR.isBusy() || motorFL.isBusy()) {
            if (runtime.seconds() > 3) break;
        }
        motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FRtpos = forward - sideways;
        BRtpos = forward + sideways;
        FLtpos = forward + sideways;
        BLtpos = forward - sideways;

        motorFL.setTargetPosition((int) FLtpos);
        motorBL.setTargetPosition((int) BLtpos);
        motorFR.setTargetPosition(-(int) FRtpos);
        motorBR.setTargetPosition(-(int) BRtpos);

        motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        speed(1);
        runtime.reset();
        while ((motorFR.isBusy() || motorFL.isBusy()) && runtime.seconds() < 3) {
            motorFL.setPower((((int) FLtpos - motorFL.getCurrentPosition()) / distd) + .2);
            motorBL.setPower((((int) BLtpos - motorBL.getCurrentPosition()) / distd) + .2);
            motorFR.setPower(-(((int) FRtpos + motorFR.getCurrentPosition()) / distd) + .2);
            motorBR.setPower(-(((int) BRtpos + motorBR.getCurrentPosition()) / distd) + .2);
        }
    }

}