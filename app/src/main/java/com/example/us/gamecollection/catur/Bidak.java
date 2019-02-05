package com.example.us.gamecollection.catur;

import java.util.ArrayList;

public class Bidak {

    private boolean putih;
    int i, j;


    public Bidak(boolean putih) {
        this.putih = putih;
    }

    public ArrayList<Koordinat> gerakBidak(Koordinat koordinat, Posisi[][] papan) {

        ArrayList<Koordinat> gerakkBidak = new ArrayList<>();
        Koordinat c;

        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                c = new Koordinat(i, j);
                gerakkBidak.add(c);
            }
        }
        return gerakkBidak;
    }

    public boolean isPutih() {
        return putih;
    }
}
