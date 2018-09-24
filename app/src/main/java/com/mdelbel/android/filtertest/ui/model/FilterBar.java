package com.mdelbel.android.filtertest.ui.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

public class FilterBar extends Observable {

    private final List<Filter> filters;

    public FilterBar(@NonNull List<Filter> availableFilters) {
        filters = Collections.unmodifiableList(availableFilters);
    }

    public void notifySlotChanges(@NonNull Filter filterChanged) {
        FilterBarSlotChange slotChange = new FilterBarSlotChange(filterChanged, filterChanged.updateStatus());

        setChanged();
        notifyObservers(slotChange);
    }

    @NonNull
    public List<Filter> asFiltersCollection() {
        List<Filter> sortedFilters = new ArrayList<>(filters);
        Collections.sort(sortedFilters, new Comparator<Filter>() {
            @Override
            public int compare(Filter firstFilter, Filter secondFilter) {
                return firstFilter.isInactive() ? secondFilter.isInactive() ? 0 : 1 : -1;
            }
        });
        return Collections.unmodifiableList(sortedFilters);
    }
}