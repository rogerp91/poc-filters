package com.mdelbel.android.filtertest.ui.model;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.view.FilterObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilterBar {

    private final List<Filter> activeFilters = new ArrayList<>();
    private FilterObserver observer;

    public void add(@NonNull List<Filter> filters) {
        for (Filter filter : filters) {
            Filter copy = new Filter(filter);
            copy.addObserver(observer);
            activeFilters.add(copy);
        }
    }

    public void remove(@NonNull Filter filter) {
        filter.deleteObserver(observer);
        activeFilters.remove(filter);
    }

    public void addObserver(@NonNull FilterObserver observer) {
        this.observer = observer;
    }

    @NonNull
    public List<Filter> asFiltersCollection() {
        List<Filter> filters = new ArrayList<>(activeFilters);
        Collections.sort(filters, new Comparator<Filter>() {
            @Override
            public int compare(Filter firstFilter, Filter secondFilter) {
                if (firstFilter.isInactive()){
                    if (secondFilter.isInactive()){
                        return 0;
                    }else {
                        return 1;
                    }
                }else{
                    return -1;
                }
            }
        });
        return Collections.unmodifiableList(filters);
    }
}