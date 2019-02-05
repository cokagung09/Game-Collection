package com.example.us.gamecollection.bidak;

import com.example.us.gamecollection.Coordinates;
import com.example.us.gamecollection.catur.Bidak;
import com.example.us.gamecollection.catur.Koordinat;
import com.example.us.gamecollection.catur.Posisi;

import java.util.ArrayList;

public class Benteng extends Bidak {

    public Benteng(boolean white) {
        super(white);
    }

    @Override
    public ArrayList<Koordinat> gerakBidak(Koordinat koordinat, Posisi[][] papan) {
        ArrayList<Koordinat> allowedMoves = new ArrayList<>();
        allowedMoves.clear();
        Koordinat c ;

        for(int i=(koordinat.getX()+1) ; i<8 ;i++){
            if(papan[i][koordinat.getY()].getBidak() == null){
                c = new Koordinat(i , koordinat.getY());
                allowedMoves.add(c);
            }else{
                if(papan[i][koordinat.getY()].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(i , koordinat.getY());
                    allowedMoves.add(c);
                }
                break;
            }
        }

        for(int i=(koordinat.getX()-1) ; i>=0 ; i--){
            if(papan[i][koordinat.getY()].getBidak() == null){
                c = new Koordinat(i , koordinat.getY());
                allowedMoves.add(c);
            }else{
                if(papan[i][koordinat.getY()].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(i , koordinat.getY());
                    allowedMoves.add(c);
                }
                break;
            }
        }

        for(int i=(koordinat.getY()-1) ; i>=0 ; i--){
            if(papan[koordinat.getX()][i].getBidak() == null){
                c = new Koordinat( koordinat.getX() , i);
                allowedMoves.add(c);
            }else{
                if(papan[koordinat.getX()][i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat( koordinat.getX() , i);
                    allowedMoves.add(c);
                }
                break;
            }
        }

        for(int i=(koordinat.getY()+1) ; i<8 ;i++){
            if(papan[koordinat.getX()][i].getBidak() == null){
                c = new Koordinat(koordinat.getX() , i);
                allowedMoves.add(c);
            }else{
                if(papan[koordinat.getX()][i].getBidak().isPutih() != papan[koordinat.getX()][koordinat.getY()].getBidak().isPutih()){
                    c = new Koordinat(koordinat.getX() , i);
                    allowedMoves.add(c);
                }
                break;
            }
        }
        //check locations at board
        //work on the coordinates and return the allowed moves
        return allowedMoves;
    }
}
