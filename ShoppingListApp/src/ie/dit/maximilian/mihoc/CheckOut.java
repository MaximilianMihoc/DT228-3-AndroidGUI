package ie.dit.maximilian.mihoc;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CheckOut extends ActionBarActivity 
{
	String custName;
	String totalStr;
	float total;
	String email;
	
	
	@SuppressLint("CutPasteId")
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		
		Bundle bunObject = getIntent().getExtras();
		custName = bunObject.getString("custName");
		
		this.getActionBar().setTitle("Receipt for " + custName + ", Thank you");
		
		@SuppressWarnings("unchecked")
		ArrayList<Item> items = (ArrayList<Item>)bunObject.getSerializable("selectedItems");
		totalStr = bunObject.getString("total");
		total = Float.parseFloat(totalStr);
		email = bunObject.getString("email");
		
		//reference from http://stackoverflow.com/questions/6216547/android-dynamically-add-views-into-view
		LayoutInflater ly = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewGroup parent = (ViewGroup)findViewById(R.id.receiptView);
		View view = ly.inflate(R.layout.receiptrow, parent);
		//end reference
		
		TextView nameInReceipt = (TextView)view.findViewById(R.id.textLeft);
		TextView descInReceipt = (TextView)view.findViewById(R.id.textCenter);
		TextView priceInReceipt = (TextView)view.findViewById(R.id.textRight);
		
		String names = "";
		String descriptions = "";
		String prices = "";
		for(int i = 0; i < items.size(); i ++)
		{
			Item it = items.get(i);
			
			names += it.getName() + "\n";
			descriptions += it.getDescription() + "\n";
			prices += it.getPrice() + "\n";
			
			

		}
		
		names += "\n\nSubtotal";
		prices += "\n\n" + total;
		names += "\nTaxes\\VAT";
		prices += "\n" + (total * 0.21);
		names += "\nTotal";
		prices += "\n" + (total + (total * 0.21));
		descriptions += "\n\n\n\n";
		
		nameInReceipt.setText(names);
		descInReceipt.setText(descriptions);
		priceInReceipt.setText(prices);
		
		
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
