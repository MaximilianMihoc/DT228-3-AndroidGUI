package ie.dit.maximilian.mihoc;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MyItemAdapter extends ArrayAdapter<Item>
{
	List<Item> list;
	Context context;
	public MyItemAdapter(Context context, int resource, List<Item> items) 
	{
		super(context, resource, items);
		this.context = context;
		this.list = items;
	}
	
	@SuppressLint("NewApi")
	@Override
    public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		if(row == null)
		{
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
			row = inflater.inflate(R.layout.row, parent, false);
		}
		
		TextView itemName = (TextView)row.findViewById(R.id.itemName);
		itemName.setText(list.get(position).getName());
		
		TextView itemPrice = (TextView)row.findViewById(R.id.itemPrice);
		itemPrice.setText("€" + list.get(position).getPrice());
		
		ImageView icon = (ImageView)row.findViewById(R.id.icon);
		icon.setImageResource(list.get(position).getImageSrc());
		
		//EditText qty = (EditText)row.findViewById(R.id.qty);	
		
		return row;
	}
}
