package com.mdelbel.android.filtertest.ui.model;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.view.FilterBarViewHolder;

import java.util.Observable;

public class Filter extends Observable {

    private final String name;
    private final String tag;
    private boolean isActive;

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

    @CheckResult
    public boolean isActive() {
        return isActive;
    }

    @CheckResult
    public boolean isInactive() {
        return !isActive;
    }

    public void changeStatus() {
        isActive = !isActive;
        setChanged();
        notifyObservers();
    }
}