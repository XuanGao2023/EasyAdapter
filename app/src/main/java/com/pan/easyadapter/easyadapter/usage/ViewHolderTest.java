package com.pan.easyadapter.easyadapter.usage;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.pan.easyadapter.R;
import com.pan.easyadapter.easyadapter.ItemBase;
import com.pan.easyadapter.easyadapter.ViewHolderBase;


/**
 * Created by Pan on 1/23/16.
 */
public class ViewHolderTest extends ViewHolderBase {

    private TextView textView;
    public ViewHolderTest(Context context, View viewItem) {
        super(context, viewItem);
        textView = (TextView)itemView.findViewById(R.id.textView);
    }

    public static int getLayout() {
        return R.layout.viewholder_test;
    }

    public void bindViewHolder(ItemBase item) {
        if(item instanceof ItemTest) {
            ItemTest itemTest = (ItemTest) item;
            textView.setText(itemTest.text);
        }
    }
}
