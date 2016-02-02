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
public class ViewHolderTest1 extends ViewHolderBase {

    private TextView textViewLeft;
    private TextView textViewRight;
    public ViewHolderTest1(Context context, View viewItem) {
        super(context, viewItem);
        textViewLeft = (TextView)viewItem.findViewById(R.id.textViewLeft);
        textViewRight = (TextView)viewItem.findViewById(R.id.textViewRight);
    }

    public static int getLayout() {
        return R.layout.viewholder_test1;
    }

    public void bindViewHolder(ItemBase item) {
        if(item instanceof ItemTest1) {
            ItemTest1 itemTest = (ItemTest1) item;
            textViewLeft.setText(itemTest.textLeft);
            textViewRight.setText(itemTest.textRight);
        }
    }
}
