package com.example.us.gamecollection.bidak;

import com.example.us.gamecollection.Coordinates;
import com.example.us.gamecollection.catur.Bidak;
import com.example.us.gamecollection.catur.Koordinat;
import com.example.us.gamecollection.catur.Posisi;

import java.util.ArrayList;

public class Ratu extends Bidak {

    public Ratu(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Koordinat> gerakBidak(Koordinat koordinat, Posisi[][] papan) {
        ArrayList<Koordinat> jalan = new ArrayList<>();
        Koordinat c;
        jalan.clear();

        // Jalan Kesamping Kanan
        for(int i=(koordinat.getY()+1) ; i<8 ; i++){
            if(papan[koordinat.getX()][i].getBidak() == null){
                c = new Koordinat(koordinat.getX(), i);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()][i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX(), i);
                    jalan.add(c);
                }
                break;
            }
        }

        // Jalan Kesamping Kiri
        for(int i=(koordinat.getY()-1) ; i>=0 ; i--){
            if(papan[koordinat.getX()][i].getBidak() == null){
                c = new Koordinat(koordinat.getX(), i);
                jalan.add(c);
            }else{
                if(papan[koordinat.getX()][i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX(), i);
                    jalan.add(c);
                }
                break;
            }
        }
        // Jalan Kedepan
        for(int i=(koordinat.getX()-1) ; i>=0 ; i--){
            if(papan[i][koordinat.getY()].getBidak() == null){
                c = new Koordinat(i, koordinat.getY());
                jalan.add(c);
            }else{
                if(papan[i][koordinat.getY()].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(i, koordinat.getY());
                    jalan.add(c);
                }
                break;
            }
        }

        for(int i=(koordinat.getX()+1) ; i<8 ;i++){
            if(papan[i][koordinat.getY()].getBidak() == null){
                c = new Koordinat(i, koordinat.getY());
                jalan.add(c);
            }else{
                if(papan[i][koordinat.getY()].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(i, koordinat.getY());
                    jalan.add(c);
                }
                break;
            }
        }

//        /*............................*/
//        Jalan Maju kedepan
        for(int i=1 ; i<8 ; i++){
            if((koordinat.getX()+i)<8 && (koordinat.getY()+i)<8){
                if(papan[koordinat.getX()+i][koordinat.getY()+i].getBidak() == null){
                    c = new Koordinat(koordinat.getX()+i , koordinat.getY()+i);
                    jalan.add(c);
                }else{
                    if(papan[koordinat.getX()+i][koordinat.getY()+i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()+i , koordinat.getY()+i);
                        jalan.add(c);
                    }
                    break;
                }
            }
        }

//        Jalan Kesegala Arah
        for(int i=1 ; i<8 ; i++){
            if((koordinat.getX()+i)<8 && (koordinat.getY()-i)>=0){
                if(papan[koordinat.getX()+i][koordinat.getY()-i].getBidak() == null){
                    c = new Koordinat(koordinat.getX()+i , koordinat.getY()-i);
                    jalan.add(c);
                }else{
                    if(papan[koordinat.getX()+i][koordinat.getY()-i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()+i , koordinat.getY()-i);
                        jalan.add(c);
                    }
                    break;
                }

            }
        }

//        Jalan Miring Kiri
        for(int i=1 ; i<8 ; i++){
            if((koordinat.getX()-i)>=0 && (koordinat.getY()-i)>=0){
                if(papan[koordinat.getX()-i][koordinat.getY()-i].getBidak() == null){
                    c = new Koordinat(koordinat.getX()-i , koordinat.getY()-i);
                    jalan.add(c);
                }else{
                    if(papan[koordinat.getX()-i][koordinat.getY()-i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()-i , koordinat.getY()-i);
                        jalan.add(c);
                    }
                    break;
                }

            }
        }

//        Jalan Miring Kanan
        for(int i=1 ; i<8 ; i++){
            if((koordinat.getX()-i)>=0 && (koordinat.getY()+i)<8){
                if(papan[koordinat.getX()-i][koordinat.getY()+i].getBidak() == null){
                    c = new Koordinat(koordinat.getX()-i , koordinat.getY()+i);
                    jalan.add(c);
                }else{
                    if(papan[koordinat.getX()-i][koordinat.getY()+i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                        c = new Koordinat(koordinat.getX()-i , koordinat.getY()+i);
                       jalan.add(c);
                    }
                    break;
                }

            }
        }

        return jalan;
    }
}
