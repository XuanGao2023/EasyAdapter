package com.pan.easyadapter.easyadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Pan on 1/23/16.
 */
public class AdapterBase extends RecyclerView.Adapter<ViewHolderBase> {

    private Context mContext;
    private ArrayList<ItemBase> listItemBase = new ArrayList<>();
    private ViewHolderBuilder viewHolderBuilder;

    public AdapterBase(Context context, ArrayList<ItemBase> list) {
        this(context, list, ViewHolderBuilder.getDefaultViewHolderBuilder());
    }
    public AdapterBase(Context context, ArrayList<ItemBase> list, ViewHolderBuilder builder) {
        mContext = context;
        listItemBase = list;
        viewHolderBuilder = builder;
    }

    @Override
    public int getItemCount() {
        return listItemBase.size();
    }

    /**
     * Get viewtype of the viewholderbase
     */
    @Override
    public int getItemViewType(int position) {
        return viewHolderBuilder.getViewType(listItemBase.get(position));
    }

    @Override
    public ViewHolderBase onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolderBuilder.createViewHolder(mContext, parent, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolderBase holder, int position) {
        if(holder != null) { holder.bindViewHolder(listItemBase.get(position)); }
    }
}
