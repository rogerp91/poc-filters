package com.mdelbel.android.filtertest.ui.model;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.view.FilterBarSlotViewHolder;

public class Filter {

    private String name;
    private String tag;
    private boolean isActive;

    public Filter(@NonNull String name, @NonNull String tag) {
        this.name = name;
        this.tag = tag;
        this.isActive = false;
    }

    public void bind(@NonNull FilterBarSlotViewHolder holder) {
        holder.name(name).addPayload(this).setActive(isActive);
    }

    @CheckResult
    public boolean areItemsTheSame(@NonNull Filter other) {
        return this.equals(other);
    }

    @CheckResult
    public boolean areContentsTheSame(Filter other) {
        return tag.equals(other.tag);
    }
}