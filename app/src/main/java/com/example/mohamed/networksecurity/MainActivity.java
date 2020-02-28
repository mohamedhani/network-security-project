package com.example.mohamed.networksecurity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mohamed.networksecurity.Algorithms.CeaserSipher;
import com.example.mohamed.networksecurity.Algorithms.PlayFair;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity {


    RadioButton ceaserSipherRB;
    RadioButton fairPlayRB;
    RadioButton desRb;
    Button encriptButton;
    Button decriptButton;
    EditText inputEditText;
    EditText outputEditText;
    EditText keyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ceaserSipherRB = (RadioButton) findViewById(R.id.ceaser_sipher);
        fairPlayRB = (RadioButton) findViewById(R.id.fair_play);
        desRb = (RadioButton) findViewById(R.id.des);
        encriptButton = (Button) findViewById(R.id.encription);
        decriptButton = (Button) findViewById(R.id.decreption);
        inputEditText = (EditText) findViewById(R.id.text_entered);
        outputEditText = (EditText) findViewById(R.id.output_text);
        keyEditText = (EditText) findViewById(R.id.key);
        encriptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ceaserSipherRB.isChecked() && !TextUtils.isEmpty(keyEditText.getText().toString())) {
                    int key = Integer.parseInt(keyEditText.getText().toString());
                    if (key > 25) {
                        Toast.makeText(MainActivity.this, "key must be less than 25", Toast.LENGTH_LONG).show();
                        keyEditText.setText(25 + "");

                    } else {
                        String inputString = inputEditText.getText().toString().trim();
                        String outputString = CeaserSipher.getEncriptedText(key, inputString);
                        outputEditText.setText(outputString);
                    }

                } else if (fairPlayRB.isChecked() && !TextUtils.isEmpty(keyEditText.getText().toString())) {
                    String key = keyEditText.getText().toString().trim();
                    String plainText = inputEditText.getText().toString();
                    String cipherText = PlayFair.Encript(key, plainText);
                    outputEditText.setText(cipherText);

                } else if (desRb.isChecked()) {

                } else {
                    Toast.makeText(MainActivity.this, "enter key and select Algorthms", Toast.LENGTH_LONG).show();
                }
            }
        });
        decriptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ceaserSipherRB.isChecked() && !TextUtils.isEmpty(keyEditText.getText().toString())) {
                    int key = Integer.parseInt(keyEditText.getText().toString());
                    String inputString = inputEditText.getText().toString().trim();
                    String outputString = CeaserSipher.getDecription(key, inputString);
                    outputEditText.setText(outputString);

                } else if (fairPlayRB.isChecked()) {

                } else if (desRb.isChecked()) {

                } else {
                    Toast.makeText(MainActivity.this, "enter key and select Algorthms", Toast.LENGTH_LONG).show();
                }
            }
        });
        ceaserSipherRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyEditText.setText("");
                keyEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        });
        fairPlayRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyEditText.setText("");
                keyEditText.setInputType(InputType.TYPE_CLASS_TEXT);
            }
        });

    }
}