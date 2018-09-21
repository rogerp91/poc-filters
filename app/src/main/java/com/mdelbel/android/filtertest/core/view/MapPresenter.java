package com.mdelbel.android.filtertest.core.view;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.core.dto.AvailableFiltersDto;
import com.mdelbel.android.filtertest.core.dto.FilterDto;
import com.mdelbel.android.filtertest.core.handler.FilterBarHandler;
import com.mdelbel.android.filtertest.ui.model.FilterBar;

import java.util.ArrayList;
import java.util.List;

public class MapPresenter {

    private final FilterBar filterBar = new FilterBar();

    private MapView view;

    MapPresenter() {
        FilterBarHandler filterBarHandler = new FilterBarHandler(this, filterBar);

        AvailableFiltersDto filtersDto = createMockAvailableFiltersDto();
        filterBarHandler.addQuickFilters(filtersDto.quickFiltersAsFilterModels());
    }

    public void attach(@NonNull MapView view) {
        this.view = view;
        refreshFilterBar();
    }

    public void refreshFilterBar() {
        view.refreshFilterBar(filterBar);
    }

    private static AvailableFiltersDto createMockAvailableFiltersDto() {
        List<FilterDto> quickFilters = new ArrayList<>();
        quickFilters.add(new FilterDto("Retiras hoy", "same_day"));
        quickFilters.add(new FilterDto("Gratis", "free"));
        quickFilters.add(new FilterDto("Mejor puntuado", "best_score"));

        return new AvailableFiltersDto(quickFilters);
    }
}