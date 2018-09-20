package com.mdelbel.android.filtertest.core.dto;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.model.Filter;

import java.util.ArrayList;
import java.util.List;

public class AvailableFiltersDto {

    private List<FilterDto> quickFilters;

    public AvailableFiltersDto(@NonNull List<FilterDto> quickFilters) {
        this.quickFilters = quickFilters;
    }

    @NonNull
    public List<Filter> quickFiltersAsFilterModels() {
        List<Filter> filters = new ArrayList<>(quickFilters.size());
        for (FilterDto filterDto : quickFilters) {
            filters.add(filterDto.asFilter());
        }

        return filters;
    }
}
