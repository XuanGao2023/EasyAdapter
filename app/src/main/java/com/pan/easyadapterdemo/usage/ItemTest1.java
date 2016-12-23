package com.pan.easyadapterdemo.usage;


import com.pan.easyadapter.ItemBase;

/**
 * Created by Pan on 1/23/16.
 */
public class ItemTest1 extends ItemBase {
    public String textLeft = "";
    public String textRight = "";

    public ItemTest1(String textleft, String textright) {
        this.textLeft = textleft;
        this.textRight = textright;
    }
}
