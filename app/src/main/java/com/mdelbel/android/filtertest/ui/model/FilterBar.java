package com.mdelbel.android.filtertest.ui.model;

import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilterBar {

    private final List<Filter> activeFilters = new ArrayList<>();
    private Observer<Filter> observer;

    public void add(@NonNull List<Filter> filters) {
        for (Filter filter : filters) {
            Filter copy = new Filter(filter);
            copy.observable().observeForever(observer);
            activeFilters.add(copy);
        }
    }

    public void remove(@NonNull Filter filter) {
        filter.observable().removeObserver(observer);
        activeFilters.remove(filter);
    }

    public void addObserver(@NonNull Observer<Filter> observer) {
        this.observer = observer;
    }

    @NonNull
    public List<Filter> asFiltersCollection() {
        List<Filter> filters = new ArrayList<>(activeFilters);
        Collections.sort(filters, new Comparator<Filter>() {
            @Override
            public int compare(Filter firstFilter, Filter secondFilter) {
                return firstFilter.isInactive() ? secondFilter.isInactive() ? 0 : 1 : -1;
            }
        });
        return Collections.unmodifiableList(filters);
    }
}