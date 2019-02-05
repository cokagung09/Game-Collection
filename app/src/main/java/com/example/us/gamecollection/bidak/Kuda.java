package com.example.us.gamecollection.bidak;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.us.gamecollection.Coordinates;
import com.example.us.gamecollection.R;
import com.example.us.gamecollection.catur.Bidak;
import com.example.us.gamecollection.catur.Koordinat;
import com.example.us.gamecollection.catur.Posisi;

import java.util.ArrayList;

public class Kuda extends Bidak {

    int merah, hitam, putih;

    public Kuda(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Koordinat> gerakBidak(Koordinat koordinat, Posisi[][] papan) {

        ArrayList<Koordinat> jalan = new ArrayList<>();
        Koordinat c;
        jalan.clear();

        if ((koordinat.getY()+2)<8 && (koordinat.getX()-1)>=0){
            if(papan[koordinat.getX()-1][koordinat.getY()+2].getBidak() ==null){
                c = new Koordinat(koordinat.getX()-1, koordinat.getY()+2);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()-1][koordinat.getY()+2].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()-1, koordinat.getY()+2);
                    jalan.add(c);
                }
            }
        }

        if (koordinat.getY()+1 <8 && koordinat.getX()-2 >=0){
            if(papan[koordinat.getX()-2][koordinat.getY()+1].getBidak() ==null){
                c = new Koordinat(koordinat.getX()-2 , koordinat.getY()+1);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()-2][koordinat.getY()+1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()-2 , koordinat.getY()+1);
                    jalan.add(c);
                }
            }
        }

        if (koordinat.getX()-1 >= 0 && koordinat.getY()-2 >=0){
            if(papan[koordinat.getX()-1][koordinat.getY()-2].getBidak() ==null){
                c = new Koordinat(koordinat.getX()-1 , koordinat.getY()-2);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()-1][koordinat.getY()-2].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()-1 , koordinat.getY()-2);
                    jalan.add(c);
                }
            }
        }

        if (koordinat.getX()-2 >=0  && koordinat.getY()-1 >=0){
            if(papan[koordinat.getX()-2][koordinat.getY()-1].getBidak() ==null){
                c = new Koordinat(koordinat.getX()-2 , koordinat.getY()-1);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()-2][koordinat.getY()-1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()-2 , koordinat.getY()-1);
                    jalan.add(c);
                }
            }
        }

        if (koordinat.getX()+1 <8 && koordinat.getY()+2 <8){
            if(papan[koordinat.getX()+1][koordinat.getY()+2].getBidak() ==null){
                c = new Koordinat(koordinat.getX()+1 , koordinat.getY()+2);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()+1][koordinat.getY()+2].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()+1 , koordinat.getY()+2);
                    jalan.add(c);
                }
            }
        }

        if (koordinat.getX()+2 <8 && koordinat.getY()+1 <8){
            if(papan[koordinat.getX()+2][koordinat.getY()+1].getBidak() ==null){
                c = new Koordinat(koordinat.getX()+2 , koordinat.getY()+1);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()+2][koordinat.getY()+1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()+2 , koordinat.getY()+1);
                    jalan.add(c);
                }
            }
        }

        if (koordinat.getX()+1 <8 && koordinat.getY()-2 >=0){
            if(papan[koordinat.getX()+1][koordinat.getY()-2].getBidak() ==null){
                c = new Koordinat(koordinat.getX()+1 , koordinat.getY()-2);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()+1][koordinat.getY()-2].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()+1 , koordinat.getY()-2);
                    jalan.add(c);
                }
            }
        }

        if (koordinat.getX()+2 <8 && koordinat.getY()-1 >=0){
            if(papan[koordinat.getX()+2][koordinat.getY()-1].getBidak() ==null){
                c = new Koordinat(koordinat.getX()+2 , koordinat.getY()-1);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()+2][koordinat.getY()-1].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX()+2 , koordinat.getY()-1);
                    jalan.add(c);
                }
            }
        }

        return jalan;

    }
}
