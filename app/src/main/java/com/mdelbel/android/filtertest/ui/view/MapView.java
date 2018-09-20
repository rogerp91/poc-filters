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

    private FilterBarAdapter filterBarAdapter;

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

    protected void setUpFilterBar(@NonNull View mapView) {
        RecyclerView filterBar = mapView.findViewById(R.id.map_view_filter_bar);
        filterBar.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager
                = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        filterBar.setLayoutManager(layoutManager);

        filterBarAdapter = new FilterBarAdapter();
        filterBar.setAdapter(filterBarAdapter);
    }

    public void showFilterBar(@NonNull FilterBar bar) {
        filterBarAdapter.update(bar);
    }
}