package com.morera.miwok1;

import android.widget.ImageView;

public class Wordcustomclass {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int miCon = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudio;

    public Wordcustomclass(String defaultTranslation, String miwokTranslation, int audio) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation= miwokTranslation;
        mAudio = audio;
    }

    public Wordcustomclass(String defaultTranslation, String miwokTranslation, int iCon, int audio) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation= miwokTranslation;
        miCon = iCon;
        mAudio = audio;
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

    public int getAudio() {
        return mAudio;
    }


    public boolean hasImage () {
        return miCon != NO_IMAGE_PROVIDED;
    }
}
