package com.example.practicafragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements Fragvotos.OnFragmentInteractionListener, Fragpeliculauno.OnFragmentInteractionListener, Fragpeliculados.OnFragmentInteractionListener{

    TextView voto1, voto2;
    Button calcular, limpiar;
    Fragvotos fragmentvoto;
    Fragpeliculauno fragmentuno;
    Fragpeliculados fragmentdos;
    FrameLayout hola;

    RadioGroup radioGroup;
    RadioButton rd1, rd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voto1 = (TextView)findViewById(R.id.pelicula1);
        voto2 = (TextView)findViewById(R.id.pelicula2);

        calcular =(Button)findViewById(R.id.calcular);
        limpiar = (Button)findViewById(R.id.btnlimpiar);
        hola = (FrameLayout)findViewById(R.id.resultado);

        fragmentvoto =  new Fragvotos();
        fragmentuno = new Fragpeliculauno();
        fragmentdos = new Fragpeliculados();
        radioGroup = findViewById(R.id.radioGroup1);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.commit();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fragmentvoto = new Fragvotos();
                Random rand = new Random();
                int number1 = rand.nextInt(10) +1;
                int number2 = rand.nextInt(10) +1;
                voto1.setText(String.valueOf("LOS VOTOS DE LA PELICULA 1 ES" + "====" + number1));
                voto2.setText(String.valueOf("LOS VOTOS DE LA PELICULA 2 ES" + "====" + number2));

                //if(number1==number2){
                //    Toast.makeText(MainActivity.this,  "votos Son Iguales", Toast.LENGTH_SHORT).show();
                //}
                //else if(number1>number2){
                //    Toast.makeText(MainActivity.this,number1+ "Pelicula 1 es el ganador", Toast.LENGTH_SHORT).show();
                //}else{
                //    Toast.makeText(MainActivity.this,number2+"Pelicula 2 es el ganador", Toast.LENGTH_SHORT).show();
                //}

                Bundle bundle = new Bundle();
                bundle.putInt("dato1", number1);
                bundle.putInt("dato2", number2);

                fragmentvoto.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.resultado, fragmentvoto);
                fragmentTransaction.commit();

            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });



    }

    public void optionuno(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();
        //titulo = findViewById(R.id.titulocomedi);
        rd1 = findViewById(R.id.radioButton1);
        rd2 = findViewById(R.id.radioButton2);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.commit();

        if(rd1.isChecked()==true){
            fragmentTransaction.replace(R.id.resultado, fragmentuno);
        } else {
            fragmentTransaction.replace(R.id.resultado, fragmentvoto);
        }
    }

    public void optiondos(View view){

        int radioId = radioGroup.getCheckedRadioButtonId();
        //titulo = findViewById(R.id.titulo);
        rd1 = findViewById(R.id.radioButton1);
        rd2 = findViewById(R.id.radioButton2);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.commit();

        if(rd2.isChecked()==true){
            //titulo.setText(R.string.title2);
            fragmentTransaction.replace(R.id.resultado, fragmentdos);
        }
        else {
            fragmentTransaction.replace(R.id.resultado, fragmentuno);
        }

    }
}