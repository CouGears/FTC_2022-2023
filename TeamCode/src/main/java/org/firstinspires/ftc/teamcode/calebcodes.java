package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class calebcodes extends OpMode {
    double rev = 537.7; //312 rpm motor
    double inch = rev / (3.78 * 3.14);
    double feet = inch * 12 + (10 * inch);
    AutonMethods robot = new AutonMethods();
    HardwareMap map;
    Telemetry tele;
    public void init() {
        robot.init(map, tele, false);
        telemetry.addData("Status", "Initialized");
    }
    public void loop(){
        switch(robot.counter){
            case 0:
                telemetry.addData("Case", "0");
                telemetry.update();
                robot.drive(4 * feet, 0, 1);
                robot.counter++;
            case 1:
                telemetry.addData("Case", "1");
                telemetry.update();
                robot.turn(90);
                robot.counter++;
            case 2:
                telemetry.addData("Case", "2");
                telemetry.update();
                robot.drive(2 * feet, 0, 1);
                robot.counter++;
            case 3:
                telemetry.addData("Case", "3");
                telemetry.update();
                robot.turn(-90);
                robot.counter++;
            case 4:
                telemetry.addData("Case", "4");
                telemetry.update();
                robot.drive(2 * feet, 0, 1);
                robot.counter++;
            case 5:
                telemetry.addData("Case", "5");
                telemetry.update();
                robot.drive(0, 2 * feet, 1);
                robot.counter++;
            case 6:
                telemetry.addData("Case", "6");
                telemetry.update();
                robot.drive(-6 * feet, 0, 1);
                robot.counter++;
            case 7:
                telemetry.addData("Case", "7");
                telemetry.update();
                robot.drive(0, -4 * feet, 1);
                robot.counter++;
        }
    }
}
