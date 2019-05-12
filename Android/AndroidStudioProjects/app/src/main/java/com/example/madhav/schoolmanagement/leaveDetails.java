//LeaveDetails
//ApkPure. 2019. Tutorials for Android: Learn Android. [ONLINE] Available at: https://apkpure.com/tutorials-for-android-learn-android/com.lionheartapps.rk.androidtutorials. [Accessed 22 February 2019].

package com.example.madhav.schoolmanagement;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class leaveDetails extends AppCompatActivity {


    String[] prefix = {
            "1","2","3","4","5","6","7",
            "8","9","10"
    };


    String[] studentName = {
            "HariPrashad Luitel","Jiban Yadadv","Ranju Pathak","Nisha Regmi","Liya Bhujal","Sita Chaudhari","Bhima Ojha",
            " Jack pandey", "Madhav Sapkota","Ranbir Kappor"
    };


    String problems[] = {
            "HeadAche","Marriage Function","Pain in legs","Relatives deadth","Family Problems","Raining","Fever",
            " School Pressure", "Not getting bus","diarrhoea"
    };



    TableLayout Table;
    TableRow tr;
    TextView row,stdName,probName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        Table = (TableLayout)findViewById(R.id.ipSubnet);


        addHeaders();
        addData();


    }



    // Table heading


    public void addHeaders(){

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        /** Prefix Heading **/
        TextView prefixHead = new TextView(this);
        prefixHead.setText("Class");
        prefixHead.setTextSize(18);
        prefixHead.setTextColor(getResources().getColor(android.R.color.darker_gray));
        prefixHead.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        prefixHead.setPadding(5, 5, 5, 0);
        tr.addView(prefixHead);  // Adding textView to tablerow.

        /** Mask Heading **/
        TextView maskHead = new TextView(this);
        maskHead.setText("StudentName");
        maskHead.setTextSize(18);
        maskHead.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        maskHead.setPadding(5, 5, 5, 0);
        maskHead.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(maskHead); // Adding textView to tablerow.

        /** Creating another textview **/
        TextView hostHead = new TextView(this);
        hostHead.setText("Leave Details");
        hostHead.setTextSize(18);
        hostHead.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        hostHead.setPadding(5, 5, 5, 0);
        hostHead.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(hostHead); // Adding textView to tablerow.


        // Add the TableRow to the TableLayout
        Table.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        /** Divider Color **/
        TextView divider = new TextView(this);
        divider.setText("********");
        divider.setTextColor(getResources().getColor(android.R.color.darker_gray));
        divider.setPadding(5, 0, 0, 0);
        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider); // Adding textView to tablerow.

        TextView divider2 = new TextView(this);
        divider2.setText("*****************");
        divider2.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2); // Adding textView to tablerow.

        TextView divider3 = new TextView(this);
        divider3.setText("***************");
        divider3.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        divider3.setPadding(5, 0, 0, 0);
        divider3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider3); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        Table.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
    }



    /** Class Common **/
    public void addData(){

        for (int i = 0; i < prefix.length; i++)
        {
//           Table is created in dynamic Ways.
            tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));


            row = new TextView(this);
            row.setText(prefix[i]);
            row.setTextSize(16);
            row.setTextColor(getResources().getColor(android.R.color.darker_gray));
            row.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            row.setPadding(5, 5, 5, 5);
            tr.addView(row);  // Adding textView to tablerow.

            /** Mask Value**/
            stdName = new TextView(this);
            stdName.setText(studentName[i]);
            stdName.setTextSize(16);
            stdName.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            stdName.setPadding(5, 5, 5, 5);
            stdName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(stdName); // Adding textView to tablerow.

            /** Host Value**/
            probName = new TextView(this);
            probName.setText(problems[i]);
            probName.setTextSize(16);
            probName.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
            probName.setPadding(5, 5, 5, 5);
            probName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(probName); // Adding textView to tablerow.


            // Add the TableRow to the TableLayout
            Table.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(leaveDetails.this, teacherData.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }


}