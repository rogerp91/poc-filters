package com.mdelbel.android.filtertest.ui.view;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mdelbel.android.filtertest.R;
import com.mdelbel.android.filtertest.ui.model.Filter;
import com.mdelbel.android.filtertest.ui.model.FilterBar;

public class FilterBarAdapter extends ListAdapter<Filter, FilterBarSlotViewHolder> {

    private FilterBar filterBarModel;

    FilterBarAdapter() {
        super(new FilterDiffCallback());
    }

    public void update(@NonNull FilterBar bar) {
        filterBarModel = bar;
        submitList(filterBarModel.asFiltersCollection());
    }

    @NonNull
    @Override
    public FilterBarSlotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new FilterBarSlotViewHolder(inflater.inflate(R.layout.item_filter_bar, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilterBarSlotViewHolder holder, int position) {
        filterBarModel.bindSlot(holder, position);
    }

    public static class FilterDiffCallback extends DiffUtil.ItemCallback<Filter> {

        @Override
        public boolean areItemsTheSame(Filter oldItem, Filter newItem) {
            return oldItem.areItemsTheSame(newItem);
        }

        @Override
        public boolean areContentsTheSame(Filter oldItem, Filter newItem) {
            return oldItem.areContentsTheSame(newItem);
        }
    }
}