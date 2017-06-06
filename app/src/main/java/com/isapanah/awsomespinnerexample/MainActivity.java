package com.isapanah.awsomespinnerexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.isapanah.awesomespinner.AwesomeSpinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AwesomeSpinner spinnerRTL, spinnerLTR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerRTL = (AwesomeSpinner) findViewById(R.id.awesomeSpinner_example_rtl);
        spinnerLTR = (AwesomeSpinner) findViewById(R.id.awesomeSpinner_example_ltr);


        //Initialize the Adapter and spinnerRTL listener
        ArrayAdapter<CharSequence> provincesAdapter = ArrayAdapter.createFromResource(this, R.array.iran_provinces, android.R.layout.simple_spinner_item);
        spinnerRTL.setAdapter(provincesAdapter, 0);
        spinnerRTL.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {
                Toast.makeText(getApplicationContext(), "Position: "+position+" | Item: "+itemAtPosition+" | isSelected:"+spinnerLTR.isSelected(), Toast.LENGTH_LONG).show();
            }
        });


        //Initialize the Adapter and spinnerLTR listener
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        spinnerLTR.setAdapter(categoriesAdapter);
        spinnerLTR.setOnSpinnerItemClickListener(new AwesomeSpinner.onSpinnerItemClickListener<String>() {
            @Override
            public void onItemSelected(int position, String itemAtPosition) {
                Toast.makeText(getApplicationContext(), "Position: "+position+" | Item: "+itemAtPosition+" | isSelected:"+spinnerLTR.isSelected(), Toast.LENGTH_LONG).show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Or you can check for spinnerLTR as the same way
                if(spinnerRTL.isSelected()){
                    Snackbar.make(view, "Yes, spinnerRTL is selected the item: "+spinnerRTL.getSelectedItem()+".", Snackbar.LENGTH_LONG)
                            .setAction("OK", null).show();
                }else{
                    Snackbar.make(view, "No, spinnerRTL doesn't select anything yet!", Snackbar.LENGTH_LONG)
                            .setAction("OK", null).show();
                }


            }
        });

    }

}
