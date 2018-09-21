package com.mdelbel.android.filtertest.ui.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mdelbel.android.filtertest.R;
import com.mdelbel.android.filtertest.ui.model.Filter;

public class FilterBarViewHolder extends RecyclerView.ViewHolder {

    private TextView nameView;

    FilterBarViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.item_filter_bar_name);
    }

    @Nullable
    public Filter getPayload() {
        return (Filter) itemView.getTag();
    }

    @NonNull
    public FilterBarViewHolder name(@NonNull String name) {
        nameView.setText(name);
        return this;
    }

    @NonNull
    public FilterBarViewHolder addPayload(@NonNull Filter filter) {
        itemView.setTag(filter);
        return this;
    }

    @NonNull
    public FilterBarViewHolder setActive(boolean isActive) {
        nameView.setEnabled(isActive);
        return this;
    }
}