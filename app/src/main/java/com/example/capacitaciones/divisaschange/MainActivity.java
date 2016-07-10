package com.example.capacitaciones.divisaschange;

import android.os.PersistableBundle;
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

    private double valueToConvert;
    private double currency = 0;

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
            this.valueToConvert = Double.parseDouble(editTextValueToConvert.getText().toString());
            this.currency = 0;
            String currencyText = "";
            switch (v.getId()){
                case R.id.buttonAmericanDollar:
                    double dollar = 3100;
                    currency = dollar * valueToConvert;
                    currencyText = buttonAmericanDollar.getText().toString();
                    break;
                case R.id.buttonEuro:
                    double euro = 3200;
                    currency = euro * valueToConvert;
                    currencyText = buttonAmericanDollar.getText().toString();
                    break;
            }
            textViewResult.setText(String.valueOf(currency));
            textViewCurrency.setText(currencyText);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putDouble("KEY_RESULT", this.valueToConvert);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.valueToConvert = savedInstanceState.getDouble("KEY_RESULT");
        textViewResult.setText(String.valueOf(valueToConvert));
    }
}
