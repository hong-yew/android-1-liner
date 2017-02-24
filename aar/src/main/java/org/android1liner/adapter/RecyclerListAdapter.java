package org.android1liner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
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
 * To do a custom view holder, use:
 * <code>
 *  RecyclerListAdapter<String> adapter = new RecyclerListAdapter<>(this,
 *   MyViewHolder.class,
 *   new String[] {
 *       "Person 1",
 *       "Person 2",
 *       "Person 3"
 * });
 * </code>
 * The ViewHolder class MUST extends AbstractViewHolder. Unless you override onCreateViewHolder(),
 * the ViewHolder MUST also have a Constructor signature ViewHolder(Context, ViewGroup). The
 * ViewHolder is responsible for inflating its layout.
 *
 * In this approach, you only have to extend the ViewHolder, and not having to extend
 * both the ViewHolder and the RecyclerAdapter.
 *
 */
public class RecyclerListAdapter<T extends AbstractViewHolder> extends RecyclerView.Adapter<AbstractViewHolder>{
    private static final String TAG = RecyclerListAdapter.class.getSimpleName();
    private LayoutInflater inflater;
    private Context context;
    
    // Default to a simple 1 item string
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

    public RecyclerListAdapter(Context context, Class viewHolderClass, T[] array) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.viewHolderClass = viewHolderClass;
        this.list =  Arrays.asList(array);
    }

    public RecyclerListAdapter(Context context, Class viewHolderClass, List list) {
        inflater = LayoutInflater.from(context);
        this.context = context;
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
        try {
            return (AbstractViewHolder) viewHolderClass.getConstructor(Context.class, ViewGroup.class).newInstance(context, parent);
        }
        catch (NoSuchMethodException e) {
            Log.e(TAG, "onCreateViewHolder(): ViewHolder must have a constructure signature " + viewHolderClass.getSimpleName() + "(Context, ViewGroup)", e);
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            Log.e(TAG, "onCreateViewHolder(): Error creating ViewHolder", e);
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