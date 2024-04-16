package app;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class ColorSensor implements Runnable {
    private EV3ColorSensor ColorSensor;
    private SampleProvider intensityProvider;
    private final float targetIntensity = 15; // Adjust as needed
    private DataExchange DEObj;

    public ColorSensor(DataExchange DE) {
        this.DEObj = DE;
        this.ColorSensor = new EV3ColorSensor(LocalEV3.get().getPort("S3"));
        this.intensityProvider = ColorSensor.getRedMode();
    }

    @Override
    public void run() {
        float[] sample = new float[intensityProvider.sampleSize()];
        while (true) {
            if (DEObj.getCMD() == 1) {
                // Continue following the line
                intensityProvider.fetchSample(sample, 0);
                float currentIntensity = sample[0] * 100;

                float difference = currentIntensity - targetIntensity;
                
                // Set the intensity difference in the data exchange object
                DEObj.setLineIntensity(difference);
            }
            // Add more conditions as needed based on your application requirements
        }
    }
}
