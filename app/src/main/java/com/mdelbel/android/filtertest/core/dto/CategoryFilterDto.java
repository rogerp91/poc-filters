package com.mdelbel.android.filtertest.core.dto;

import android.support.annotation.NonNull;

import java.util.List;

public class CategoryFilterDto {

    private String title;
    private List<FilterDto> filters;

    public CategoryFilterDto(@NonNull String title, @NonNull List<FilterDto> filters) {
        this.title = title;
        this.filters = filters;
    }
}
