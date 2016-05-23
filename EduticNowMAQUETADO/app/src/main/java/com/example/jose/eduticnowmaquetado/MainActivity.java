package com.example.jose.eduticnowmaquetado;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //printHashKey();
        //REMOVE TITLE AND FULLSCREEN enable
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        iniciarConfig();

        //Relative Layout General
        RelativeLayout rlayoutG = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rlayoutG.setLayoutParams(params);
        Drawable d = new BitmapDrawable(config.escalarImagen("icons/empresa2.jpg",768,1024));
        rlayoutG.setBackground(d);

        //Params Linear
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        setContentView(rlayoutG);

        splashScreen();
    }

    public void iniciarConfig(){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        int w = displayMetrics.widthPixels;
        int h = displayMetrics.heightPixels;
        config = new Configuration(w,h, this);
    }

    //Paso automatico de un activity a otro, con animacion
    public  void splashScreen(){
        Thread t=new Thread()
        {
            public void run()
            {
                try {
                    sleep(2000);
                    finish();
                    Intent cv=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(cv);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public void printHashKey()
    {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.joselhm.test_facebookapi",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
