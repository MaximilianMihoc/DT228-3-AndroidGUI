package ie.dit.maximilian.mihoc;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CheckOut extends ActionBarActivity 
{
	TextView itemDetailes;
	//TextView itemPrice;
	String custName;
	String totalStr;
	float total;
	String email;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		itemDetailes = (TextView)findViewById(R.id.outputItemName);
		Bundle bunObject = getIntent().getExtras();
		custName = bunObject.getString("custName");
		
		this.getActionBar().setTitle("Receipt for " + custName + ", Thank you");
		
		@SuppressWarnings("unchecked")
		ArrayList<Item> items = (ArrayList<Item>)bunObject.getSerializable("selectedItems");
		totalStr = bunObject.getString("total");
		total = Float.parseFloat(totalStr);
		email = bunObject.getString("email");
		
		
		
		String results = "Name  Desc  Price\n";
		for(int i = 0; i < items.size(); i ++)
		{
			Item it = items.get(i);
			
			results +="" + it.getName() + "    " + it.getDescription() + "    " + it.getPrice() + "\n";

		}
		results += "\nTotal    " + total + "\nVAT 21%      " + total * 0.21 + "\nTotal + VAT:    " + (total + (total * 0.21));
		
		itemDetailes.setText(results);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_out, menu);
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
