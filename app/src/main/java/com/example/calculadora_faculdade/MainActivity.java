package com.example.calculadora_faculdade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String primeiroNumero = "";
    String operador = "*";
    boolean novoOperador = true;
    private TextView texto;
    private Button  btnCancel, btnMultiplicar, btnDividir, btnSubtrair, btnSete, btnOito, btnNove, btnSomar, btnQuatro, btnCinco, btnSeis, btnUm, btnDois, btnTres, btnIgual, btnZero, btnPonto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //passando os IDs dos botões
        texto = findViewById(R.id.text); //Textview que vai aparecer os números

        //botões de ação
        btnCancel = findViewById(R.id.btnCancel);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnSubtrair = findViewById(R.id.btnSubtrair);
        btnSete = findViewById(R.id.btnSete);
        btnOito = findViewById(R.id.btnOito);
        btnNove = findViewById(R.id.btnNove);
        btnSomar = findViewById(R.id.btnSomar);
        btnQuatro = findViewById(R.id.btnQuatro);
        btnCinco = findViewById(R.id.btnCinco);
        btnSeis = findViewById(R.id.btnSeis);
        btnUm = findViewById(R.id.btnUm);
        btnDois = findViewById(R.id.btnDois);
        btnTres = findViewById(R.id.btnTres);
        btnIgual = findViewById(R.id.btnIgual);
        btnZero = findViewById(R.id.btnZero);
        btnPonto = findViewById(R.id.btnPonto);
    }

    public void numberEvent(View view) {
        if(novoOperador)
            texto.setText("");
        novoOperador = false;
        String numero = texto.getText().toString();

        //switch que adiciona os números dos botões na tela
        switch (view.getId()) {
            case R.id.btnUm:
                numero += "1";
                break;
            case R.id.btnDois:
                numero += "2";
                break;
            case R.id.btnTres:
                numero += "3";
                break;
            case R.id.btnQuatro:
                numero += "4";
                break;
            case R.id.btnCinco:
                numero += "5";
                break;
            case R.id.btnSeis:
                numero += "6";
                break;
            case R.id.btnSete:
                numero += "7";
                break;
            case R.id.btnOito:
                numero += "8";
                break;
            case R.id.btnNove:
                numero += "9";
                break;
            case R.id.btnZero:
                numero += "0";
                break;
            case R.id.btnPonto:
                numero += ".";
                break;


        }
        texto.setText(numero); //mostra os números e pontos na tela
    }

    public void operatorEvent(View view) {
        novoOperador = true;
        primeiroNumero = texto.getText().toString();
        //switch que adiciona os operadores na tela
        switch (view.getId()) {
            case R.id.btnDividir: //pega pelo id do botão
                operador = "/";
                break;
            case R.id.btnMultiplicar:
                operador = "*";
                break;
            case R.id.btnSomar:
                operador = "+";
                break;
            case R.id.btnSubtrair:
                operador = "-";
                break;
        }

            }

    public void equalEvent(View view) {
        String segundoNumero = texto.getText().toString();
        double resultado = 0.0;
        //switch para fazer os cálculos baseado no operador escolhido
        switch(operador) {
            case "+":
                resultado = Double.parseDouble(primeiroNumero) + Double.parseDouble(segundoNumero);
                break;
            case "-":
                resultado = Double.parseDouble(primeiroNumero) - Double.parseDouble(segundoNumero);
                break;
            case "*":
                resultado = Double.parseDouble(primeiroNumero) * Double.parseDouble(segundoNumero);
                break;
            case "/":
                resultado = Double.parseDouble(primeiroNumero) / Double.parseDouble(segundoNumero);
                break;

        }
        texto.setText(resultado + ""); //mostra o resultado na tela
    }
    //função para apagar todas as contas e números digitados
    public void acEvent(View view) {
        texto.setText("0");
        novoOperador = true;
    }
}