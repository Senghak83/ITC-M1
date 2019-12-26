package com.itc.lessonitc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class frmSendMessage extends AppCompatActivity {

    private ActionBar actionbar;
    private EditText tTo, tTitle,tMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_send_message);

        //---------set ACtion bare----------
        actionbar = getSupportActionBar();
        //---------Display ------
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);
        actionbar.setTitle("frm Send object");

         // set Icont share on Actionbar
        actionbar.setIcon(R.drawable.share);

        //--------------Reference-----------
         tTo = findViewById(R.id.txtTitle);
         tTitle = findViewById(R.id.txtTitle);
         tMessage = findViewById(R.id.txtMess);

    }

    //-------Override method Action Event bar with arrow back--------

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void seObject(View view) {
              Date d = new Date();
              //SampleDateFormat df = new SampleDateFormat("");
              //SimpleDateFormat df= new SimpleDateFormat("dd/mm/yyyy");
              //df.format(d);

              String to = tTo.getText().toString();
              String ti = tTitle.getText().toString();
              String tm = tMessage.getText().toString();

              if(to.isEmpty()==true || ti.isEmpty() == true
                      || tm.isEmpty()==true) return ;
         Intent in = new Intent(frmSendMessage.this,frmGetMessa.class);
         MedeMessage md = new MedeMessage(to,ti,tm,d);
         in.putExtra("Mes",md);
         startActivity(in);
         finish();

    }
    //---------------
}