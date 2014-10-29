package ie.dit.maximilian.mihoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	TextView title;
	Spinner jobTitle;
	EditText ageValue;
	EditText totalValue;
	Button next;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		title = (TextView)findViewById(R.id.maintitle);
		title.setGravity(Gravity.CENTER);
		
		jobTitle = (Spinner)findViewById(R.id.jobTytle);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.job_titles, android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		jobTitle.setAdapter(adapter);
		
		ageValue = (EditText)findViewById(R.id.ageValue);
		ageValue.setGravity(Gravity.RIGHT);
		totalValue = (EditText)findViewById(R.id.totalValue);
		totalValue.setGravity(Gravity.RIGHT);
		
		next = (Button) findViewById(R.id.nextButton);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SecondScreenActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
