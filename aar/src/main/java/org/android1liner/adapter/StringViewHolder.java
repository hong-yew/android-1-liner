package org.android1liner.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hongyew on 25/02/2017.
 */
public class StringViewHolder extends AbstractViewHolder<String>
{
    TextView text;
    
    public StringViewHolder(Context context, ViewGroup parent) {
        super(context, parent, android.R.layout.simple_list_item_1);
        text = (TextView) itemView.findViewById(android.R.id.text1);
    }
    
    @Override
    public void bind(String item) {
        text.setText(item.toString());
    }
}
