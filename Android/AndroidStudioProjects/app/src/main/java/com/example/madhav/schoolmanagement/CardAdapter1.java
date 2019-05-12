package com.example.madhav.schoolmanagement;

import android.support.v7.widget.CardView;

public interface CardAdapter1 {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}

