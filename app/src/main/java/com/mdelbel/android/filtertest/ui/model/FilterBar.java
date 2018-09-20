package com.mdelbel.android.filtertest.ui.model;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.view.FilterBarSlotViewHolder;

import java.util.Collections;
import java.util.List;

public class FilterBar {

    private List<Filter> quickFilters;

    public FilterBar(@NonNull List<Filter> quickFilters) {
        this.quickFilters = Collections.unmodifiableList(quickFilters);
    }

    @NonNull
    public List<Filter> asFiltersCollection() {
        //TODO aca deberia ir el algoritmo para determinar como pintar los activos y los quick filters
        return quickFilters;
    }

    public void bindSlot(@NonNull FilterBarSlotViewHolder holder, int position) {
        //TODO deberia ser sobre la lista a mostrar y checkear el pos sea valido
        quickFilters.get(position).bind(holder);
    }
}