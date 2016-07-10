package com.example.capacitaciones.divisaschange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextValueToConvert;
    TextView textViewResult;
    TextView textViewCurrency;
    Button buttonLibraEsterlina;
    Button buttonYen;
    Button buttonAmericanDollar;
    Button buttonEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        initializeEvents();
    }

    private void initializeEvents() {
        buttonEuro.setOnClickListener(this);
        buttonAmericanDollar.setOnClickListener(this);
        buttonYen.setOnClickListener(this);
        buttonLibraEsterlina.setOnClickListener(this);
    }

    private void initializeComponents() {
        editTextValueToConvert = (EditText) findViewById(R.id.editTextValueToConvert);
        textViewCurrency = (TextView) findViewById(R.id.textViewShowCurrencyValue);
        textViewResult = (TextView) findViewById(R.id.textViewShowResult);
        buttonAmericanDollar = (Button) findViewById(R.id.buttonAmericanDollar);
        buttonEuro = (Button) findViewById(R.id.buttonEuro);
        buttonYen = (Button) findViewById(R.id.buttonYen);
        buttonLibraEsterlina = (Button) findViewById(R.id.buttonSterling);
    }

    @Override
    public void onClick(View v) {
        if(editTextValueToConvert.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), R.string.message_empty_currency, Toast.LENGTH_LONG).show();
        }else{
            double valueToConvert = Double.parseDouble(editTextValueToConvert.getText().toString());
            double currency = 0;
            switch (v.getId()){
                case R.id.buttonAmericanDollar:
                    double dollar = 3100;
                    currency = dollar * valueToConvert;
                    break;
                case R.id.buttonEuro:
                    double euro = 3200;
                    currency = euro * valueToConvert;
                    break;
            }
            textViewResult.setText(String.valueOf(currency));
        }
    }
}
