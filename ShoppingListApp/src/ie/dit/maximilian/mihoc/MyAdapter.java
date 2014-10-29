package ie.dit.maximilian.mihoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String>
{
	String[] list;
	Context context;
	public MyAdapter(Context context, int resource, String[] objects) 
	{
		super(context, resource, objects);
		this.context = context;
		this.list = objects;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		if(row == null)
		{
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //getLayoutInflater();
			row = inflater.inflate(R.layout.row, parent, false);
		}
		
		TextView itemName = (TextView)row.findViewById(R.id.itemName);
		itemName.setText(list[position]);
		
		ImageView icon = (ImageView)row.findViewById(R.id.icon);
		icon.setImageResource(R.drawable.ic_launcher);
		
		return row;
	}
}
