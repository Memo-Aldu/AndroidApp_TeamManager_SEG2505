package com.example.seg2505_profile_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOpenInGoogleMaps(View view)
    {
        EditText teamAddrese  = (EditText)findViewById(R.id.teamAddressText);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddrese.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW,  gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    public void OnsetAvatarButton(View view)
    {
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {

            return;
        }
        Log.d("msg","here3");
        ImageView avatarImage = (ImageView) findViewById(R.id.teamImage);

        String drawableName = "gridImage00";

        switch (data.getIntExtra("imageID", R.id.gridImage00)) {
            case R.id.gridImage00:
                drawableName = "ic_logo_00";
                Log.d("msg","here4");
                break;
            case R.id.gridImage01:
                drawableName = "ic_logo_01";
                Log.d("msg","here5");
                break;

            case R.id.gridImage02:
                drawableName = "ic_logo_02";
                break;

            case R.id.gridImage10:
                drawableName = "ic_logo_03";
                break;

            case R.id.gridImage11:
                drawableName = "ic_logo_04";
                break;

            case R.id.gridImage12:
                drawableName = "ic_logo_05";
                break;

            default:
                drawableName = "ic_logo_05";
                Log.d("msg","here6");
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);

    }
}