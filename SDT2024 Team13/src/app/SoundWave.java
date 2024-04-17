package app;

import lejos.hardware.Sound;

/**
 * @author Yashodha
 * This class represents the sound waves that will be applicable when the Robot identifies an obstacle in it's path
 * 
 */

public class SoundWave implements Runnable {	
    /**
     *Overriding the run method
     *@param notes array to store the sound waves
     *@param timing array to store duration that sound wave plays.
     *@param i in the for loop to Get the duration at index 'i'
     *@param totalTiming to save the current duration to the total
     */

    @Override
    public void run() {
        int[] notes = {4, 25, 500, 600, 700, 800, 900,1000,50,40,20,4,4, 25, 500, 600, 700, 800, 900,1000,50,40,20,4};
        int[] timing = {50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50};

        int totalTiming = 0;

        for (int i = 0; i < timing.length; i++) {
            int duration = timing[i]; 
            totalTiming = totalTiming + duration;
        }

        long startTime = System.currentTimeMillis();
        long currentTime = startTime;

        while(currentTime - startTime < totalTiming) {
            for(int i = 0; i < notes.length; i++) {
                Sound.playTone(notes[i], timing[i]);              
                try {
                    Thread.sleep(timing[i]);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } 
                
                currentTime = System.currentTimeMillis();     
            }
        }
    }
}
