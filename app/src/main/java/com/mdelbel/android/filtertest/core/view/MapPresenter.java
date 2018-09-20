package com.mdelbel.android.filtertest.core.view;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.core.dto.AvailableFiltersDto;
import com.mdelbel.android.filtertest.core.dto.FilterDto;
import com.mdelbel.android.filtertest.ui.model.Filter;
import com.mdelbel.android.filtertest.ui.model.FilterBar;

import java.util.ArrayList;
import java.util.List;

public class MapPresenter {

    private AvailableFiltersDto filtersDto = createMockAvailableFiltersDto();

    public void attach(@NonNull MapView view) {
        view.showFilterBar(createFilterBar());
    }

    @NonNull
    private FilterBar createFilterBar() {
        return new FilterBar(createQuickFilters());
    }

    @NonNull
    private List<Filter> createQuickFilters() {
        return filtersDto.quickFiltersAsFilterModels();
    }

    private static AvailableFiltersDto createMockAvailableFiltersDto() {
        List<FilterDto> quickFilters = new ArrayList<>();
        quickFilters.add(new FilterDto("Retiras hoy", "same_day"));
        quickFilters.add(new FilterDto("Gratis", "free"));
        quickFilters.add(new FilterDto("Mejor puntuado", "best_score"));

        return new AvailableFiltersDto(quickFilters);
    }
}