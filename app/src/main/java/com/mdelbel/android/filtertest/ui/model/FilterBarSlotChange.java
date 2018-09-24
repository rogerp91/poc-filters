package com.mdelbel.android.filtertest.ui.model;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

public class FilterBarSlotChange {

    private Filter oldValue;
    private Filter newValue;

    FilterBarSlotChange(@NonNull Filter oldValue, @NonNull Filter newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @CheckResult
    public boolean hasChangeStatusToInactive() {
        return newValue.isInactive();
    }

    @NonNull
    public Filter oldValue() {
        return oldValue;
    }

    @NonNull
    public Filter newValue() {
        return newValue;
    }
}