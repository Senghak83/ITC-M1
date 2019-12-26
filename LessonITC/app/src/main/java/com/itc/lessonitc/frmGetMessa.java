package com.itc.lessonitc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class frmGetMessa extends AppCompatActivity {

    private TextView lmail;
    private ActionBar abc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frm_get_messa);
        lmail = findViewById(R.id.lblMail);
        //--------------------
        abc = getSupportActionBar();
        abc.setDisplayShowHomeEnabled(true);
        abc.setDisplayHomeAsUpEnabled(true);
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setDisplayShowHomeEnabled(true);


        try {
            Intent in = getIntent();
            MedeMessage model = (MedeMessage)in.getSerializableExtra("Mes");
            //MedeMessage model = (MedeMessage) getIntent().getSerializableExtra("Md");
            String strmessage = "Message From <Mr....> Time : " + model.getDate()
                    + "\n Topic " + model.getTitle()+
                    "\n "+model.getMessate();
            lmail.setText(strmessage);
        }catch (Exception exp){Msg(exp.toString());}
    }

    //-----------MsgBox
    public void Msg(String sq){
        Toast.makeText(this, sq, Toast.LENGTH_SHORT).show();
    }
    //--------Override Mathod Action back Home bare

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
