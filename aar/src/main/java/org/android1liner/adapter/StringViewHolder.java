package org.android1liner.adapter;

import android.view.View;
import android.widget.TextView;

/**
 * Created by hongyew on 25/02/2017.
 */
public class StringViewHolder extends AbstractViewHolder<String>
{
    TextView text;
    
    public StringViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(android.R.id.text1);
    }
    
    @Override
    public void bind(String item) {
        text.setText(item.toString());
    }
}
