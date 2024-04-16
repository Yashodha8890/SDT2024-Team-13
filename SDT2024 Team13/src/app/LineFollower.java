package app;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class LineFollower implements Runnable {
    private DataExchange DEObj;
    private ColorSensor colorSensor;

    public LineFollower(DataExchange DE) {
        this.DEObj = DE;
        this.colorSensor = new ColorSensor(DE); // Pass DataExchange object to ColorSensor constructor
    }

    @Override
    public void run() {
        // Start the color sensor thread
        Thread colorSensorThread = new Thread(colorSensor);
        colorSensorThread.start();

        while (true) {
            if (DEObj.getCMD() == 1) {
                // Get the line intensity from the DataExchange object
                float difference = DEObj.getLineIntensity();

                // Continue following the line based on line intensity
                // Adjust motor speeds and movement based on the line intensity difference
                // Example code for motor movement based on intensity difference:
                if (difference > 10) {
                    Motor.C.setSpeed(50);
                    Motor.B.setSpeed(200);
                } else {
                    Motor.C.setSpeed(200);
                    Motor.B.setSpeed(50);
                }

                Motor.C.forward();
                Motor.B.forward();
            } else if (DEObj.getCMD() == 2) {
                // Turn left
                Motor.C.setSpeed(200);  // Adjust speed as needed
                Motor.B.setSpeed(200);  // Adjust speed as needed
                Motor.B.backward();     // Left motor moves backward
                Motor.C.forward();      // Right motor moves forward

                // Delay for a specific duration to achieve a 90-degree turn
                // Adjust this delay based on experimentation and calibration
                Delay.msDelay(500);    // Example: Delay for 1 second

                // Stop turning left
                Motor.C.stop(true);
                Motor.B.stop(true);

                // Move forward
                Motor.C.setSpeed(200);  // Adjust speed as needed
                Motor.B.setSpeed(200);  // Adjust speed as needed
                Motor.C.forward();      // Left motor moves forward
                Motor.B.forward();      // Right motor moves forward
                
                // Move forward for 5 seconds
                Delay.msDelay(2000);    // Adjust delay for 2 seconds

                // Stop moving forward
                Motor.C.stop(true);
                Motor.B.stop(true);

                // Turn right 90 degrees
                Motor.C.setSpeed(200);  // Adjust speed as needed
                Motor.B.setSpeed(200);  // Adjust speed as needed
                Motor.C.backward();     // Right motor moves forward
                Motor.B.forward();      // Left motor moves backward
             
                // Delay for a specific duration to achieve a 90-degree turn
                // Adjust this delay based on experimentation and calibration
                Delay.msDelay(500);    // Example: Delay for 1 second

                // Stop turning left
                Motor.C.stop(true);
                Motor.B.stop(true);
                
             // Move forward
                Motor.C.setSpeed(200);  // Adjust speed as needed
                Motor.B.setSpeed(200);  // Adjust speed as needed
                Motor.C.forward();      // Left motor moves forward
                Motor.B.forward();      // Right motor moves forward
                
                // Move forward for 5 seconds
                Delay.msDelay(3000);    // Adjust delay for 3 seconds
                
             // Stop turning left
                Motor.C.stop(true);
                Motor.B.stop(true);
                
                // Turn right 90 degrees
                Motor.C.setSpeed(200);  // Adjust speed as needed
                Motor.B.setSpeed(200);  // Adjust speed as needed
                Motor.C.backward();     // Right motor moves forward
                Motor.B.forward();      // Left motor moves backward
             
                // Delay for a specific duration to achieve a 90-degree turn
                // Adjust this delay based on experimentation and calibration
                Delay.msDelay(500);    // Example: Delay for 1 second

                // Stop turning left
                Motor.C.stop(true);
                Motor.B.stop(true);
                
             // Move forward
                Motor.C.setSpeed(200);  // Adjust speed as needed
                Motor.B.setSpeed(200);  // Adjust speed as needed
                Motor.C.forward();      // Left motor moves forward
                Motor.B.forward();      // Right motor moves forward
                
             // Move forward for 5 seconds
                Delay.msDelay(1500);    // Adjust delay for 3 seconds
                
            } else if (DEObj.getCMD() == 0) {
                // Stop the motors
                Motor.C.stop(true);
                Motor.B.stop(true);
            
            } else {
                // Stop the motors
                Motor.C.stop(true);
                Motor.B.stop(true);
                
                // Rotate the robot to scan for the line
                Motor.C.setSpeed(200);  // Adjust speed as needed
                Motor.B.setSpeed(200);  // Adjust speed as needed
                Motor.B.forward();      // Left motor moves forward
                Motor.C.backward();     // Right motor moves backward
                
                // Delay for a specific duration to rotate the robot
                // Adjust this delay based on experimentation and calibration
                Delay.msDelay(500);    // Example: Delay for 1 second

                // Stop rotating
                Motor.C.stop(true);
                Motor.B.stop(true);
                
                // Resume following the line
                Motor.B.setSpeed(200);  // Adjust speed as needed
                Motor.C.setSpeed(100);   // Adjust speed as needed
                Motor.B.forward();      // Left motor moves forward
                Motor.C.forward();      // Right motor moves forward
            }
        }
    }
}

