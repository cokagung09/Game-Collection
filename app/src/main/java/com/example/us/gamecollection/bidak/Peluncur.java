package com.example.us.gamecollection.bidak;

import com.example.us.gamecollection.catur.Bidak;
import com.example.us.gamecollection.catur.Koordinat;
import com.example.us.gamecollection.catur.Posisi;

import java.util.ArrayList;

public class Peluncur extends Bidak{

    public Peluncur(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Koordinat> gerakBidak(Koordinat koordinat, Posisi[][] papan) {
        ArrayList<Koordinat> jalan = new ArrayList<>();
        Koordinat c;

        for (int i=1; i<8; i++){
            if ((koordinat.getX()+i)<8 && (koordinat.getY()+i)<8){
                if (papan[koordinat.getX()+i][koordinat.getY()+i].getBidak() == null){
                    c = new Koordinat(koordinat.getX()+i, koordinat.getY()+i);
                    jalan.add(c);
                } else {
                    if (papan[koordinat.getX()+i][koordinat.getY()+i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()+i, koordinat.getY()+i);
                        jalan.add(c);
                    }
                    break;
                }
            }
        }

        for (int i =1; i<8; i++){
            if ((koordinat.getX()+i)<8 && (koordinat.getY()-i)>=0){
                if (papan[koordinat.getX()+i][koordinat.getY()-i].getBidak() == null){
                    c = new Koordinat(koordinat.getX() + i, koordinat.getY() - i);
                    jalan.add(c);
                } else {
                    if (papan[koordinat.getX()+i][koordinat.getY()-i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()+i, koordinat.getY()-i);
                        jalan.add(c);
                    }
                    break;
                }

            }
        }

        for (int i =1; i<8; i++){
            if ((koordinat.getX()-i)>=0 && (koordinat.getY()-i)>=0){
                if (papan[koordinat.getX()-i][koordinat.getY()-i].getBidak() == null){
                    c = new Koordinat(koordinat.getX()-i, koordinat.getY()-i);
                    jalan.add(c);
                } else {
                    if (papan[koordinat.getX()-i][koordinat.getY()-i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()-i, koordinat.getY()-i);
                        jalan.add(c);
                    }
                    break;
                }
            }
        }

        for (int i = 1; i<8; i++){
            if ((koordinat.getX()-i)>=0 && (koordinat.getY()+i) <8){
                if (papan[koordinat.getX()-i][koordinat.getY()+i].getBidak() == null){
                    c = new Koordinat(koordinat.getX() - i, koordinat.getY()+i);
                    jalan.add(c);
                } else {
                    if (papan[koordinat.getX()-i][koordinat.getY()+i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()-i, koordinat.getY()+i);
                        jalan.add(c);
                    }

                    break;
                }
            }
        }

        return jalan;

    }
}
