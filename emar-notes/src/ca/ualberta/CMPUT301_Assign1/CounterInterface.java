package ca.ualberta.CMPUT301_Assign1;

import java.util.Date;


public interface CounterInterface {

	
	public void addValue();

	public int getValue();
	
	public void addTimestamp();
	
	public Date getTimestamp();
}
