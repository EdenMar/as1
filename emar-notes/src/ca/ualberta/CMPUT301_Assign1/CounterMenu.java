package ca.ualberta.CMPUT301_Assign1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class CounterMenu extends MainActivity implements CounterInterface
{
	private static final String FILENAME = "file.sav";
	private TextView titleText;
	private ListView oldStats;
	private ArrayAdapter<String> adapter;
	private int value;
	private Date timestamp;
	private ArrayList<String> stats;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.counter);
			
			titleText = (TextView) findViewById(R.id.titleText);
			Button plusOne = (Button) findViewById(R.id.plus);
			oldStats = (ListView) findViewById(R.id.oldStats);
			stats = loadFile();
			adapter = new ArrayAdapter<String>(this, R.layout.list, stats);
			oldStats.setAdapter(adapter);
			
			plusOne.setOnClickListener(new View.OnClickListener()
			{
				
				@Override
				public void onClick(View v) {
				setResult(RESULT_OK);
				
				saveFile()
				stats.add(text);
				adapter.notifyDataSetChanged();
			
					
				}
			})
	}



	@Override
	public void addValue()
	{

		value++;
		
	}



	@Override
	public int getValue()
	{

		return value;
	}



	@Override
	public void addTimestamp()
	{

		
		
	}



	@Override
	public Date getTimestamp()
	{
		return timestamp = new Date (System.currentTimeMillis());
	
	}

	private ArrayList<String> loadFile() {
		ArrayList<String> stats = new ArrayList<String>();
		try { 
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            while (line != null) {
                    stats.add(line);
                    line = in.readLine();
            	}

		} catch (FileNotFoundException e) {
            e.printStackTrace();
		} catch (IOException e) {
            e.printStackTrace();
		}
		return stats;
}
		
	 private void saveFile(String text, Date date) {
         try {
                 FileOutputStream fos = openFileOutput(FILENAME,
                                 Context.MODE_APPEND);
                 fos.write(new String(date.toString() + " | " + text)
                                 .getBytes());
                 fos.close();
         } catch (FileNotFoundException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         }
 }	
	
	
	
}
