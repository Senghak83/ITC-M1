package com.itc.lessonitc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView lblD;
    private EditText txtMess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMess = findViewById(R.id.txtSend);
        lblD = findViewById(R.id.lblbackMessage);


    }

    public void SendMessage(View view) {
        String mes = txtMess.getText().toString();
        if(mes.isEmpty()==true)return;
        Intent in = new Intent(MainActivity.this,MessageActivity.class);
        in.putExtra("mess",mes);
        startActivityForResult(in,1);
        //finish();
        //startActivity(in);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data!=null;

        if (resultCode == RESULT_OK) {
            if (requestCode == 1 && data!=null) {
                //Toast.makeText(this, data.getStringExtra("A"), Toast.LENGTH_SHORT).show();
                assert data!=null;
                lblD.setText(data.getStringExtra("A"));
            }
        }
    }


    public void SendObject(View view) {
        Intent in = new Intent(MainActivity.this,frmSendMessage.class);

        startActivityForResult(in,2);
    }
}
