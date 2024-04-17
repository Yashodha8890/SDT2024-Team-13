package app;

/**
 * <b>Date :</b> 31.03.2024 <br>
 * 
 * @author 
 * <ul>
 * <li>Akila</li>
 * </ul>
 * 
 * @version 1.0
 * <br>
 * <br>
 * <b>Functionality: </b> <br>
 * The DataExchange.java class facilitates communication between different components of the robot's 
 * software system by providing methods for exchanging data such as commands and sensor readings. 
 * It acts as a central hub for coordinating information flow between modules like the line follower, 
 * obstacle detector, and main control logic.
 */

public class DataExchange {
    // Obstacle detection flag
    private boolean obstacleDetected = false;

    // Robot commands: Follow Line, Stop, Turn Left
    private int CMD = 1;
    private volatile float lineIntensity;

    public DataExchange() 
    {
    	
    }

    /*
     * Getters & Setters
     */

    public void setObstacleDetected(boolean status) 
    {
        obstacleDetected = status;
        if (status) {
            // Obstacle detected, set command to turn left and move
            CMD = 2;
        } 
        else 
        {
            // No obstacle detected, set command to follow the line
            CMD = 1;
        }
    }

    public boolean getObstacleDetected() 
    {
        return obstacleDetected;
    }

    public void setCMD(int command) 
    {
        CMD = command;
    }

    public int getCMD() 
    {
        return CMD;
    }
    public float getLineIntensity() 
    {
        return lineIntensity;
    }

    public void setLineIntensity(float intensity) 
    {
        lineIntensity = intensity;
    }
    
    //Adding comments to check codeowners option

}
