package com.example.jose.eduticnowmaquetado;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by JoseLHM on 08/05/2016.
 */
public class MapaBusqueda extends Fragment implements OnMapReadyCallback {

    List<Zona> list_zonas;
    List<String> list_colores;
    List<String> list_colores_center;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstancestate)
    {
        return  inflater.inflate(R.layout.map_busqueda_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.mapB);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        int zoom_ = 10;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-16.3988889, -71.535);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Tu estas aqui"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoom_));

        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(zoom_ + 5), 2000, null);

        //ADD CIRCLES
        test_fill_zonas();
        fill_colores();
        for(int i=0;i<list_zonas.size();i++){
            googleMap.addCircle(new CircleOptions()
                    .center(new LatLng(list_zonas.get(i).getLatitud(), list_zonas.get(i).getLongitud()))
                    .radius(list_zonas.get(i).getRadio_())
                    .strokeColor(Color.parseColor(list_colores.get(list_zonas.get(i).nivel)))
                    .fillColor(Color.parseColor(list_colores_center.get(list_zonas.get(i).nivel))));
        }
    }

    public void test_fill_zonas()
    {
        list_zonas = new ArrayList<Zona>();
        list_zonas.add(new Zona(-16.4548539,-71.5405225,70,"Zona1",2));
        list_zonas.add(new Zona(-16.4513143,-71.5269613,90,"Zona2",1));
        list_zonas.add(new Zona(-16.4331215, -71.5361452, 110, "Zona3", 1));
        list_zonas.add(new Zona(-16.4290052, -71.5222406, 70, "Zona4", 2));
        list_zonas.add(new Zona(-16.4164912, -71.5395784, 160, "Zona5", 1));
        list_zonas.add(new Zona(-16.4008476,-71.5428400,84,"Zona6",2));

    }

    public void fill_colores()
    {
        list_colores = new ArrayList<String>();
        list_colores_center = new ArrayList<String>();

        list_colores.add("#FFE57F");
        list_colores.add("#FFD180");
        list_colores.add("#EF9A9A");

        list_colores_center.add("#FFAB00");
        list_colores_center.add("#E65100");
        list_colores_center.add("#B71C1C");
    }
}
