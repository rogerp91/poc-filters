package com.mdelbel.android.filtertest.core.view;

import android.support.annotation.NonNull;

import com.mdelbel.android.filtertest.ui.model.FilterBar;

public interface MapView {

    void refreshFilterBar(@NonNull FilterBar bar);
}
