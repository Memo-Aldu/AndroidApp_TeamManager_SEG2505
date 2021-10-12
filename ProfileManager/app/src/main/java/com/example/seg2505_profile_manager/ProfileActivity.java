package com.example.seg2505_profile_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void setTeamIcon(View view)
    {
        Intent returnIntent = new Intent();

        ImageView selectedImage = (ImageView)view;

        returnIntent.putExtra("imageID", selectedImage.getId());


        setResult(Activity.RESULT_OK, returnIntent);
        Log.d("msg", "ok");

        finish();

    }
}