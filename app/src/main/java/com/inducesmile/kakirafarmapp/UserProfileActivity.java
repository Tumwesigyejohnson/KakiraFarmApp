package com.inducesmile.kakirafarmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setTitle("User Profile");

        String userBio = getIntent().getExtras().getString("USER_BIO");
        Gson gson = ((CustomApplication)getApplication()).getGsonObject();

        UserObject mUserObject = gson.fromJson(userBio, UserObject.class);
        String bio = mUserObject.getUsername() + "\n" +
                mUserObject.getEmail() + "\n" +
                mUserObject.getPhone() + "\n" +
                mUserObject.getAddress() + "\n" +
                mUserObject.getPassword();

        TextView userTextValue = (TextView)findViewById(R.id.user_bio);
        userTextValue.setText(bio);
    }

    public void openfarmer(View view) {
        Button agree = (Button) findViewById(R.id.btn);
        agree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(UserProfileActivity.this, SettingsMenu.class);
                startActivity(loginIntent);
            }
        });}
}
