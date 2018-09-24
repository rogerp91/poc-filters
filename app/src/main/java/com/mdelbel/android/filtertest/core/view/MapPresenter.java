package com.mdelbel.android.filtertest.core.view;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.core.dto.AvailableFiltersDto;
import com.mdelbel.android.filtertest.core.dto.FilterDto;
import com.mdelbel.android.filtertest.ui.model.Filter;
import com.mdelbel.android.filtertest.ui.model.FilterBar;
import com.mdelbel.android.filtertest.ui.model.FilterBarSlotChange;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MapPresenter {

    private FilterBar filterBar;
    private List<Filter> showingFilters = new ArrayList<>();
    private MapView view;

    private Observer filterBarObserver = new Observer() {
        @Override
        public void update(Observable bar, Object slotChange) {
            FilterBarSlotChange filterBarSlotChange = (FilterBarSlotChange) slotChange;
            if (filterBarSlotChange.hasChangeStatusToInactive()) {
                showingFilters.remove(filterBarSlotChange.oldValue());
            } else if (showingFilters.contains(filterBarSlotChange.oldValue())) {
                showingFilters.set(showingFilters.indexOf(filterBarSlotChange.oldValue()), filterBarSlotChange.newValue());
            }

            filterBar.deleteObserver(filterBarObserver);
            filterBar = new FilterBar(showingFilters);
            refreshFilterBar();
        }
    };

    MapPresenter() {
        AvailableFiltersDto filtersDto = createMockAvailableFiltersDto();
        showingFilters.addAll(filtersDto.quickFiltersAsFilterModels());

        filterBar = new FilterBar(showingFilters);
    }

    public void attach(@NonNull MapView mapView) {
        this.view = mapView;
        refreshFilterBar();
    }

    public void deAttach() {
        filterBar.deleteObserver(filterBarObserver);
    }

    private void refreshFilterBar() {
        filterBar.addObserver(filterBarObserver);
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