package com.example.madhav.schoolmanagement;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.madhav.schoolmanagement.R.id.gallery;

public class welcome_panel extends AppCompatActivity {
    private Button admin,student,teacher;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_panel);

        admin = findViewById(R.id.button2);
        student = findViewById(R.id.button4);
        teacher = findViewById(R.id.button5);

        admin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(welcome_panel.this,LoginPage.class);
                startActivity(intent);
                finish();

            }

        });


        student.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(welcome_panel.this,studentLogin.class);
                startActivity(intent);
                finish();

            }

        });

        teacher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(welcome_panel.this,MainActivity.class);
                startActivity(intent);
                finish();

            }

        });






        //https://www.youtube.com/watch?v=hl0AcuplFwE
        LinearLayout  gallery = findViewById(R.id.gallery);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0;i<4;i++){
            View view = inflater.inflate(R.layout.item,gallery,false);
            TextView textView = view.findViewById(R.id.text);
            //textView.setText("Item" + i);

            ImageView imageView = view.findViewById(R.id.imageView);
//            imageView.setImageResource(R.drawable.bus2);
//            imageView.setImageResource(R.drawable.students);
            imageView.setImageResource(R.drawable.reading);
            gallery.addView(view);
        }

    }
}
