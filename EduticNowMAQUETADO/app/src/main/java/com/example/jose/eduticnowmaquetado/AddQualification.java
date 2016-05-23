package com.example.jose.eduticnowmaquetado;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AddQualification extends Fragment implements OnMapReadyCallback {

    public Button btn_bajo;
    public Button btn_medio;
    public Button btn_alto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstancestate)
    {

        return  inflater.inflate(R.layout.activity_add_qualification,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Ini_botones_calificar();
        Ini_addDescription_pop();
        MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.mapCalification);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-16.3988889, -71.535);
        googleMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Tu estas aqui!!")
                .draggable(true));
        Circle circle = googleMap.addCircle(new CircleOptions()
                .center(sydney)
                .radius(10)
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));

        int zoom_ = 13;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoom_));

        // Zoom out to zoom level 13, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(zoom_ + 3), 2000, null);

    }

    //FUNCIONES DE CALIFICACION
    public void Ini_botones_calificar()
    {
        btn_bajo = (Button)getView().findViewById(R.id.btn_cal_bajo);
        btn_medio = (Button)getView().findViewById(R.id.btn_cal_medio);
        btn_alto = (Button)getView().findViewById(R.id.btn_cal_alto);

        btn_bajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_calif_Bajo();
            }
        });
        btn_medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_calif_Medio();
            }
        });
        btn_alto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_calif_Alto();
            }
        });
    }

    //Inicializamos la funcion de añadir descripcion - pop up
    public void Ini_addDescription_pop()
    {
        TextView addDescr = (TextView)getView().findViewById(R.id.pop_addDescription);
        addDescr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),PopAddQualification.class));
            }
        });
    }

    public void btn_calif_Bajo()
    {
        btn_bajo.setBackgroundColor(Color.parseColor(getString(R.string.color_bajo_sel)));
        btn_medio.setBackgroundColor(Color.parseColor(getString(R.string.color_medio)));
        btn_alto.setBackgroundColor(Color.parseColor(getString(R.string.color_alto)));

        btn_bajo.setTextColor(Color.parseColor(getString(R.string.color_bajo)));
        btn_medio.setTextColor(Color.parseColor(getString(R.string.color_medio_sel)));
        btn_alto.setTextColor(Color.parseColor(getString(R.string.color_alto_sel)));
    }
    public void btn_calif_Medio()
    {
        btn_bajo.setBackgroundColor(Color.parseColor(getString(R.string.color_bajo)));
        btn_medio.setBackgroundColor(Color.parseColor(getString(R.string.color_medio_sel)));
        btn_alto.setBackgroundColor(Color.parseColor(getString(R.string.color_alto)));

        btn_bajo.setTextColor(Color.parseColor(getString(R.string.color_bajo_sel)));
        btn_medio.setTextColor(Color.parseColor(getString(R.string.color_medio)));
        btn_alto.setTextColor(Color.parseColor(getString(R.string.color_alto_sel)));
    }
    public void btn_calif_Alto()
    {
        btn_bajo.setBackgroundColor(Color.parseColor(getString(R.string.color_bajo)));
        btn_medio.setBackgroundColor(Color.parseColor(getString(R.string.color_medio)));
        btn_alto.setBackgroundColor(Color.parseColor(getString(R.string.color_alto_sel)));

        btn_bajo.setTextColor(Color.parseColor(getString(R.string.color_bajo_sel)));
        btn_medio.setTextColor(Color.parseColor(getString(R.string.color_medio_sel)));
        btn_alto.setTextColor(Color.parseColor(getString(R.string.color_alto)));
    }
}
