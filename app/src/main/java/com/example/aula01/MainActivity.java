package com.example.aula01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    double valorDolar;
    double valorEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Converter(View view){
        RadioGroup valorGroup;

        valorGroup = findViewById(R.id.radioGroup);

        int selectedId = valorGroup.getCheckedRadioButtonId();

        RadioButton selectedRadioButton = findViewById(selectedId);
        String selectedValueMoeda = selectedRadioButton.getText().toString();

        if(selectedValueMoeda.equals("Euro")){
            ConverterEuro(view);
        } else if (selectedValueMoeda.equals("Dolar")) {
            ConverterDolar(view);
        } else {
            ConverterReal(view);
        }
    }

    public void ConverterReal(View view){
        valorDolar = 5.17;
        valorEuro = 5.47;

        EditText edtValorEntrada;
        TextView txtValorSaidaDolar, txtValorSaidaEuro, txtValorSaidaReal;

        edtValorEntrada = findViewById(R.id.edtValorReal);
        txtValorSaidaDolar = findViewById(R.id.txtValorDolar);
        txtValorSaidaEuro = findViewById(R.id.txtValorEuro);
        txtValorSaidaReal = findViewById(R.id.txtValoReal);

        double valorEmReais = Double.parseDouble(edtValorEntrada.getText().toString());

        double auxiliar = valorEmReais / valorDolar;
        txtValorSaidaDolar.setText("U$: " + String.format("%.2f",auxiliar));

        auxiliar = valorEmReais / valorEuro;
        txtValorSaidaEuro.setText("E$: " + String.format("%.2f",auxiliar));

        auxiliar = valorEmReais;
        txtValorSaidaReal.setText("R$: " + String.format("%.2f",auxiliar));

    }

    public void ConverterDolar(View view){
        valorDolar = 5.17;
        valorEuro = 0.94;

        EditText edtValorEntrada;
        TextView txtValorSaidaDolar, txtValorSaidaEuro, txtValorSaidaReal;

        edtValorEntrada = findViewById(R.id.edtValorReal);
        txtValorSaidaDolar = findViewById(R.id.txtValorDolar);
        txtValorSaidaEuro = findViewById(R.id.txtValorEuro);
        txtValorSaidaReal = findViewById(R.id.txtValoReal);

        double valorEmDolar = Double.parseDouble(edtValorEntrada.getText().toString());

        double auxiliar = valorEmDolar;
        txtValorSaidaDolar.setText("U$: " + String.format("%.2f",auxiliar));

        auxiliar = valorEmDolar / valorEuro;
        txtValorSaidaEuro.setText("E$: " + String.format("%.2f",auxiliar));

        auxiliar = valorEmDolar * valorDolar;
        txtValorSaidaReal.setText("R$: " + String.format("%.2f",auxiliar));

    }

    public void ConverterEuro(View view){
        valorDolar = 1.06;
        valorEuro = 5.47;

        EditText edtValorEntrada;
        TextView txtValorSaidaDolar, txtValorSaidaEuro, txtValorSaidaReal;

        edtValorEntrada = findViewById(R.id.edtValorReal);
        txtValorSaidaDolar = findViewById(R.id.txtValorDolar);
        txtValorSaidaEuro = findViewById(R.id.txtValorEuro);
        txtValorSaidaReal = findViewById(R.id.txtValoReal);

        double valorEmEuro = Double.parseDouble(edtValorEntrada.getText().toString());

        double auxiliar = valorEmEuro / valorDolar;
        txtValorSaidaDolar.setText("U$: " + String.format("%.2f",auxiliar));

        auxiliar = valorEmEuro;
        txtValorSaidaEuro.setText("E$: " + String.format("%.2f",auxiliar));

        auxiliar = valorEmEuro * valorEuro;
        txtValorSaidaReal.setText("R$: " + String.format("%.2f",auxiliar));

    }
}