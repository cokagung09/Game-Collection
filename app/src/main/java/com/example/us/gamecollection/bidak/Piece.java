package com.example.us.gamecollection.bidak;

import com.example.us.gamecollection.Coordinates;
import com.example.us.gamecollection.Position;
import com.example.us.gamecollection.TitikXY;

import java.util.ArrayList;

public class Piece {

    private boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public ArrayList<Coordinates> AllowedMove(Coordinates coordinates, Position[][] board){
        ArrayList<Coordinates> allowedMoves = new ArrayList<>();
        Coordinates c;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                coordinates = new Coordinates(i,j);
                allowedMoves.add(coordinates);
            }
        }
        return allowedMoves;
    }

    public boolean isWhite() {
        return white;
    }
}
