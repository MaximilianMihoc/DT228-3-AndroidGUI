package ie.dit.maximilian.mihoc;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MyItemAdapter extends ArrayAdapter<ItemInterface>
{
	List<ItemInterface> list;
	Context context;
	int pos;
	Item item;
	SectionItem sectionItem;
	LayoutInflater inflater;
	
	public MyItemAdapter(Context context, List<ItemInterface> items) 
	{
		super(context, 0, items);
		this.context = context;
		this.list = items;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@SuppressLint("NewApi")
	@Override
    public View getView(int position, View convertView, ViewGroup parent)
	{	
		View row = convertView;
		ItemInterface it = list.get(position);
		if(it != null)
		{
			if(!it.isSection())
			{
				item = (Item) it;
				
				row = inflater.inflate(R.layout.row, parent, false);
				
				
				TextView itemName = (TextView)row.findViewById(R.id.itemName);
				itemName.setText(item.getName());
				
				TextView itemPrice = (TextView)row.findViewById(R.id.itemPrice);
				itemPrice.setText("€" + item.getPrice());
				
				ImageView icon = (ImageView)row.findViewById(R.id.icon);
				icon.setImageResource(item.getImageSrc());
				//icon.setImageDrawable(item.getImage());
				
				TextView itemDesc = (TextView)row.findViewById(R.id.itemDescription);
				itemDesc.setText(item.getDescription());
				
				TextView viewQty = (TextView)row.findViewById(R.id.viewQty);
				viewQty.setText("Qty: " + item.getQuantity());
				
				EditText qty = (EditText)row.findViewById(R.id.qty);
				qty.addTextChangedListener(new MyTextWatcher(row));
				qty.setTag(item);
				//item.setQuantity(item.getQuantity());
				
				
				
				row.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) 
					{
						if (!(item.isColor())) 
						{
							item.setColor(true);
					        v.setBackgroundColor(Color.DKGRAY);
					    } 
						else 
					    {
							item.setColor(false);
					        v.setBackgroundColor(Color.TRANSPARENT);
					    }
					}
				});
				
			}
			else
			{
				sectionItem = (SectionItem) it;
				row = inflater.inflate(R.layout.header, parent, false);
				TextView section = (TextView)row.findViewById(R.id.list_header_title);
				section.setText(sectionItem.getSectionName());
			}
		}
		return row;
	}
}
