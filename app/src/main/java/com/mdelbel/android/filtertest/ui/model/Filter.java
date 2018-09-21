package com.mdelbel.android.filtertest.ui.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.view.FilterBarViewHolder;

public class Filter {

    private final String name;
    private final String tag;
    private boolean isActive;

    private MutableLiveData<Filter> observable = new MutableLiveData<>();

    public Filter(@NonNull String name, @NonNull String tag) {
        this.name = name;
        this.tag = tag;
        this.isActive = false;
    }

    Filter(@NonNull Filter filter) {
        this(filter.name, filter.tag);
    }

    public void bind(@NonNull FilterBarViewHolder holder) {
        holder.name(name).addPayload(this).setActive(isActive);
    }

    @NonNull
    public LiveData<Filter> observable() {
        return observable;
    }

    @CheckResult
    public boolean isInactive() {
        return !isActive;
    }

    public void toggleStatus() {
        isActive = !isActive;
        observable.setValue(this);
    }
}