package com.example.giaodiengmail;

import java.util.List;

public class ItemModel {
    private String tile1;
    private String tile2;
    private List<Name> names;
    private int image;

    public ItemModel(String tile1, List<Name> names) {
        this.tile1 = tile1;
        this.names = names;
    }

    public ItemModel(String tile1, String tile2) {
        this.tile1 = tile1;
        this.tile2 = tile2;
    }

    public ItemModel(String tile1, String tile2, int image) {
        this.tile1 = tile1;
        this.tile2 = tile2;
        this.image = image;
    }

    public String getTile1() {
        return tile1;
    }

    public void setTile1(String tile1) {
        this.tile1 = tile1;
    }

    public String getTile2() {
        return tile2;
    }

    public void setTile2(String tile2) {
        this.tile2 = tile2;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
