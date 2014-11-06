package ie.dit.maximilian.mihoc;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

public class SecondScreenActivity extends ListActivity 
{
	List<Item> itemList = new ArrayList<Item>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
		//get name from the other screen
		String fullName = getIntent().getStringExtra("fullName");
		
		//populateItemList();
		Resources res = getResources();
		String[] tempStringArray = res.getStringArray(R.array.itemList);		
		
		for(int i = 0; i < tempStringArray.length; i++)
		{
			Item item = new Item();
			String[] fields = tempStringArray[i].split("[\t ]");
			item = setValuesFromArray(fields);
			itemList.add(item);
		}
		
		
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
	
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
		Toast.makeText(this,  " You selected  " + itemList.get(position).getName() + "\nDesc: " + itemList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
	}
	
	public Item setValuesFromArray(String[] fields)
	{
		//Log.w("ShoppingListApp" , "" + Integer.parseInt(fields[4]));
		int quantity = Integer.parseInt(fields[4]);
		Item tempItem = new Item(fields[1], Float.parseFloat(fields[2]), fields[3], quantity);
		
		
		switch(fields[1])
		{
		case "Bread": tempItem.setImageSrc(R.drawable.bread);
						break;
		case "Corn": tempItem.setImageSrc(R.drawable.corn);
						break;
		case "Pizza": tempItem.setImageSrc(R.drawable.pizza);
						break;
		case "Cheese": tempItem.setImageSrc(R.drawable.cheese);
						break;
		case "Cola": tempItem.setImageSrc(R.drawable.diet_coke);
						break;
		case "Fanta": tempItem.setImageSrc(R.drawable.fanta);
						break;
		case "Sprite": tempItem.setImageSrc(R.drawable.sprite);
						break;
		default: 	tempItem.setImageSrc(R.drawable.ic_launcher);
					break;
		}
		
		return tempItem;
	}

}
