// This is the main page of the schoolManagement Application
//Subject :Dissertation
package com.example.madhav.schoolmanagement;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
//Importing for the firebase authentication
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
   // Declaration  variable of AdapterViewFlipper
    AdapterViewFlipper movingImage;
 //Storing images in the array
    int[] IMG = {R.drawable.childpraying , R.drawable.childplaying , R.drawable.childdancing, R.drawable.childspeaking};

    String[] TITLE = {"" , "" , "" , ""};

    private Button StudentLogin, ContactUs, AboutUs;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connecting with xml files:


        StudentLogin = findViewById(R.id.button10);
        // Button Named as Home

        StudentLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,studentLogin.class);
                startActivity(intent);
                finish();




            }

        });
    //Contact Us button
      ContactUs = findViewById(R.id.button23);
        ContactUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ContactUs.class);
                startActivity(intent);
                finish();




            }

        });



    //Button named as About Us
      AboutUs = findViewById(R.id.button22);
        AboutUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutUsSchool.class);
                startActivity(intent);
                finish();




            }

        });


        movingImage = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext() , TITLE , IMG);
        movingImage.setAdapter(customAdapter);
        movingImage.setFlipInterval(2600);
        movingImage.setAutoStart(true);


    }

    //[ApkPure. 2019. Learn Android App Development: Tutorials]
    class CustomAdapter extends BaseAdapter {
        Context context;
        int[] images;
        String[] names;
        LayoutInflater inflater;

        public CustomAdapter (Context applicationContext , String[] names , int[] images) {
            this.context = applicationContext;
            this.images = images;
            this.names = names;
            inflater = (LayoutInflater.from(applicationContext));
        }

        @Override

        public int getCount ( ) {
            return names.length;
        }

        @Override
        public Object getItem (int position) {
            return null;
        }

        @Override
        public long getItemId (int position) {
            return 0;
        }

        @Override
        public View getView (int position , View view , ViewGroup parent) {
            view = inflater.inflate(R.layout.listitems , null);
            TextView name = (TextView) view.findViewById(R.id.name);
            ImageView image = (ImageView) view.findViewById(R.id.image);
            name.setText(names[position]);
            image.setImageResource(images[position]);
            return view;
        }


        
    }
//       [Github.2019.epicodus-lessons/restaurants]
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    //set icon
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Are you sure to Exit")

                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set when the button yes button is clicked
                            finish();
                        }
                    })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set when No button is clicked

                        }
                    })
                    .show();

    //    [stackOverFlow. 2019. How do I display an alert dialog on Android.]
        }
        return super.onOptionsItemSelected(item);
    }

    private void signout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}









