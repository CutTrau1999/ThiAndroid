package com.example.thiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, quantity;
    Button insert, view;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        quantity= findViewById(R.id.quantity);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);


        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProductList.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String quantityTXT = quantity.getText().toString();
                Boolean checkinsertdata  = DB.insertproductdata(nameTXT, quantityTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(MainActivity.this, "Product Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}