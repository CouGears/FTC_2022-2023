/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
//test
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.autoncamera.TagRead;


//@Autonomous

public class AutonRight extends OpMode {

    //TensorFlowVision vision = new TensorFlowVision();
//   double rev = 383.6; //435 rpm motor
    double rev = 537.7; //312 rpm motor
    double inch = rev / (3.78 * 3.14);
    double feet = inch * 12; //+ (10 * inch);
    private int position = 0;

    private ElapsedTime runtime = new ElapsedTime();
    AutonMethods robot = new AutonMethods();
    TagRead tag = new TagRead();
    HardwareMap map;
    Telemetry tele;

    @Override
    public void init() {
        robot.init(hardwareMap, telemetry, false);
        telemetry.addData("Status", "Initialized");
    }


    public void init_loop() {
        robot.setIntakePOS(0);
    }

    public void start() {
        runtime.reset();
    }


    public void loop() {
        switch (robot.counter) {
            case 0:
                if (tag.pos() == 1) {
                    position = 1;
                    telemetry.addData("Park Location", "Left");
                    telemetry.update();
                } else if (tag.pos() == 2) {
                    position = 2;
                    telemetry.addData("Park Location", "Middle");
                    telemetry.update();
                } else if (tag.pos() == 3) {
                    position = 3;
                    telemetry.addData("Park Location", "Right");
                    telemetry.update();
                }
                robot.counter++;
                break;
            case 1:
                robot.drive(.1*feet,0,0.5);
                robot.counter++;
                break;
            case 2:
                robot.drive(0, -1.25 * feet, .5);
                robot.counter++;
                break;
            case 3:
                robot.drive(1.9 * feet, 0, .5);
                //robot.sleep(100);
                robot.counter++;
                break;
            case 4:
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    tele.addLine("Failed Sleep");
                    tele.update();
                }
                robot.turn(-45);
                robot.counter++;
                break;
            case 5:
                //lift
                //robot.lift(7475);
                robot.counter++;
                break;
            case 6:
                //dump
                //robot.dump();
                robot.counter++;
                break;
            case 7:
               // robot.turn(45);
                robot.counter++;
                break;
            case 8:
               // robot.lift(0);
                robot.counter++;
                break;
            case 9:
                //robot.drive(0,-.25*feet,1);
                robot.counter++;
                break;
            case 10:
               /* if (position == 1) {
                    robot.drive(0, 6 * feet, .5);
                } else if (position == 2) {
                    robot.drive(0, 4 * feet, .5);
                } else robot.drive(0, 2*feet, 0);
                */robot.counter++;
                break;
        }
    }
}


