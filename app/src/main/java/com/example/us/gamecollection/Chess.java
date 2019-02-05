package com.example.us.gamecollection;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.us.gamecollection.bidak.Benteng;
import com.example.us.gamecollection.bidak.Kuda;
import com.example.us.gamecollection.bidak.Peluncur;
import com.example.us.gamecollection.bidak.Raja;
import com.example.us.gamecollection.bidak.Rakyat;
import com.example.us.gamecollection.bidak.Ratu;
import com.example.us.gamecollection.catur.Bidak;
import com.example.us.gamecollection.catur.Koordinat;
import com.example.us.gamecollection.catur.Posisi;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Chess extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_player1, tv_player2;
    public Boolean FirstPlayerTurn;
    public ArrayList<Koordinat> listKoordinat = new ArrayList<>();
    private LinearLayout lineHori[], papan;
    private ImageButton lineVer[][];

    private Posisi[][] Board = new Posisi[8][8];
    private Posisi[][] Board2 = new Posisi[8][8];
    public ArrayList<Posisi[][]> LastMoves = new ArrayList<>();
    public Koordinat klikPosisi = new Koordinat(0, 0);
    int numberOfMove;
    boolean Anythingselected;


    private int hitam, putih, merah;


    Bidak bKing;
    Bidak wKing;

    Bidak bQueen;
    Bidak wQueen;

    Bidak bKnight1;
    Bidak bKnight2;
    Bidak wKnight1;
    Bidak wKnight2;

    Bidak bRook1;
    Bidak bRook2;
    Bidak wRook1;
    Bidak wRook2;

    Bidak bBishop1;
    Bidak bBishop2;
    Bidak wBishop1;
    Bidak wBishop2;

    Bidak bPawn1;
    Bidak bPawn2;
    Bidak bPawn3;
    Bidak bPawn4;
    Bidak bPawn5;
    Bidak bPawn6;
    Bidak bPawn7;
    Bidak bPawn8;

    Bidak wPawn1;
    Bidak wPawn2;
    Bidak wPawn3;
    Bidak wPawn4;
    Bidak wPawn5;
    Bidak wPawn6;
    Bidak wPawn7;
    Bidak wPawn8;

    public Koordinat lastPos = null;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess);

        Bundle bundle = getIntent().getExtras();

        hitam = ContextCompat.getColor(this, R.color.button);
        putih = ContextCompat.getColor(this, R.color.textview);
        merah = ContextCompat.getColor(this, R.color.merah);

        tv_player1 = findViewById(R.id.tv_player1);
        tv_player2 = findViewById(R.id.tv_player2);
        papan = findViewById(R.id.papan);

        tv_player1.setText("" + bundle.getString("player1"));
        tv_player2.setText("" + bundle.getString("player2"));

        lineHori = new LinearLayout[8];
        lineVer = new ImageButton[8][8];

        intialBoard();
    }

    private void intialBoard() {

        bKing = new Raja(false);
        wKing = new Raja(true);

        bQueen = new Ratu(false);
        wQueen = new Ratu(true);

        wRook1 = new Benteng(true);
        wRook2 = new Benteng(true);
        bRook1 = new Benteng(false);
        bRook2 = new Benteng(false);

        bBishop1 = new Peluncur(false);
        bBishop2 = new Peluncur(false);
        wBishop1 = new Peluncur(true);
        wBishop2 = new Peluncur(true);

        bKnight1 = new Kuda(false);
        bKnight2 = new Kuda(false);
        wKnight1 = new Kuda(true);
        wKnight2 = new Kuda(true);

        bPawn1 = new Rakyat(false);
        bPawn2 = new Rakyat(false);
        bPawn3 = new Rakyat(false);
        bPawn4 = new Rakyat(false);
        bPawn5 = new Rakyat(false);
        bPawn6 = new Rakyat(false);
        bPawn7 = new Rakyat(false);
        bPawn8 = new Rakyat(false);

        wPawn1 = new Rakyat(true);
        wPawn2 = new Rakyat(true);
        wPawn3 = new Rakyat(true);
        wPawn4 = new Rakyat(true);
        wPawn5 = new Rakyat(true);
        wPawn6 = new Rakyat(true);
        wPawn7 = new Rakyat(true);
        wPawn8 = new Rakyat(true);


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Board[i][j] = new Posisi(null);
                Board2[i][j] = new Posisi(null);
            }
        }

        Board[7][0].setBidak(wRook1);
        Board[7][1].setBidak(wKnight1);
        Board[7][2].setBidak(wBishop1);
        Board[7][3].setBidak(wQueen);
        Board[7][4].setBidak(wKing);
        Board[7][5].setBidak(wBishop2);
        Board[7][6].setBidak(wKnight2);
        Board[7][7].setBidak(wRook2);

        Board[6][0].setBidak(wPawn1);
        Board[6][1].setBidak(wPawn2);
        Board[6][2].setBidak(wPawn3);
        Board[6][3].setBidak(wPawn4);
        Board[6][4].setBidak(wPawn5);
        Board[6][5].setBidak(wPawn6);
        Board[6][6].setBidak(wPawn7);
        Board[6][7].setBidak(wPawn8);

        Board[0][0].setBidak(bRook1);
        Board[0][1].setBidak(bKnight1);
        Board[0][2].setBidak(bBishop1);
        Board[0][3].setBidak(bQueen);
        Board[0][4].setBidak(bKing);
        Board[0][5].setBidak(bBishop2);
        Board[0][6].setBidak(bKnight2);
        Board[0][7].setBidak(bRook2);

        Board[1][0].setBidak(bPawn1);
        Board[1][1].setBidak(bPawn2);
        Board[1][2].setBidak(bPawn3);
        Board[1][3].setBidak(bPawn4);
        Board[1][4].setBidak(bPawn5);
        Board[1][5].setBidak(bPawn6);
        Board[1][6].setBidak(bPawn7);
        Board[1][7].setBidak(bPawn8);


        LinearLayout.LayoutParams x = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams x1 = new LinearLayout.LayoutParams(139,
                139, 1);
        x1.setMargins(0, 0, 0, 0);

        for (int i = 0; i < 8; i++) {
            lineHori[i] = new LinearLayout(this);
            lineHori[i].setOrientation(LinearLayout.HORIZONTAL);
            lineHori[i].setLayoutParams(x);
            lineHori[i].setWeightSum(8);
            for (int j = 0; j < 8; j++) {
                lineVer[i][j] = new ImageButton(this);
                lineVer[i][j].setLayoutParams(x1);
                lineVer[i][j].setId(n++);

                if (i % 2 == 0) {

                    if (j % 2 == 0) {
                        lineVer[i][j].setBackgroundColor(hitam);
                    } else if (j % 2 != 0) {
                        lineVer[i][j].setBackgroundColor(putih);
                    }
                } else {
                    if (j % 2 == 0) {
                        lineVer[i][j].setBackgroundColor(putih);

                    } else {
                        lineVer[i][j].setBackgroundColor(hitam);
                    }
                }
                lineHori[i].addView(lineVer[i][j]);
                lineVer[i][j].setOnClickListener(this);
            }

            papan.addView(lineHori[i]);
        }


//        for (int g = 0; g < 8; g++) {
//            for (int h = 0; h < 8; h++) {
//                if (Board[g][h].getBidak() == null) {
//                    Board2[g][h].setBidak(null);
//                } else {
//                    Board2[g][h].setBidak(Board[g][h].getBidak());
//                }
//            }
//        }

        numberOfMove = 0;
        Anythingselected = false;
        FirstPlayerTurn = true;
        if (FirstPlayerTurn != true){
            tv_player1.setTextColor(putih);
            tv_player2.setTextColor(merah);
        } else {
            tv_player2.setTextColor(putih);
            tv_player1.setTextColor(merah);
        }
        setBidak();

    }

    private void setBidak() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Bidak bidak = Board[i][j].getBidak();
                int x;

                if (Board[i][j].getBidak() != null) {
                    if (bidak instanceof Raja) x = 0;
                    else if (bidak instanceof Ratu) x = 1;
                    else if (bidak instanceof Benteng) x = 2;
                    else if (bidak instanceof Peluncur) x = 3;
                    else if (bidak instanceof Kuda) x = 4;
                    else if (bidak instanceof Rakyat) x = 5;
                    else x = 6;

                    switch (x) {
                        case 0:
                            if (bidak.isPutih()) {
                                lineVer[i][j].setImageResource(R.drawable.wking);
                            } else {
                                lineVer[i][j].setImageResource(R.drawable.bking);
                            }
                            break;
                        case 1:
                            if (bidak.isPutih()) {
                                lineVer[i][j].setImageResource(R.drawable.wqueen);
                            } else {
                                lineVer[i][j].setImageResource(R.drawable.bqueen);
                            }
                            break;
                        case 2:
                            if (bidak.isPutih()) {
                                lineVer[i][j].setImageResource(R.drawable.wrook);

                            } else {
                                lineVer[i][j].setImageResource(R.drawable.brook);
                            }
                            break;
                        case 3:

                            if (bidak.isPutih()) {
                                lineVer[i][j].setImageResource(R.drawable.wbishop);
                            } else {
                                lineVer[i][j].setImageResource(R.drawable.bbishop);
                            }
                            break;
                        case 4:
                            if (bidak.isPutih()) {
                                lineVer[i][j].setImageResource(R.drawable.wknight);
                            } else {
                                lineVer[i][j].setImageResource(R.drawable.bknight);
                            }
                            break;
                        case 5:
                            if (bidak.isPutih()) {
                                lineVer[i][j].setImageResource(R.drawable.wpawn);


                            } else {
                                lineVer[i][j].setImageResource(R.drawable.bpawn);
                            }
                            break;
                        default:

                    }
                } else {
                    lineVer[i][j].setImageResource(0);
                }
            }
        }

//        rajaDalamBahaya();

    }

    private void rajaDalamBahaya() {

        ArrayList<Koordinat> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Board[i][j].getBidak() != null) {
                    list.clear();
                    Koordinat c = new Koordinat(i, j);
                    list = Board[i][j].getBidak().gerakBidak(c, Board);


                    for (int x = 0; x < list.size(); x++) {
                        if (Board[list.get(x).getX()][list.get(x).getY()].getBidak() instanceof Raja) {

                            if (Board[i][j].getBidak().isPutih() != Board[list.get(x).getX()][list.get(x).getY()].getBidak().isPutih()) {
                                lineVer[list.get(x).getX()][list.get(x).getY()].setBackgroundResource(R.color.colorKingInDanger);
                            }
                        }
                    }
                }
            }
        }

    }

    @Override
    public void onClick(View view) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (view.getId() == lineVer[j][i].getId()) {

                    klikPosisi = new Koordinat(0, 0);
                    klikPosisi.setX(j);
                    klikPosisi.setY(i);

                }
            }
        }
        if (!Anythingselected) {
            if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak() == null) {
                rajaDalamBahaya();
                return;
            } else {
                if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().isPutih() != FirstPlayerTurn) {
                    rajaDalamBahaya();
                    return;
                } else {
                    listKoordinat.clear();
                    listKoordinat = Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().gerakBidak(klikPosisi, Board);
                    lineVer[klikPosisi.getX()][klikPosisi.getY()].setBackgroundResource(R.color.colorSelected);

//                    Memeberikan cetakann warna pada setiap kali bidak dijalankan
                    setWarnaGerakBidak(listKoordinat);
                    Anythingselected = true;
                }
            }
        } else {
            if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak() == null) {
                if (jalanDiizinkan(listKoordinat, klikPosisi)) {

//                    Berfungsi Untuk menyimpan posisi akhir pada bidak pada papan
                    savePapan();
//                               ***** Raja sudah keadaan dimakan dan untuk menentukan pemenangnya *****
                    if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak() instanceof Raja) {
                        if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().isPutih() != FirstPlayerTurn) {
                           if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().isPutih()){
                               new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                       .setTitleText("Game Berakhir !!")
                                       .setContentText("Hitam Menang")
                                       .setCustomImage(R.drawable.bking1)
                                       .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                           @Override
                                           public void onClick(SweetAlertDialog sweetAlertDialog) {
                                               sweetAlertDialog.dismissWithAnimation();
                                               Intent intent = new Intent(Chess.this, UserChess.class);
                                               startActivity(intent);
                                               finish();
                                           }
                                       })
                                       .show();
                           } else {
                               new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                       .setTitleText("Game Berakhir !!")
                                       .setCustomImage(R.drawable.wking)

                                       .setContentText("Putih Menang")
                                       .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                           @Override
                                           public void onClick(SweetAlertDialog sweetAlertDialog) {
                                               sweetAlertDialog.dismissWithAnimation();
                                               Intent intent = new Intent(Chess.this, UserChess.class);
                                               startActivity(intent);
                                               finish();
                                           }
                                       })
                                       .show();
                           }
                        }
                    }
                    //Untuk mnaruh bidak setelah selesai berjalan
                    Board[klikPosisi.getX()][klikPosisi.getY()].setBidak(Board[lastPos.getX()][lastPos.getY()].getBidak());
                    Board[lastPos.getX()][lastPos.getY()].setBidak(null);

                    // Menentukan Bahwa raja dalam keadaan terancam untuk di makan
                    rajaDalamBahaya();

//                                Merubah Warna Papan catur kembali ke keadaan semula setelah membuat cetakan jalan
                    resetWarna(listKoordinat);
                    lineVer[lastPos.getX()][lastPos.getY()].setBackgroundResource(0);

// Merubah warna pada papan tempat bidak terakhir berada, semisal jika bidak berada di bagian papan putih maka dia tetap, apabila bidak berada di bagian hitam maka papan tersebut akan berwarna putih
                    resetWarnaPadaPosisiAkhir(lastPos);

                    Anythingselected = false;
                    FirstPlayerTurn = !FirstPlayerTurn;
                    if (FirstPlayerTurn != true){
                        tv_player1.setTextColor(putih);
                        tv_player2.setTextColor(merah);
                    } else {
                        tv_player2.setTextColor(putih);
                        tv_player1.setTextColor(merah);
                    }
                    cekPrajurit();

                } else {
                    resetWarnaPadaPosisiAkhir(lastPos);
                    resetWarna(listKoordinat);
                    Anythingselected = false;
                }
            } else {
                if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak() == null) {
                    rajaDalamBahaya();
                    return;
                } else {
                    if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak() != null) {
                        if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().isPutih() != FirstPlayerTurn) {
                            if (jalanDiizinkan(listKoordinat, klikPosisi)) {

//                                Berfungsi Untuk menyimpan posisi akhir pada bidak pada papan
                                savePapan();

//                               ***** Raja sudah keadaan dimakan dan untuk menentukan pemenangnya *****
                                if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak() instanceof Raja) {
                                    if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().isPutih() != FirstPlayerTurn) {
                                        if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().isPutih()){
                                            new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                                    .setTitleText("Game Berakhir !!")
                                                    .setContentText("Hitam Menang")
                                                    .setCustomImage(R.drawable.bking1)
                                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                        @Override
                                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                            sweetAlertDialog.dismissWithAnimation();
                                                            Intent intent = new Intent(Chess.this, UserChess.class);
                                                            startActivity(intent);
                                                            finish();
                                                        }
                                                    })
                                                    .show();
                                        } else {
                                            new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                                                    .setTitleText("Game Berakhir !!")
                                                    .setCustomImage(R.drawable.wking)
                                                    .setContentText("Putih Menang")
                                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                        @Override
                                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                            sweetAlertDialog.dismissWithAnimation();
                                                            Intent intent = new Intent(Chess.this, UserChess.class);
                                                            startActivity(intent);
                                                            finish();
                                                        }
                                                    })
                                                    .show();
                                        }
                                    }
                                }
                                //Untuk mengganti bidak ketika setelah dimakan
                                Board[klikPosisi.getX()][klikPosisi.getY()].setBidak(Board[lastPos.getX()][lastPos.getY()].getBidak());
                                Board[lastPos.getX()][lastPos.getY()].setBidak(null);

//                                Merubah Warna Papan catur kembali ke keadaan semula setelah membuat cetakan jalan
                                resetWarna(listKoordinat);

                                lineVer[lastPos.getX()][lastPos.getY()].setBackgroundResource(0);

// Merubah warna pada papan tempat bidak terakhir berada, semisal jika bidak berada di bagian papan putih maka dia tetap, apabila bidak berada di bagian hitam maka papan tersebut akan berwarna putih
                                resetWarnaPadaPosisiAkhir(lastPos);

                                Anythingselected = false;
                                FirstPlayerTurn = !FirstPlayerTurn;
                                if (FirstPlayerTurn != true){
                                    tv_player1.setTextColor(putih);
                                    tv_player2.setTextColor(merah);
                                } else {
                                    tv_player2.setTextColor(putih);
                                    tv_player1.setTextColor(merah);
                                }
                                cekPrajurit();
                            } else {
                                resetWarnaPadaPosisiAkhir(lastPos);
                                resetWarna(listKoordinat);
                                Anythingselected = false;
                            }

                        } else {
                            if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().isPutih() != FirstPlayerTurn) {
                                rajaDalamBahaya();
                                return;
                            }

                            resetWarnaPadaPosisiAkhir(lastPos);
                            resetWarna(listKoordinat);

                            listKoordinat.clear();
                            listKoordinat = Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().gerakBidak(klikPosisi, Board);
                            lineVer[klikPosisi.getX()][klikPosisi.getY()].setBackgroundResource(R.color.colorSelected);
                            setWarnaGerakBidak(listKoordinat);
                            Anythingselected = true;
                        }
                    }
                }
            }
        }


        rajaDalamBahaya();
        lastPos = new Koordinat(klikPosisi.getX(), klikPosisi.getY());
        setBidak();

    }

    private void cekPrajurit() {
        if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak() instanceof Rakyat) {
            if (Board[klikPosisi.getX()][klikPosisi.getY()].getBidak().isPutih()) {
                if (klikPosisi.getY() == 0) {
                    Toast.makeText(this, "Nanti Pasti diisi", Toast.LENGTH_SHORT).show();
                } else {
//                    pawn_choices.setVisibility(View.VISIBLE);
//                    pawn_choices.setRotation(180);
                }
            }
        }
        rajaDalamBahaya();
    }

    private void resetWarnaPadaPosisiAkhir(Koordinat lastPos) {
        if ((lastPos.getX() + lastPos.getY()) % 2 != 0) {
            lineVer[lastPos.getX()][lastPos.getY()].setBackgroundResource(R.color.colorBoardDark);
        } else {
            lineVer[lastPos.getX()][lastPos.getY()].setBackgroundResource(R.color.colorBoardLight);
        }
    }

    private void resetWarna(ArrayList<Koordinat> listKoordinat) {
        for (int i = 0; i < listKoordinat.size(); i++) {
            if ((listKoordinat.get(i).getX() + listKoordinat.get(i).getY()) % 2 != 0) {
                lineVer[listKoordinat.get(i).getX()][listKoordinat.get(i).getY()].setBackgroundResource(R.color.colorBoardDark);
            } else {
                lineVer[listKoordinat.get(i).getX()][listKoordinat.get(i).getY()].setBackgroundResource(R.color.colorBoardLight);
            }
        }
    }

    private void savePapan() {
        numberOfMove++;

        LastMoves.add(numberOfMove - 1, Board2);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                LastMoves.get(numberOfMove - 1)[i][j] = new Posisi(null);
            }
        }

        for (int g = 0; g < 8; g++) {
            for (int h = 0; h < 8; h++) {
                if (Board[g][h].getBidak() == null) {
                    LastMoves.get(numberOfMove - 1)[g][h].setBidak(null);
                } else {
                    LastMoves.get(numberOfMove - 1)[g][h].setBidak(Board[g][h].getBidak());
                }
            }
        }

    }

    private boolean jalanDiizinkan(ArrayList<Koordinat> listKoordinat, Koordinat klikPosisi) {
        Boolean izin = false;
        for (int i = 0; i < listKoordinat.size(); i++) {
            if (listKoordinat.get(i).getX() == klikPosisi.getX() && listKoordinat.get(i).getY() == klikPosisi.getY()) {
                izin = true;
                break;
            }
        }
        return izin;
    }

    private void setWarnaGerakBidak(ArrayList<Koordinat> list) {
        for (int i = 0; i < list.size(); i++) {
            if (Board[list.get(i).getX()][list.get(i).getY()].getBidak() == null) {
                lineVer[list.get(i).getX()][list.get(i).getY()].setBackgroundResource(R.color.colorPositionAvailable);
            } else {
                lineVer[list.get(i).getX()][list.get(i).getY()].setBackgroundResource(R.color.colorDanger);
            }
        }
    }

}

