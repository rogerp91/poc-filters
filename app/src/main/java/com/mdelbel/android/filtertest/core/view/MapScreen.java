package com.mdelbel.android.filtertest.core.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.mdelbel.android.filtertest.R;
import com.mdelbel.android.filtertest.ui.model.FilterBar;

public class MapScreen extends AppCompatActivity implements MapView {

    private MapPresenter presenter;
    private com.mdelbel.android.filtertest.ui.view.MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_map);
        map = findViewById(R.id.screen_map_map_view);

        presenter = new MapPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach(this);
    }

    @Override
    public void refreshFilterBar(@NonNull FilterBar bar) {
        map.showFilterBar(bar);
    }
}