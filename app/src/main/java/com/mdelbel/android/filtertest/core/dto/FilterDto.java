package com.mdelbel.android.filtertest.core.dto;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.model.Filter;

public class FilterDto {

    private final String name;
    private final String tag;

    public FilterDto(@NonNull String name, @NonNull String tag) {
        this.name = name;
        this.tag = tag;
    }

    @NonNull
    public Filter asFilter() {
        return new Filter(name, tag);
    }
}