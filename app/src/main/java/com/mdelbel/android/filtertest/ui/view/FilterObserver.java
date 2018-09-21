package com.mdelbel.android.filtertest.ui.view;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.model.Filter;

import java.util.Observable;
import java.util.Observer;

public abstract class FilterObserver implements Observer {

    @Override
    public void update(Observable obs, Object arg) {
        Filter filter = (Filter) obs;
        update(filter);
    }

    protected abstract void update(@NonNull Filter filter);
}