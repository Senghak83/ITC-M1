package com.itc.lessonitc;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class BaseActivity extends AppCompatActivity {
    ActionBar abar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //-------------
        abar = getSupportActionBar();
        abar.setDisplayShowHomeEnabled(true);
        abar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home)
        {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(int titleId) {
         abar.setTitle(titleId);
    }

    @Override
    public void setTitle(CharSequence title) {
        abar.setTitle(title);
    }

}
