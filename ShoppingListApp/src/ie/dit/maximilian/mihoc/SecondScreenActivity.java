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
import android.widget.ListView;
import android.widget.Toast;

public class SecondScreenActivity extends ListActivity 
{
	List<Item> itemList = new ArrayList<Item>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		
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
		Item tempItem = new Item(fields[1], Float.parseFloat(fields[2]), fields[3]);
		
		//Log.w("ShoppingListApp" ,s);
		switch(fields[1])
		{
		case "Bread": tempItem.setImageSrc(R.drawable.bread);
						break;
		/*case "Italy": icon.setImageResource(R.drawable.italy);
						break;
		case "Spain": icon.setImageResource(R.drawable.spain);
						break;
		case "Poland": icon.setImageResource(R.drawable.poland);
						break;
		case "Romania": icon.setImageResource(R.drawable.romania);
						break;
		case "Germany": icon.setImageResource(R.drawable.germany);
						break;
		case "England": icon.setImageResource(R.drawable.uk);
						break;*/
		default: 	tempItem.setImageSrc(R.drawable.ic_launcher);
					break;
		}
		
		
		return tempItem;
	}
	
	/*public void populateItemList()
	{
		Item i1 = new Item("Bread", 12, "white", R.drawable.bread);
		Item i2 = new Item("Corn", 1.5f, "100% natural", R.drawable.corn);
		Item i3 = new Item("Pizza", 12, "Margherita", R.drawable.pizza);
		Item i4 = new Item("Cheese", 12, "mexican", R.drawable.cheese);
		Item i5 = new Item("Cola", 1, "diet", R.drawable.diet_coke);
		Item i6 = new Item("Fanta", 12, "orange", R.drawable.fanta);
		Item i7 = new Item("Sprite", 12, "light", R.drawable.sprite);
		
		/*Item i8 = new Item("pizza", 12, "Margherita", "");
		Item i9 = new Item("pizza", 12, "Margherita", "");
		Item i10 = new Item("pizza", 12, "Margherita", "");
		Item i11 = new Item("pizza", 12, "Margherita", "");
		Item i12 = new Item("pizza", 12, "Margherita", "");
		Item i13 = new Item("pizza", 12, "Margherita", "");
		*/
		/*
		itemList.add(i1);
		itemList.add(i2);
		itemList.add(i3);
		itemList.add(i4);
		itemList.add(i5);
		itemList.add(i6);
		itemList.add(i7);
		/*itemList.add(i8);
		itemList.add(i9);
		itemList.add(i10);
		itemList.add(i11);
		itemList.add(i12);
		itemList.add(i13);
		*/
		/*
		itemList.add(i1);
		itemList.add(i2);
		itemList.add(i3);
		itemList.add(i4);
		itemList.add(i5);
		itemList.add(i6);
		itemList.add(i7);
	}*/
}
