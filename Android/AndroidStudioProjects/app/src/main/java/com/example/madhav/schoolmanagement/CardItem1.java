package com.example.madhav.schoolmanagement;

public class CardItem1 {

    private int mTextResource;
    private int mTitleResource;

    public CardItem1(int title, int text) {
        mTitleResource = title;
        mTextResource = text;
    }

    public int getText() {
        return mTextResource;
    }

    public int getTitle() {
        return mTitleResource;
    }
}