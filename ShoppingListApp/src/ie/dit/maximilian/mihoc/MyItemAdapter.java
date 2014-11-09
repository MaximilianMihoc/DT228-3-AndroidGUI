package ie.dit.maximilian.mihoc;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MyItemAdapter extends ArrayAdapter<Item>
{
	List<Item> list;
	Context context;
	CheckBox checkBox;
	int pos;
	
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
		
		TextView itemDesc = (TextView)row.findViewById(R.id.itemDescription);
		itemDesc.setText(list.get(position).getDescription());
		
		pos = position;
		
		checkBox = (CheckBox)row.findViewById(R.id.checkBox1);
		//checkBox.setChecked(list.get(position).isChecked());
		
		//EditText qty = (EditText)row.findViewById(R.id.qty);	
		
		return row;
	}
}
