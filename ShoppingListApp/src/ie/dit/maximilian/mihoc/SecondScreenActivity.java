package ie.dit.maximilian.mihoc;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SecondScreenActivity extends ListActivity 
{
	String[] list = {"bread", "pinaple"};
	List<Item> itemList = new ArrayList<Item>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		Item i1 = new Item("bread", 12, "white");
		Item i2 = new Item("mamaliga", 1.5f, "porumb");
		Item i3 = new Item("bread", 12, "white");
		
		itemList.add(i1);
		itemList.add(i2);
		itemList.add(i3);
		
		setListAdapter(new MyItemAdapter(this, R.layout.row, itemList));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
