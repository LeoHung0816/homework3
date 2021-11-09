package com.example.androidstudio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {

    RadioGroup unit;
    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit = findViewById(R.id.unit);
        unit.setOnCheckedChangeListener(this);

        value = findViewById(R.id.value);
        value.addTextChangedListener(this);
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }
    @Override
    public void afterTextChanged(Editable editable) {
        calc();
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        calc();
    }

    private void calc() {
        TextView degF = findViewById(R.id.degF);
        TextView degC = findViewById(R.id.degC);

        double f, c;
        if (unit.getCheckedRadioButtonId() == R.id.unitF) {
            if (value.getText().toString().length() ==0)
                return;
            else {
                f = Double.parseDouble(value.getText().toString());
                c = (f - 32) * 5 / 9;
            }
        } else {
            if (value.getText().toString().length() ==0)
                return;
            else {
                c = Double.parseDouble(value.getText().toString());
                f = c * 9 / 5 + 32;}
        }
        degC.setText(String.format("%.1f", c) + getResources().getString(R.string.charC));
        degF.setText(String.format("%.1f", f) + getResources().getString(R.string.charF));

    }
}