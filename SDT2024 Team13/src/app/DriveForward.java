package app;


import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;

public class DriveForward
{
    public static void main(String[] args)
    {
        System.out.println("Drive Forward\nand Stop\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);     // flash green led and gimhani
        Sound.beepSequenceUp();   // make sound when ready.

        Button.waitForAnyPress();

        // create two motor objects to control the motors. jj
       
        UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
        UnregulatedMotor motorC = new UnregulatedMotor(MotorPort.C);

        // set motors to 50% power.
        motorC.setPower(50);
        motorB.setPower(50);

        // wait 2 seconds.
        Delay.msDelay(5000);

        // stop motors with brakes on. 
        motorC.stop();
        motorB.stop();

        // free up motor resources. 
        motorC.close(); 
        motorB.close();
 
        // we are done.
        Sound.beepSequence();
        //merging to Yashodha Branch first
//      don't  done 
    }
}
