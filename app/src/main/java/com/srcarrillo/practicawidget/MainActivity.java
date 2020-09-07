package com.srcarrillo.practicawidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    private ImageView imgLogo;
    private TextView txtNombre, txtRadioGroup, txtCheckBox, txtRatingBar, txtRatingBar1, txtRatingBar2;
    private EditText etNombre;
    private CheckBox cbNunca, cbAVeces, cbSiempre;
    private RadioGroup rgPregunta;
    private RatingBar ratingBar;
    private Button btnEnviar;
    private boolean NombreOK = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogo = findViewById(R.id.imgLogo);
        txtNombre = findViewById(R.id.txtNombre);
        txtRadioGroup = findViewById(R.id.txtRadioGroup);
        txtCheckBox = findViewById(R.id.txtCheckBox);
        txtRatingBar = findViewById(R.id.txtRatingBar);
        txtRatingBar1 = findViewById(R.id.txtRatingBar1);
        txtRatingBar2 = findViewById(R.id.txtRatingBar2);
        txtRadioGroup = findViewById(R.id.txtRadioGroup);
        etNombre = findViewById(R.id.etNombre);
        cbNunca = findViewById(R.id.cbNunca);
        cbAVeces = findViewById(R.id.cbAVeces);
        cbSiempre = findViewById(R.id.cbSiempre);
        rgPregunta = findViewById(R.id.rgPregunta);
        ratingBar = findViewById(R.id.ratingBar);
        btnEnviar = findViewById(R.id.btnEnviar);

        ratingBar.setEnabled(false);
        btnEnviar.setEnabled(false);
        cbNunca.setEnabled(false);
        cbAVeces.setEnabled(false);
        cbSiempre.setEnabled(false);

        rgPregunta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rbtnSi){
                    ratingBar.setEnabled(true);
                    cbNunca.setEnabled(true);
                    cbAVeces.setEnabled(true);
                    cbSiempre.setEnabled(true);


                }else{
                    cbNunca.setChecked(false);
                    cbAVeces.setChecked(false);
                    cbSiempre.setChecked(false);
                    ratingBar.setRating(0);
                    ratingBar.setEnabled(false);
                    btnEnviar.setEnabled(true);

                }if (NombreOK == true){
                    btnEnviar.setEnabled(true);
                }
            }
        });

        etNombre.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (etNombre.getText().toString().length()<3){
                    etNombre.setError("Nombre muy Corto");
                    btnEnviar.setEnabled(false);
                }else{
                    NombreOK = true;

                }
                return false;
            }
        });


    }
    public void Enviar (View view){
        Toast.makeText(this, "Gracias por Colaborar", Toast.LENGTH_LONG).show();
    }
}