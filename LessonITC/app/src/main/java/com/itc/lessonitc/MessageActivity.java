package com.itc.lessonitc;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MessageActivity extends BaseActivity {

    private Intent inten = null;
    private TextView lbm;
    private EditText txbac;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        inten = getIntent();
        String s = inten.getStringExtra("mess");
        lbm = findViewById(R.id.lblmessage);
        lbm.setText(s);
        txbac = findViewById(R.id.txtback);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==3){
            Toast.makeText(MessageActivity.this,"from Main",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void SendBack(View view) {
//
//
        String replyMessage = txbac.getText().toString();
        Intent data = new Intent();
        //Intent d = null;
        data.putExtra("A", replyMessage);
        setResult(RESULT_OK, data);
        finish();
    }
}
