package com.example.us.gamecollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_catur, iv_tictactoe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_catur = findViewById(R.id.iv_catur);
        iv_tictactoe = findViewById(R.id.iv_tictactoe);

        iv_catur.setOnClickListener(this);
        iv_tictactoe.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_tictactoe:
                Intent intent = new Intent(this, TicTacToe.class);
                startActivity(intent);
                break;
            case R.id.iv_catur:
                Intent intent1 = new Intent(this, UserChess.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
