package com.example.aula01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    double valorDolar = 5.17;
    double valorEuro = 5.47;

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

    public void ConverterValores(View view){
        EditText edtValorEntrada;
        TextView txtValorSaidaDolar, txtValorSaidaEuro;

        edtValorEntrada = findViewById(R.id.edtValorReal);
        txtValorSaidaDolar = findViewById(R.id.txtValorDolar);
        txtValorSaidaEuro = findViewById(R.id.txtValorEuro);

        double valorEmReais = Double.parseDouble(edtValorEntrada.getText().toString());

        double auxiliar = valorEmReais / valorDolar;
        txtValorSaidaDolar.setText("U$: " + String.format("%.2f",auxiliar));

        auxiliar = valorEmReais / valorEuro;
        txtValorSaidaEuro.setText("E$: " + String.format("%.2f",auxiliar));

    }
}