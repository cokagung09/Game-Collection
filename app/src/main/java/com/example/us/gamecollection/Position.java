package com.example.us.gamecollection;

import com.example.us.gamecollection.bidak.Piece;

public class Position {

    private Piece piece;

    public Position(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
