package com.mdelbel.android.filtertest.ui.model;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.view.FilterBarViewHolder;

public class Filter {

    private final String name;
    private final String tag;
    private final boolean isActive;

    private Filter(@NonNull String name, @NonNull String tag, boolean isActive) {
        this.name = name;
        this.tag = tag;
        this.isActive = isActive;
    }

    public Filter(@NonNull String name, @NonNull String tag) {
        this(name, tag, false);
    }

    public void bind(@NonNull FilterBarViewHolder holder) {
        holder.name(name).addPayload(this).setActive(isActive);
    }

    @CheckResult
    public boolean isInactive() {
        return !isActive;
    }

    @NonNull
    public Filter updateStatus() {
        return new Filter(name, tag, !isActive);
    }
}