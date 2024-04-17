
package app;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

/**
 * <b>Date: </b> 01/04/2024
 * 
 * @author 
 * <ul>
 * <li>Akila</li>
 * <li>Yashodha</li>
 * <li>Gimhani</li>
 * <li>Jayaneththi</li>
 * </ul>
 * 
 * @version 1.0
 * <br>
 * <br>

 * <b>Functionality: </b> <br>
 * RunaClass may include the main method of the project. It may run all the threads. 
 * To start the prgramme, user has to press the "Enter" button and to end, press "Escape" button.
 */
public class RunClass {
    private static DataExchange DE;
    private static LineFollower LFObj;
    private static ObstacleDetector ODObj;
    private static SoundWave soundwave;

    /**
     * 
     * This executes the main method
     */

    public static void main(String[] args) {
        DE = new DataExchange();
        soundwave = new SoundWave();
        ODObj = new ObstacleDetector(DE, soundwave);

        LFObj = new LineFollower(DE);

        Thread lineFollowerThread = new Thread(LFObj);
        Thread obstacleDetectorThread = new Thread(ODObj);

        // Wait for the Enter key press to start
       
        while (!Button.ENTER.isDown()) {
           // Sound.beep();
           // Delay.msDelay(500);
        	 LCD.drawString("Press Enter to start", 0, 1);
            
        }
        LCD.clear();

        // Start the threads
        lineFollowerThread.start();
        obstacleDetectorThread.start();

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Wait for Escape key press to exit
        LCD.drawString("Press Escape to exit", 0, 1);
        while (!Button.ESCAPE.isDown()) {}

        // Stop the motors
        Motor.C.stop(true);
        Motor.B.stop(true);
        
        // Calculate final elapsed time
        long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - startTime) / 1000;

        // Display final elapsed time
        LCD.clear();
        LCD.drawString("Final Elapsed Time:", 0, 1);
        LCD.drawString(elapsedTime + "s", 0, 2);
        
        Delay.msDelay(5000);

        // Clear the LCD and exit
        LCD.clear();
        LCD.drawString("Program finished", 0, 1);
        Delay.msDelay(500);
        System.exit(0);
    }
}
