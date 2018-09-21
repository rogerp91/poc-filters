package com.mdelbel.android.filtertest.ui.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.mdelbel.android.filtertest.R;
import com.mdelbel.android.filtertest.ui.model.FilterBar;

public class MapView extends ConstraintLayout {

    private FilterBarAdapter filterBarAdapter = new FilterBarAdapter();

    public MapView(final Context context) {
        this(context, null);
    }

    public MapView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MapView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View mapView = inflate(context, R.layout.view_map, this);
        setUpFilterBar(mapView);
    }

    private void setUpFilterBar(@NonNull View mapView) {
        RecyclerView filterBar = mapView.findViewById(R.id.map_view_filter_bar);

        filterBar.setHasFixedSize(true);
        filterBar.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        filterBar.setAdapter(filterBarAdapter);
    }

    public void showFilterBar(@NonNull FilterBar filterBar) {
        filterBarAdapter.submitList(filterBar.asFiltersCollection());
    }
}