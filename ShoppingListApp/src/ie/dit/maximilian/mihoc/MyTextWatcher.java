package ie.dit.maximilian.mihoc;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MyTextWatcher implements TextWatcher
{
	private View view;
	
	public MyTextWatcher(View view) 
	{
		super();
		this.view = view;
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) 
	{
	
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) 
	{
		
	}
	
	@Override
	public void afterTextChanged(Editable s) 
	{
		String qtyStr = s.toString().trim();
		int qty;
		if(qtyStr.equals(""))
			qty = 0;
		else 
			qty = Integer.valueOf(qtyStr);
		
		EditText qtyView = (EditText)view.findViewById(R.id.qty);
		Item item = (Item)qtyView.getTag();
		
		if(item.getQuantity() != qty)
		{
			item.setQuantity(qty);
		}
	}

}
