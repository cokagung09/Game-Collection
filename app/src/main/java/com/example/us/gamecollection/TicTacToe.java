package com.example.us.gamecollection;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToe extends AppCompatActivity implements View.OnClickListener{

    private final static String TAG = TicTacToe.class.getSimpleName();
    private LinearLayout linearLayout[];
    private Button btn[][];
    private Button btn_keluar, btn_reset;
    private LinearLayout latas;
    private int merah, hijau, abu;
    private TextView tv_info;
    MediaPlayer player,player1;

    int TURN_COUNT = 0;
    boolean PLAYER_X = true;
    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);

        merah = ContextCompat.getColor(this, R.color.merah);
        hijau = ContextCompat.getColor(this, R.color.hijau);
        abu = ContextCompat.getColor(this, R.color.abu);

        btn_keluar = findViewById(R.id.btn_keluar);
        btn_reset = findViewById(R.id.btn_ulang);
        tv_info = findViewById(R.id.tv_info1);

        Point layar = new Point();
        getWindowManager().getDefaultDisplay().getSize(layar);

        int lebartombol = (int) (layar.x / 3)-25;

        linearLayout = new LinearLayout[3];

        btn = new Button[3][3];

        latas = findViewById(R.id.layoutatas);

        LinearLayout.LayoutParams x = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams x1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        x1.setMargins(5, 5, 5, 5);

        int n = 0;

        for (int i = 0; i < 3; i++) {
            linearLayout[i] = new LinearLayout(this);
            linearLayout[i].setOrientation(LinearLayout.HORIZONTAL);
            linearLayout[i].setLayoutParams(x);

            latas.addView(linearLayout[i]);
            for (int j = 0; j < 3; j++) {
                btn[i][j] = new Button(this);
                btn[i][j].setId(n++);
                btn[i][j].setText("");
                btn[i][j].setTextSize(20);
                btn[i][j].setBackgroundColor(abu);
                btn[i][j].setLayoutParams(x1);
                btn[i][j].setOnClickListener(this);

                btn[i][j].setWidth(lebartombol);
                btn[i][j].setHeight(300);

                linearLayout[i].addView(btn[i][j]);
            }

        }


//        //Music Background
//        player = MediaPlayer.create(this, R.raw.backsound);
//        player.setLooping(true);
//        player.start();

        btn_reset.setOnClickListener(this);
        btn_keluar.setOnClickListener(this);
        intialzeBoard();
    }

    private void intialzeBoard() {
        for (int i = 0; i<3; i++){
            for (int j = 0; j < 3; j++){
                boardStatus[i][j] = -1;
            }
        }
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "Inside Click");

        boolean resetButtonPress = false;

        LinearLayout.LayoutParams x = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        x.setMargins(5, 5, 5, 5);

//        player1 = MediaPlayer.create(TicTacToe.this, R.raw.tileclick);

        for (int i=0; i<3;i++){
            for (int j=0; j<3; j++){
                if (view.getId() == btn[i][j].getId()){
                    if (PLAYER_X){
                        btn[i][j].setText("X");
                        btn[i][j].setEnabled(false);
                        btn[i][j].setLayoutParams(x);
                        btn[i][j].setBackgroundColor(merah);
                        boardStatus[i][j] = 0;
//                        player1.start();
                    } else {
                        btn[i][j].setText("O");
                        boardStatus[i][j] = 1;
                        btn[i][j].setLayoutParams(x);
                        btn[i][j].setBackgroundColor(hijau);
                        btn[i][j].setEnabled(false);
//                        player1.start();
                    }
                }
            }
        }

        switch (view.getId()) {
            case R.id.btn_ulang:
                resetButtonPress = true;
                break;
            case R.id.btn_keluar:
                finish();
                break;
            default:
                break;
        }
        if (resetButtonPress){
            resetButton();
        } else {
            TURN_COUNT ++;
            PLAYER_X =! PLAYER_X;

            if (PLAYER_X){
                setInfo("Player X Turn");
            } else {
                setInfo("Player O Turn");
            }

            if (TURN_COUNT == 9){
                result("Game Draw");
            }

            checkWinner();
        }
    }

    private void result(String hasil) {
        tv_info.setText(hasil);
    }

    private void setInfo(String info) {
        tv_info.setText(info);
    }

    private void checkWinner() {
        Log.d(TAG, "Inside checkWinner");

        for (int i = 0; i <3; i++){
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if (boardStatus[i][0]==1){
                    result("Player O Winner");
                    enableBoxes(false);
                    break;
                } else if (boardStatus[i][0]==0){
                    result("Player X Winner");
                    enableBoxes(false);
                    break;
                }
            }
        }

        for(int i=0; i<3; i++){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if (boardStatus[0][i]==1){
                    result("Player O Winner");
                    enableBoxes(false);
                    break;
                }
                else if (boardStatus[0][i]==0) {
                    result("Player X Winner");
                    enableBoxes(false);
                    break;
                }
            }
        }

        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                result("Player O Winner");
                enableBoxes(false);
            }
            else if (boardStatus[0][0]==0) {
                result("Player X Winner");
                enableBoxes(false);
            }
        }

        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if (boardStatus[0][2]==1){
                result("Player O Winner");
                enableBoxes(false);
            }
            else if (boardStatus[0][2]==0) {
                result("Player X Winner");
                enableBoxes(false);
            }
        }
    }

    private void enableBoxes(boolean vaalue) {
        Log.d(TAG, "Inside EnableBoxes");

        for (int i=0; i<3;i++){
            for (int j=0; j<3; j++){
                btn[i][j].setEnabled(vaalue);
            }
        }
    }
    private void resetButton() {
        Log.d(TAG, "Inside reset");

        LinearLayout.LayoutParams x = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        x.setMargins(5, 5, 5, 5);

        for (int i=0; i<3;i++){
            for (int j=0; j<3; j++){
                btn[i][j].setText("");
                btn[i][j].setBackgroundColor(abu);
            }
        }
        enableButton(true);
        PLAYER_X = true;
        TURN_COUNT = 0;

        intialzeBoard();

        Toast.makeText(this, "Board Reset", Toast.LENGTH_SHORT).show();
    }

    private void enableButton(boolean value) {
        Log.d(TAG, "Inside EnableBoxes");

        for (int i=0; i<3;i++){
            for (int j=0; j<3; j++){
                btn[i][j].setEnabled(value);
            }
        }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        player.stop();
//    }
}
