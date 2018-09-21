package com.mdelbel.android.filtertest.ui.view;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdelbel.android.filtertest.R;
import com.mdelbel.android.filtertest.ui.model.Filter;

public class FilterBarAdapter extends ListAdapter<Filter, FilterBarViewHolder> {

    FilterBarAdapter() {
        super(new FilterDiffCallback());
    }

    @NonNull
    @Override
    public FilterBarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new FilterBarViewHolder(inflater.inflate(R.layout.item_filter_bar, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilterBarViewHolder holder, int position) {
        getItem(position).bind(holder);
        setUpClickListener(holder);
    }

    private void setUpClickListener(@NonNull final FilterBarViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.getPayload() != null) {
                    holder.getPayload().changeStatus();
                    notifyDataSetChanged();
                }
            }
        });
    }

    public static class FilterDiffCallback extends DiffUtil.ItemCallback<Filter> {

        @Override
        public boolean areItemsTheSame(Filter oldItem, Filter newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(Filter oldItem, Filter newItem) {
            return false;
        }
    }
}