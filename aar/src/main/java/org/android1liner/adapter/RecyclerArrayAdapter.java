package org.android1liner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Create simple array adapter quickly.
 *
 * <code>
 *  RecyclerArrayAdapter<String> adapter = new RecyclerArrayAdapter<>(this,
 *   new String[] {
 *       "Person 1",
 *       "Person 2",
 *       "Person 3"
 * });
 * </code>
 *
 * To do a custom view holder and layout, use:
 * <code>
 *  RecyclerArrayAdapter<String> adapter = new RecyclerArrayAdapter<>(this,
 *   layoutId,
 *   MyViewHolder.class,
 *   new String[] {
 *       "Person 1",
 *       "Person 2",
 *       "Person 3"
 * });
 * </code>
 * The MyViewHolder class MUST extends RecyclerArrayAdapter.AbstractViewHolder.
 *
 * In this approach, you only have to extend the ViewHolder, and not having to extend
 * both the ViewHolder and RecyclerAdapter.
 *
 */
public class RecyclerArrayAdapter<T> extends RecyclerView.Adapter<RecyclerArrayAdapter.AbstractViewHolder>{
    private LayoutInflater inflater;
    private Context context;
    private int layoutId = android.R.layout.simple_list_item_1;
    List<T> list;
    private Class viewHolderClass = SimpleViewHolder.class;

    public RecyclerArrayAdapter(Context context, T[] array) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = Arrays.asList(array);
    }

    public RecyclerArrayAdapter(Context context, int layoutId, Class viewHolderClass, T[] array) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.layoutId = layoutId;
        this.viewHolderClass = viewHolderClass;
        this.list =  Arrays.asList(array);
    }

    @Override
    public AbstractViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(layoutId, parent, false);
        try {
            return (AbstractViewHolder) viewHolderClass.getConstructor(View.class).newInstance(view);
        }
        catch (Exception e) {
            Log.e(RecyclerArrayAdapter.class.getSimpleName(), "onCreateViewHolder(): Error creating " + viewHolderClass.getSimpleName());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(AbstractViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public abstract static class AbstractViewHolder<VH> extends RecyclerView.ViewHolder {
        public AbstractViewHolder(View view) {
            super(view);
        }

        public Context getContext() {
            return itemView.getContext();
        }

        public abstract void bind(VH item);
    }

    public static class SimpleViewHolder extends AbstractViewHolder<String>
    {
        TextView text;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(android.R.id.text1);
        }

        @Override
        public void bind(String item) {
            text.setText(item.toString());
        }
    }
}