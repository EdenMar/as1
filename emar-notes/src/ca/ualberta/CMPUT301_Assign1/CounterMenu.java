//By and large, this activity was modeled after the lonelyTwitter app we were shown in lab

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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class CounterMenu extends MainActivity
{
	private static final String FILENAME = "file.sav";
	private TextView titleText;
	private ListView oldStats;
	private ArrayAdapter<String> adapter;
	
	private ArrayList<String> stats;
	private Counter countObj = new Counter();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
			super.onCreate(savedInstanceState);
			setContentView(R.layout.counter);
			
			
			
			titleText = (TextView) findViewById(R.id.titleText);
			Button plusOne = (Button) findViewById(R.id.plus);
			oldStats = (ListView) findViewById(R.id.oldStats);
			
			stats = loadFile();
			adapter = new ArrayAdapter<String>(this, R.layout.stats, stats);
			oldStats.setAdapter(adapter);
			
			plusOne.setOnClickListener(new View.OnClickListener()
			{
				
				@Override
				public void onClick(View v) {
				setResult(RESULT_OK);
				countObj.addValue();
				String countValue = String.valueOf(countObj.getValue());
				Date countDate = countObj.getTimestamp();
				saveFile(countValue, countDate);
				stats.add(countValue);
				adapter.notifyDataSetChanged();
			
					
				}
			});
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
	 
	 //methods used to implement the CounterInterface
	
	 public class Counter implements CounterInterface {
		
		public int value;
		 public Date timestamp;
		 
		 public Counter() {
			 this.value = 0;
			 setTimestamp();			 
		 }
		 
		 public Counter(int value, Date timestamp) {
			 this.value = value;
			 this.timestamp = timestamp;
		 }
		 
		 public void addValue() {
			 ++this.value;
			 setTimestamp();
		 }
		 
		 public int getValue() {
			 return this.value;
		 }
		 
		 public void setTimestamp() {
			 this.timestamp = new Date (System.currentTimeMillis());
		 }
		 
		 public Date getTimestamp() {
			 return this.timestamp;
		 }
	 }
	
}
