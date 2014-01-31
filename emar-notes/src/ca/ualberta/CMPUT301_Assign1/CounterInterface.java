package ca.ualberta.CMPUT301_Assign1;

import java.util.Date;

//interface used to control Counter class in CounterMenu

public interface CounterInterface {

	
	public void addValue();
	
	//increment the value variable, and call the setTimestamp() method

	public int getValue();
	
	public void setTimestamp();
	
	//reassigns the timestamp variable to the current time
	
	public Date getTimestamp();
	
	//returns the Date as assigned by setTimestamp
}
