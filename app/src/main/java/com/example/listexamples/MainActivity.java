
package com.example.listexamples;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;

    ArrayList<String> arrayNames = new ArrayList<>();
    ArrayList<String> arrids = new ArrayList<>();
    ArrayList<String> arraySpinner = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        // ListView Data
        arrayNames.add("Asia");
        arrayNames.add("Ali");
        arrayNames.add("Iqra");
        arrayNames.add("Hina");
        arrayNames.add("Usman");

        // Spinner Data
        arrids.add("Pan Card");
        arrids.add("Aadhar Card");
        arrids.add("Voter Card");
        arrids.add("Driving License");
        arrids.add("Passport");

        // ListView Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayNames
        );

        listView.setAdapter(adapter);

        // Spinner Adapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                arrids
        );

        spinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinner.setAdapter(spinnerAdapter);

        // ListView Item Click
        listView.setOnItemClickListener((parent, view, position, id) -> {

            String selectedName = arrayNames.get(position);

            Toast.makeText(
                    getApplicationContext(),
                    selectedName,
                    Toast.LENGTH_SHORT
            ).show();

        });

        // AutoCompleteTextView Data
        arraySpinner.add("C");
        arraySpinner.add("C++");
        arraySpinner.add("Java");
        arraySpinner.add("Python");
        arraySpinner.add("JavaScript");

        // AutoComplete Adapter
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                arraySpinner
        );

        autoCompleteTextView.setAdapter(adapter1);

        // Show suggestions after typing 1 character
        autoCompleteTextView.setThreshold(1);
    }
}
