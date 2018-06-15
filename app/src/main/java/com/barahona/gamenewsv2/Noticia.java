package com.barahona.gamenewsv2;

import java.util.ArrayList;

public class Noticia {
    private String title;
    private ArrayList<Noticia> favorite;
    private String img;

    public Noticia(String img, String title, ArrayList<Noticia> favorite) {
        this.img = img;
        this.title = title;
        this.favorite = favorite;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Noticia> getFavorite() {
        return favorite;
    }
    public void setFavorite(ArrayList<Noticia> favorite) {
        this.favorite = favorite;
    }

}
