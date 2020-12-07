package com.example.mydrakor;

public class Drakor {
    private String mId, mJudul,mGenre,mEpisode;

    public Drakor(String mId, String mJudul, String mGenre, String mEpisode) {
        this.mId = mId;
        this.mJudul = mJudul;
        this.mGenre = mGenre;
        this.mEpisode = mEpisode;
    }
    public Drakor(){

    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmJudul() {
        return mJudul;
    }

    public void setmGenre(String mJudul) {
        this.mJudul = mJudul;
    }

    public String getmEpisode() {
        return mGenre;
    }

    public void setmJudul(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getmGenre() {
        return mEpisode;
    }

    public void setmEpisode(String mEpisode) {
        this.mEpisode = mEpisode;
    }
}
