package com.pan.easyadapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pan on 1/23/16.
 */
public class ViewHolderBuilder {

    private static ViewHolderBuilder defaultViewHolderBuilder = new ViewHolderBuilder();

    private Map<Class<? extends ItemBase>, Class<? extends ViewHolderBase>> mapViewHolder =
            new HashMap<>();

    public static ViewHolderBuilder getDefaultViewHolderBuilder() {
        return defaultViewHolderBuilder;
    }

    public void putItemViewHolderRelation(Class<? extends ItemBase> clsitem, Class<? extends ViewHolderBase> clsviewholder) {
        if (mapViewHolder.get(clsitem) != null) {
            throw new IllegalArgumentException(clsitem.getSimpleName() + " has been added!!!");
        } else {
            mapViewHolder.put(clsitem, clsviewholder);
        }
    }

    public ViewHolderBase createViewHolder(Context context, ViewGroup parent, Integer viewType) {
        for (Map.Entry<Class<? extends ItemBase>, Class<? extends ViewHolderBase>> entry
                : mapViewHolder.entrySet()) {
            if (entry.getValue().hashCode() == viewType) {
                try {
                    try {
                        Class[] clsarg = new Class[]{Context.class, View.class};
                        Constructor constructor = entry.getValue().getConstructor(clsarg);
                        try {
                            //Use reflect to call static method getLayout() in class
                            // to get layout and then inflate it.
                            Method getlayout = entry.getValue().getMethod("getLayout");
                            int layout = ((Integer) getlayout.invoke(null));
                            View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

                            return (ViewHolderBase) constructor.newInstance(context, view);
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Use the address of the class as ViewType property
     */
    @Nullable
    public Integer getViewType(ItemBase item) {
        Class<? extends ViewHolderBase> cls = mapViewHolder.get(item.getClass());
        if (cls == null) {
            throw new IllegalArgumentException("Can't find the ViewHolderBase relates to "
                    + item.getClass().getSimpleName());
        }
        return cls.hashCode();
    }
}
