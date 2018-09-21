package com.mdelbel.android.filtertest.core.view;

import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mdelbel.android.filtertest.core.dto.AvailableFiltersDto;
import com.mdelbel.android.filtertest.core.dto.FilterDto;
import com.mdelbel.android.filtertest.ui.model.Filter;
import com.mdelbel.android.filtertest.ui.model.FilterBar;

import java.util.ArrayList;
import java.util.List;

public class MapPresenter {

    private final FilterBar filterBar;

    private MapView view;

    MapPresenter() {
        AvailableFiltersDto filtersDto = createMockAvailableFiltersDto();

        filterBar = new FilterBar();
        filterBar.addObserver(new Observer<Filter>() {
            @Override
            public void onChanged(@Nullable Filter filter) {
                if (filter.isInactive()) {
                    filterBar.remove(filter);
                }
                refreshFilterBar();
            }
        });
        filterBar.add(filtersDto.quickFiltersAsFilterModels());
    }

    public void attach(@NonNull MapView view) {
        this.view = view;
        refreshFilterBar();
    }

    private void refreshFilterBar() {
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