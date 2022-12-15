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
package org.firstinspires.ftc.teamcode.YearArchive;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.AutonMethods;


@Autonomous

public class Calebs_Super_Cool_Auton extends OpMode {

    //TensorFlowVision vision = new TensorFlowVision();
//   double rev = 383.6; //435 rpm motor
    double rev = 537.7; //312 rpm motor
    double inch = rev / (3.78 * 3.14);
    double feet = inch * 12 + (10 * inch);
    short sleevenum = 1;

    private ElapsedTime runtime = new ElapsedTime();
    AutonMethods robot = new AutonMethods();
    HardwareMap map;
    Telemetry tele;

    @Override
    public void init() {

        robot.init(hardwareMap, telemetry, false);

        telemetry.addData("Status", "Initialized");

    }


    public void init_loop() {
    robot.clawsetpos(0);
    }

    public void start() {
        runtime.reset();
    }


    public void loop() {
        switch (robot.counter) {
            case 0:
                //Move towards high pole
                robot.clawsetpos(0);
                robot.drive2023(4*feet, 0*feet, .25);
                robot.counter++;
                break;
            case 1:
                //turn towards high pole
                robot.turn2023gears(45);
                robot.counter++;
                break;
            case 2:
                //raise arm(Encoder)
                robot.drive2023gears(0 * feet, -1 * feet, .5);// test for value so close to pylons
                robot.counter++;
                break;
            case 3:
                //move robot a little forward
                robot.drive2023gears(5 * feet, 0 * feet, .5);
                robot.counter++;
                break;
            case 4:
                //lower arm a little tiny bit
                robot.drive2023gears(5 * feet, 0 * feet, .5);
                robot.counter++;
                break;
            case 5:
                //open claw
                robot.turn(45);
                robot.counter++;
                break;
            case 6:
                //turn to cones
                robot.counter++;
                break;
            case 7:
                //go to cones
                robot.counter++;
                break;
            case 8:
                //pick up cones
                robot.counter++;
                break;
            case 9:
                //return to high pole
                robot.counter++;
                break;
            case 10:
                //return to high pole
                robot.counter++;
                break;
            case 11:
                //raise arm(Encoder)
                robot.drive2023gears(0 * feet, -1 * feet, .5);// test for value so close to pylons
                robot.counter++;
                break;
            case 12:
                //move robot a little forward
                robot.drive2023gears(5 * feet, 0 * feet, .5);
                robot.counter++;
                break;
            case 13:
                //lower arm a little tiny bit
                robot.drive2023gears(5 * feet, 0 * feet, .5);
                robot.counter++;
                break;
            case 14:
                //open claw
                robot.turn(45);
                robot.counter++;
                break;
            case 15:
                switch (sleevenum) {
                    case 1:
                        robot.turn(-45);
                        robot.drive2023gears(0 * feet, -.3 * feet, .5);
                        break;
                    case 2:
                        robot.turn(-45);
                        robot.drive2023gears(0 * feet, -.3 * feet, .5);
                        robot.drive2023gears(1 * feet, 0 * feet, .5);
                        robot.drive2023gears(0 * feet, 1.3 * feet, .5);
                        break;
                    case 3:
                        robot.turn(-45);
                        robot.drive2023gears(0 * feet, -.3 * feet, .5);
                        robot.drive2023gears(1 * feet, 0 * feet, .5);
                        robot.drive2023gears(0 * feet, 1.3 * feet, .5);
                        robot.drive2023gears(0 * feet, 3.3 * feet, .5);

                }
                robot.counter++;
                break;

        }
    }
}


