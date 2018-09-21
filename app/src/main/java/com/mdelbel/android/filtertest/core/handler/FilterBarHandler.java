package com.mdelbel.android.filtertest.core.handler;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.core.view.MapPresenter;
import com.mdelbel.android.filtertest.ui.model.Filter;
import com.mdelbel.android.filtertest.ui.model.FilterBar;
import com.mdelbel.android.filtertest.ui.view.FilterObserver;

import java.util.List;

public class FilterBarHandler {

    private final FilterBar filterBar;

    public FilterBarHandler(@NonNull final MapPresenter mapPresenter, @NonNull final FilterBar filterBar) {
        this.filterBar = filterBar;
        this.filterBar.addObserver(new FilterObserver() {

            @Override
            protected void update(@NonNull Filter filter) {
                if (filter.isInactive()) {
                    filterBar.remove(filter);
                }
                mapPresenter.refreshFilterBar();
            }
        });
    }

    public void addQuickFilters(@NonNull List<Filter> filters) {
        filterBar.add(filters);
    }
}
