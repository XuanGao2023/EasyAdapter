package com.pan.easyadapter.easyadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.pan.easyadapter.R;

/**
 * Created by Pan on 1/23/16.
 */
public class ViewHolderBase extends RecyclerView.ViewHolder {

    protected Context mContext;
    public ViewHolderBase(Context context, View viewItem) {
        super(viewItem);
        mContext = context;
    }

    /**
     * This method should be overrided by subclass
     */
    public static int getLayout() {
        return R.layout.viewholder_base;
    }

    /**
     * This method should be overrided by subclass to initiate the view
     */
    public void bindViewHolder(ItemBase item) {

    }
}
