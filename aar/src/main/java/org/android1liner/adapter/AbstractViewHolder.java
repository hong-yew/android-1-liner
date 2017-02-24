package org.android1liner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by hongyew on 25/02/2017.
 */


public abstract class AbstractViewHolder<M> extends RecyclerView.ViewHolder {
    
    public AbstractViewHolder(Context context, ViewGroup parent, int layoutId) {
        super(LayoutInflater.from(context).inflate(layoutId, parent, false));
    }
    
    public Context getContext() {
        return itemView.getContext();
    }
    
    public abstract void bind(M item);
}

