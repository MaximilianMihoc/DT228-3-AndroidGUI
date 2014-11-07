package ie.dit.maximilian.mihoc;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CheckOut extends ActionBarActivity 
{
	TextView itemName;
	TextView itemPrice;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		itemName = (TextView)findViewById(R.id.outputItemName);
		//itemPrice = (TextView)findViewById(R.id.outputItemPrice);
		
		//Item[] selectedItems = (Item[]) getIntent().getSerializableExtra("selectedItems");
		Bundle bunObject = getIntent().getExtras();
		
		@SuppressWarnings("unchecked")
		ArrayList<Item> items = (ArrayList<Item>)bunObject.getSerializable("selectedItems");
		
		//Item selectedItems = (Item)getIntent().getParcelableArrayExtra("selectedItems");
		//itemName.setText(selectedItems[0].getName());
		//itemPrice.setText("" + selectedItems[0].getPrice());
		
		//itemName.setText(items.get(0).getName());
		
		String results = "Name  Desc  Price\n";
		for(int i = 0; i < items.size(); i ++)
		{
			Item it = items.get(i);
			
			results +="" + it.getName() + "    " + it.getDescription() + "    " + it.getPrice() + "\n";

		}
		itemName.setText(results);
		
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
