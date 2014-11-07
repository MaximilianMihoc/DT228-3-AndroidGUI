package ie.dit.maximilian.mihoc;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SecondScreenActivity extends ListActivity 
{
	List<Item> itemList = new ArrayList<Item>();
	Button next;
	ListView listView;
	MyItemAdapter adapter;
	
	//ListView list2 ;
	//String [] s = {"mama", "tata"};
	
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
		
		listView = (ListView)findViewById(android.R.id.list);
		
		for(int i = 0; i < tempStringArray.length; i++)
		{
			Item item = new Item();
			String[] fields = tempStringArray[i].split("[\t ]");
			item = setValuesFromArray(fields);
			itemList.add(item);
		}
		
		//Log.w("importantList", itemList.get(0).getName());
		
		adapter = new MyItemAdapter(this, R.layout.row, itemList);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		listView.setAdapter(adapter);
		//listView.setItemsCanFocus(false);
		
		//works for another list, can categorize
		//list2 = (ListView)findViewById(R.id.list2);
		//list2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, s));
		
		next = (Button)findViewById(R.id.next);
		next.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{	
				//reference
				SparseBooleanArray checked = listView.getCheckedItemPositions();
				Log.w("message", checked.toString());
				ArrayList<Item> selectedItems = new ArrayList<Item>();
				
				for(int i = 0; i < checked.size(); i++)
				{
					int pos = checked.keyAt(i);
					if(checked.valueAt(i))
					{
						selectedItems.add(adapter.getItem(pos));
					}
				}
				//up to here
				
				Intent intent = new Intent(SecondScreenActivity.this, CheckOut.class);
				
				Bundle bundle = new Bundle();
				bundle.putSerializable("selectedItems", selectedItems);
				
				intent.putExtras(bundle);
				
				startActivity(intent);
			}
		});
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
		//Toast.makeText(this,  " You selected  " + itemList.get(position).getName() + "\nDesc: " + itemList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
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
