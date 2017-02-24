package org.android1liner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

/**
 * Create simple List adapter quickly.
 *
 * <code>
 *  RecyclerListAdapter<String> adapter = new RecyclerListAdapter<>(this,
 *   new String[] {
 *       "Person 1",
 *       "Person 2",
 *       "Person 3"
 * });
 * </code>
 *
 * To do a custom view holder and layout, use:
 * <code>
 *  RecyclerListAdapter<String> adapter = new RecyclerListAdapter<>(this,
 *   layoutId,
 *   MyViewHolder.class,
 *   new String[] {
 *       "Person 1",
 *       "Person 2",
 *       "Person 3"
 * });
 * </code>
 * The MyViewHolder class MUST extends AbstractViewHolder.
 *
 * In this approach, you only have to extend the ViewHolder, and not having to extend
 * both the ViewHolder and RecyclerAdapter.
 *
 */
public class RecyclerListAdapter<T extends AbstractViewHolder> extends RecyclerView.Adapter<AbstractViewHolder>{
    private LayoutInflater inflater;
    private Context context;
    
    // Default to a simple 1 item string
    private int layoutId = android.R.layout.simple_list_item_1;
    private Class viewHolderClass = StringViewHolder.class;
    
    private List<T> list;
    
    /**
     * Create a list adapter using a defualt StringViewHolder and android.R.layout.simple_list_item_1
     * for a single string item list.
     * @param context
     * @param array
     */
    public RecyclerListAdapter(Context context, T[] array) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = Arrays.asList(array);
    }
    
    /**
     * Create a list adapter using a defualt StringViewHolder and android.R.layout.simple_list_item_1
     * for a single string item list.
     * @param context
     * @param list
     */
    public RecyclerListAdapter(Context context, List list) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    public RecyclerListAdapter(Context context, int layoutId, Class viewHolderClass, T[] array) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.layoutId = layoutId;
        this.viewHolderClass = viewHolderClass;
        this.list =  Arrays.asList(array);
    }

    public RecyclerListAdapter(Context context, int layoutId, Class viewHolderClass, List list) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.layoutId = layoutId;
        this.viewHolderClass = viewHolderClass;
        this.list =  list;
    }
    
    public List<T> getList() {
        return list;
    }
    
    public void setList(List<T> list) {
        this.list = list;
    }
    
    @Override
    public AbstractViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(layoutId, parent, false);
        try {
            return (AbstractViewHolder) viewHolderClass.getConstructor(View.class).newInstance(view);
        }
        catch (Exception e) {
            Log.e(RecyclerListAdapter.class.getSimpleName(), "onCreateViewHolder(): Error creating " + viewHolderClass.getSimpleName());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(AbstractViewHolder holder, int position) {
        if (list != null) {
            holder.bind(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return list.size();
    }
}