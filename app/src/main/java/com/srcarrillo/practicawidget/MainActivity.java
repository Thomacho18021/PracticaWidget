package com.srcarrillo.practicawidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    private boolean RadioOk = false;
    private String rbSelect;
    private String cbSelect;

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
                    rbSelect = "Si";


                }else{
                    cbNunca.setEnabled(false);
                    cbNunca.setChecked(false);
                    cbAVeces.setEnabled(false);
                    cbAVeces.setChecked(false);
                    cbSiempre.setEnabled(false);
                    cbSiempre.setChecked(false);
                    ratingBar.setRating(0);
                    ratingBar.setEnabled(false);
                    btnEnviar.setEnabled(true);
                    rbSelect = "No";

                }RadioOk=true;
                if (NombreOK == true){
                    btnEnviar.setEnabled(true);
                }
            }
        });

        etNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() < 3){
                    etNombre.setError("Nombre Corto, Mínimo 3 caracteres");
                    NombreOK = false;
                    btnEnviar.setEnabled(false);

                }else{
                    NombreOK = true;
                    if (RadioOk == true){
                        btnEnviar.setEnabled(true);

                    }

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
    public void Enviar (View view){
        String nombre = etNombre.getText().toString().trim();

        if(rbSelect == "Si"){
            if (cbNunca.isChecked()==true){
                cbSelect = "Nunca";
                Toast.makeText(this, "Gracias "+nombre+"\n"+rbSelect + " te gusta Pepsi\n"+cbSelect+" Consumes Pepsi\n"+ratingBar.getRating()+" Estrellas", Toast.LENGTH_LONG).show();

            }else if(cbAVeces.isChecked()==true){
                cbSelect = "A veces";
                Toast.makeText(this, "Gracias "+nombre+"\n"+rbSelect + " te gusta Pepsi\n"+cbSelect+" Consumes Pepsi\n"+ratingBar.getRating()+" Estrellas", Toast.LENGTH_LONG).show();

            }else if(cbSiempre.isChecked()==true){
                cbSelect = "Siempre";
                Toast.makeText(this, "Gracias "+nombre+"\n"+rbSelect + " te gusta Pepsi\n"+cbSelect+" Consumes Pepsi\n"+ratingBar.getRating()+" Estrellas", Toast.LENGTH_LONG).show();

            }else{
                txtCheckBox.setError("No haz seleccionado una opcion");
                return;
            }
        }else{
            Toast.makeText(MainActivity.this, "Gracias por Colaborar", Toast.LENGTH_LONG ).show();
        }
}}