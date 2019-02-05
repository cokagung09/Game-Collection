package com.example.us.gamecollection.bidak;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.us.gamecollection.Coordinates;
import com.example.us.gamecollection.Position;
import com.example.us.gamecollection.R;
import com.example.us.gamecollection.catur.Bidak;
import com.example.us.gamecollection.catur.Koordinat;
import com.example.us.gamecollection.catur.Posisi;

import java.util.ArrayList;

public class Rakyat extends Bidak {

    public Rakyat(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Koordinat> gerakBidak(Koordinat koordinat, Posisi[][] papan) {
        ArrayList<Koordinat> izinJalan = new ArrayList<>();
        Koordinat c;
        izinJalan.clear();


        if (papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){

            if (koordinat.getY()<8 && koordinat.getY()>=0 && (koordinat.getX()-1)<8 && (koordinat.getX()-1)>=0){
                if (papan[koordinat.getX()-1][koordinat.getY()].getBidak()==null){
                    c = new Koordinat(koordinat.getX()-1, koordinat.getY());
                    izinJalan.add(c);

                    if ((koordinat.getX() == 6) && (papan[koordinat.getX()-2][koordinat.getY()].getBidak() == null)){
                        c = new Koordinat(koordinat.getX()-2, koordinat.getY());
                        izinJalan.add(c);
                    }
                }
            }

            if ((koordinat.getY()+1)<8 && (koordinat.getY()+1)>=0 && (koordinat.getX()-1)<8 && (koordinat.getX()-1)>=0){
                if (papan[koordinat.getX()-1][koordinat.getY()+1].getBidak() != null){
                    if (papan[koordinat.getX()-1][koordinat.getY()+1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()-1, koordinat.getY()+1);
                        izinJalan.add(c);
                    }
                }
            }

            if((koordinat.getX()-1)<8 && (koordinat.getX()-1)>=0 && (koordinat.getY()-1)<8 && (koordinat.getY()-1)>=0) {
                if (papan[koordinat.getX() - 1][koordinat.getY() - 1].getBidak() != null) {
                    if(papan[koordinat.getX() - 1][koordinat.getY() - 1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX() - 1, koordinat.getY() - 1);
                        izinJalan.add(c);
                    }
                }
            }

        } else {
            if ((koordinat.getX()+1)<8 && (koordinat.getX()+1)>=0 && (koordinat.getY())<8 && (koordinat.getY())>=0){
                if (papan[koordinat.getX()+1][koordinat.getY()].getBidak() == null){
                    c = new Koordinat(koordinat.getX()+1, koordinat.getY());
                    izinJalan.add(c);

                    if (koordinat.getX() == 1 && (papan[koordinat.getX()+2][koordinat.getY()].getBidak() == null)){
                        c = new Koordinat(koordinat.getX()+2, koordinat.getY());
                        izinJalan.add(c);
                    }
                }

            }

            if ((koordinat.getX()+1)<8 && (koordinat.getX()+1)>=0 && (koordinat.getY()+1)<8 && (koordinat.getY()+1)>=0){
                if (papan[koordinat.getX()+1][koordinat.getY()+1].getBidak() != null){
                    if (papan[koordinat.getX() + 1][koordinat.getY()+1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()+1, koordinat.getY()+1);
                        izinJalan.add(c);
                    }
                }
            }

            if ((koordinat.getX()+1)<8 && (koordinat.getX()+1)>=0 && (koordinat.getY()-1)<8 && (koordinat.getY()-1)>=0){
                if (papan[koordinat.getX()+1][koordinat.getY()-1].getBidak() != null){
                    if (papan[koordinat.getX()+1][koordinat.getY()-1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()+1, koordinat.getY()-1);
                        izinJalan.add(c);
                    }
                }
            }
        }

        return izinJalan;
    }
}
