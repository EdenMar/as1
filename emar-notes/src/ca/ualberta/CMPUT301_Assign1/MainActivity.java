package ca.ualberta.CMPUT301_Assign1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity //implements OnClickListener
{

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button newCounter = (Button) findViewById(R.id.newCounter);
		Button loadCounter = (Button) findViewById(R.id.loadCounter);
		Button statistics = (Button) findViewById(R.id.statistics);
		
		newCounter.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
			
				Intent newIntent = new Intent(getApplicationContext(), CounterMenu.class);
				startActivity(newIntent);
				
			}
		});
		
		
		//loadCounter.setOnClickListener(this);
		
		
		//statistics.setOnClickListener(this);
		
		
		
	}

	
			
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}




/*	@Override
	public void onClick(View v)
	{
		switch (v.getId()) {
			
			case R.id.newCounter:
				Intent newIntent = new Intent(this, CounterMenu.class);
				
				startActivity(newIntent);
				break;
			
			case R.id.loadCounter:
				Intent loadIntent = new Intent(this, CounterMenu.class);
				
				startActivity(loadIntent);
				break;
		
			case R.id.statistics:
				Intent statIntent = new Intent(this, Statistics.class);
				startActivity(statIntent);
				break;
		}
		
		
	} */ 




}
