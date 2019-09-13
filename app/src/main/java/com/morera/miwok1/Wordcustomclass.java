package com.morera.miwok1;

import android.widget.ImageView;

public class Wordcustomclass {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int miCon = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Wordcustomclass(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation= miwokTranslation;
    }

    public Wordcustomclass(String defaultTranslation, String miwokTranslation, int iCon) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation= miwokTranslation;
        miCon = iCon;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getMiCon() {
        return miCon;
    }

    public boolean hasImage () {
        return miCon != NO_IMAGE_PROVIDED;
    }
}
