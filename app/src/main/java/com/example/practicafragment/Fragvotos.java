package com.example.practicafragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Fragvotos extends Fragment {

    private int PVoto1;
    private int PVoto2;


    TextView rvoto1, rvoto2;
    EditText v1;
    Button borrar;

    int contador = 0;


    public Fragvotos() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            PVoto1 = getArguments().getInt("dato1");
            PVoto2 = getArguments().getInt("dato2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(PVoto1==PVoto2){
            Toast.makeText(getContext(),  PVoto1 + "" +"Votos"+ "=" + PVoto2 + "" + "Votos" + "\n"+"Los Votos Son Iguales", Toast.LENGTH_SHORT).show();
        }
        else if(PVoto1>PVoto2){
            Toast.makeText(getContext(),PVoto1+ "Pelicula 1 es el ganador", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(),PVoto2+"Pelicula 2 es el ganador", Toast.LENGTH_SHORT).show();
        }

        //Toast.makeText(getContext(), PVoto1 +  "voto1 ", Toast.LENGTH_SHORT).show();
        //super.onCreateView(inflater, container, savedInstanceState);
        //View v =  inflater.inflate(R.layout.fragment_fragvotos, container, false);
        //if(v != null){
        //    rvoto1= (TextView)v.findViewById(R.id.contenido1);
        //    rvoto1.setText("dato1");


        //}
        //return v;
        //v1.setText(String.valueOf(""));
        //View main = inflater.inflate(R.layout.fragment_fragvotos, container, false);
        //if(main!= null){

        //    v1 = (EditText) main.findViewById(R.id.dato1);
        //    v1.setText(String.valueOf("El valor es:" + PVoto1));
        //}
        //return main;
        return inflater.inflate(R.layout.fragment_fragvotos, container, false);
    }

    public interface OnFragmentInteractionListener {
    }
}