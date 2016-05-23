package com.example.jose.eduticnowmaquetado;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.squareup.picasso.Picasso;

public class NavigatorMapas extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LayoutInflater inflater;
    RelativeLayout contenedor;
    private TextView nickname;
    private ImageView imagen;

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_navigator_mapas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Inicializando */
        contenedor = (RelativeLayout)findViewById(R.id.id_relativel);
        inflater = LayoutInflater.from(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Ini_addCalificaciones();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Inicializamos mapa como primera vista
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.contend_frame,new MapaBusqueda()).commit();
        hide_Btn_AddCalific(false);

        View header = navigationView.getHeaderView(0);
        /*nickname = (TextView) header.findViewById(R.id.nicknameView);
        nickname.setText(Profile.getCurrentProfile().getName());
        imagen = (ImageView) header.findViewById(R.id.imagenView);
        Picasso.with(getApplicationContext())
                .load("https://graph.facebook.com/" + Profile.getCurrentProfile().getId()+ "/picture?type=small")
                .into(imagen);*/


        if (Profile.getCurrentProfile() != null) {
            Log.e("Mensaje", Profile.getCurrentProfile().getName());
            /*Picasso.with(getApplicationContext())
                    .load("https://graph.facebook.com/" + Profile.getCurrentProfile().getId() + "/picture?type=small")
                    .into(imagen);*/
            nickname = (TextView) header.findViewById(R.id.nicknameView);
            nickname.setText(Profile.getCurrentProfile().getName());
            imagen = (ImageView) header.findViewById(R.id.imagenView);
            Picasso.with(getApplicationContext())
                    .load("https://graph.facebook.com/" + Profile.getCurrentProfile().getId()+ "/picture?type=small")
                    .into(imagen);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigator_mapas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fm = getFragmentManager();

        int id = item.getItemId();

        if (id == R.id.nav_cuenta) {
            //
        } else if (id == R.id.nav_rutas) {
            //cargar_buscarRuta();
            fm.beginTransaction().replace(R.id.contend_frame,new MapaBusqueda()).commit();
            getWindow().setTitle("Mis Rutas");
            hide_Btn_AddCalific(false);
        } else if (id == R.id.nav_calificaciones) {
            cargar_mapaGeneral();

        } else if (id == R.id.nav_configuracion) {

        } else if (id == R.id.nav_ayuda) {

        } else if (id == R.id.nav_about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public  void cargar_buscarRuta(){
        contenedor.removeAllViews();
        inflater.inflate(R.layout.buscar_ruta, contenedor, true);
    }

    public  void cargar_mapaGeneral(){
        contenedor.removeAllViews();
        inflater.inflate(R.layout.mapa_general, contenedor, true);
    }

    //Facebook Function
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    //Ocultamos el boton
    public void hide_Btn_AddCalific(boolean hide)
    {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        if(hide){
            fab.setVisibility(View.INVISIBLE);
        }else{
            fab.setVisibility(View.VISIBLE);
        }
    }

    //MIS FUNCIONES
    //Inicializamos mapa para calificaciones
    public  void Ini_addCalificaciones()
    {
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.contend_frame,new AddQualification()).commit();
        getWindow().setTitle("Añadir una Zona");
        hide_Btn_AddCalific(true);
    }
}
