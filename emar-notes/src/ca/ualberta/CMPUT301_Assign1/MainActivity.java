package ca.ualberta.CMPUT301_Assign1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener 
{

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button newCounter = (Button) findViewById(R.id.newCounter);
		newCounter.setOnClickListener(this);
		
		Button loadCounter = (Button) findViewById(R.id.loadCounter);
		loadCounter.setOnClickListener(this);
		
		Button statistics = (Button) findViewById(R.id.statistics);
		statistics.setOnClickListener(this);
		
		
		
		
		
		
	}

	
			
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}




	@Override
	public void onClick(View v)
	{
		switch (v.getId()) {
			
			case R.id.newCounter:
				Intent intent = new Intent(this, Counter.class);
				
				startActivity(intent);
				break;
			
			case R.id.loadCounter:
				Intent intent2 = new Intent(this, Counter.class);
				
				startActivity(intent2);
				break;
		
			case R.id.statistics:
				Intent intent3 = new Intent(this, Statistics.class);
				startActivity(intent3);
				break;
		}
		
		
	}




}
