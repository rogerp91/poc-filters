package com.mdelbel.android.filtertest.ui.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mdelbel.android.filtertest.R;
import com.mdelbel.android.filtertest.ui.model.Filter;

public class FilterBarSlotViewHolder extends RecyclerView.ViewHolder {

    private View container;
    private TextView nameView;

    FilterBarSlotViewHolder(@NonNull View itemView) {
        super(itemView);
        container = itemView;
        nameView = itemView.findViewById(R.id.item_filter_bar_name);
    }

    @NonNull
    public FilterBarSlotViewHolder name(@NonNull String name) {
        nameView.setText(name);
        return this;
    }

    @NonNull
    public FilterBarSlotViewHolder addPayload(@NonNull Filter filter) {
        container.setTag(filter);
        return this;
    }

    @NonNull
    public FilterBarSlotViewHolder setActive(boolean isActive) {
        nameView.setEnabled(isActive);
        return this;
    }
}