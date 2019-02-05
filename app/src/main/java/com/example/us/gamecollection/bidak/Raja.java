package com.example.us.gamecollection.bidak;

import android.widget.ImageButton;

import com.example.us.gamecollection.catur.Bidak;
import com.example.us.gamecollection.catur.Koordinat;
import com.example.us.gamecollection.catur.Posisi;

import java.util.ArrayList;

public class Raja extends Bidak{

    public Raja(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Koordinat> gerakBidak(Koordinat koordinat, Posisi[][] papan) {
        ArrayList<Koordinat> jalan = new ArrayList<>();
        Koordinat c;
        jalan.clear();

//        Jalan Raja Hitam
        if ((koordinat.getX()+1)<8 && (koordinat.getY()+1)<8){
            if (papan[koordinat.getX()+1][koordinat.getY()+1].getBidak() == null){
                c = new Koordinat(koordinat.getX()+1, koordinat.getY()+1);
                jalan.add(c);
            } else {
                if (papan[koordinat.getX()+1][koordinat.getY()+1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()+1, koordinat.getY()+1);
                    jalan.add(c);
                }
            }
        }

        if ((koordinat.getX()+1)<8){
            if (papan[koordinat.getX()+1][koordinat.getY()].getBidak() == null){
                c = new Koordinat(koordinat.getX()+1, koordinat.getY());
                jalan.add(c);
            } else {
                if (papan[koordinat.getX()+1][koordinat.getY()].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()+1, koordinat.getY());
                    jalan.add(c);
                }
            }
        }

        if ((koordinat.getX()+1)<8 && (koordinat.getY()-1)>=0){
            if (papan[koordinat.getX()+1][koordinat.getY()-1].getBidak() == null){
                c = new Koordinat(koordinat.getX()+1, koordinat.getY()-1);
                jalan.add(c);
            } else {
                if (papan[koordinat.getX()+1][koordinat.getY()-1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()+1, koordinat.getY()-1);
                    jalan.add(c);
                }
            }
        }


        //Jalan Raja Putih
        if ((koordinat.getX()-1)>=0 && (koordinat.getY()-1)>=0){
            if (papan[koordinat.getX()-1][koordinat.getY()-1].getBidak() == null){
                c = new Koordinat(koordinat.getX()-1, koordinat.getY()-1);
                jalan.add(c);
            } else {
                if (papan[koordinat.getX()-1][koordinat.getY()-1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()-1, koordinat.getY()-1);
                    jalan.add(c);
                }
            }
        }

        if ((koordinat.getX()-1)>=0 && (koordinat.getY()+1)<8){
            if (papan[koordinat.getX()-1][koordinat.getY()+1].getBidak()==null){
                c = new Koordinat(koordinat.getX()-1, koordinat.getY()+1);
                jalan.add(c);
            } else {
                if (papan[koordinat.getX()-1][koordinat.getY()+1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()-1, koordinat.getY()+1);
                    jalan.add(c);
                }
            }
        }

        if ((koordinat.getX()-1)>=0){
            if (papan[koordinat.getX()-1][koordinat.getY()].getBidak() == null){
                c = new Koordinat(koordinat.getX()-1, koordinat.getY());
                jalan.add(c);
            } else {
                if (papan[koordinat.getX()-1][koordinat.getY()].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()-1, koordinat.getY());
                    jalan.add(c);
                }
            }
        }

        if ((koordinat.getY()+1)<8){
            if (papan[koordinat.getX()][koordinat.getY()+1].getBidak() == null){
                c = new Koordinat(koordinat.getX(), koordinat.getY()+1);
                jalan.add(c);
            } else {
                if (papan[koordinat.getX()][koordinat.getY()+1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX(), koordinat.getY()+1);
                    jalan.add(c);
                }
            }
        }

        if ((koordinat.getY()-1)>=0){
            if (papan[koordinat.getX()][koordinat.getY()-1].getBidak() == null){
                c = new Koordinat(koordinat.getX(), koordinat.getY()-1);
                jalan.add(c);
            } else {
                if (papan[koordinat.getX()][koordinat.getY()-1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX(), koordinat.getY()-1);
                    jalan.add(c);
                }
            }
        }

        return jalan;
    }
}
