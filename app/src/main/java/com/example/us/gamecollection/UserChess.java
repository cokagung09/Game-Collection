package com.example.us.gamecollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserChess extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_player1, edt_player2;
    private Button btn_back, btn_start;

    String player1, player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chess);

        edt_player1 = findViewById(R.id.edt_player1);
        edt_player2 = findViewById(R.id.edt_player2);
        btn_start = findViewById(R.id.btn_start);
        btn_back = findViewById(R.id.btn_back);

        btn_start.setOnClickListener(this);
        btn_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                player1 = edt_player1.getText().toString();
                player2 = edt_player2.getText().toString();
                Intent intent1 = new Intent(this, Chess.class);
                intent1.putExtra("player1", player1);
                intent1.putExtra("player2", player2);
                startActivity(intent1);
                finish();
                break;
            case R.id.btn_back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
