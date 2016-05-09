package com.example.jose.eduticnowmaquetado;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Type;

public class LoginActivity extends AppCompatActivity {

    Configuration config;
    LinearLayout mainLayout;
    LinearLayout linearGeneral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        //REMOVE TITLE AND FULLSCREEN enable
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        iniciarConfig();

        funMainLayout();
    }

    public void iniciarConfig(){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        int w = displayMetrics.widthPixels;
        int h = displayMetrics.heightPixels;
        config = new Configuration(w,h, this);
    }

    public void funMainLayout(){
        mainLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mainLayout.setLayoutParams(params);
        mainLayout.setPadding(config.getWidth(30), config.getHeight(75), config.getWidth(30), config.getHeight(30));
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER_VERTICAL);
        mainLayout.setBackgroundColor(Color.WHITE);

        funLinearGeneral();

        setContentView(mainLayout);
    }

    public void funLinearGeneral(){
        ImageView logo = new ImageView(this);
        logo.setImageBitmap(config.escalarImagen("icons/logo2.png", config.getWidth(500), config.getHeight(82)));

        mainLayout.addView(logo);

        linearGeneral = new LinearLayout(this);
        linearGeneral.setOrientation(LinearLayout.VERTICAL);
        linearGeneral.setPadding(config.getWidth(100), config.getHeight(155), config.getWidth(100), config.getHeight(30));

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");

        TextView textIniSesion = new TextView(this);
        textIniSesion.setPadding(0, 0, 0, config.getHeight(35));
        textIniSesion.setText("INICIAR SESIÓN");
        textIniSesion.setTextColor(Color.BLACK);
        textIniSesion.setTypeface(tf);
        textIniSesion.setTextSize(config.getHeight(20));

        EditText correo = new EditText(this);
        correo.setHint("Correo Electrónico");
        correo.setSingleLine(true);
        correo.setTypeface(tf);
        correo.setTextSize(config.getHeight(20));
        correo.setTextColor(Color.BLACK);
        correo.setHintTextColor(Color.parseColor("#BDBDBD"));

        EditText editPass = new EditText(this);
        editPass.setHint("Contraseña");
        editPass.setSingleLine(true);
        editPass.setTypeface(tf);
        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editPass.setTextSize(config.getHeight(20));
        editPass.setTextColor(Color.BLACK);
        editPass.setHintTextColor(Color.parseColor("#BDBDBD"));

        linearGeneral.addView(textIniSesion);
        linearGeneral.addView(correo);
        linearGeneral.addView(editPass);

        LinearLayout contentButton = new LinearLayout(this);
        contentButton.setPadding(0, config.getHeight(65), 0, 0);
        contentButton.setOrientation(LinearLayout.HORIZONTAL);
        contentButton.setGravity(Gravity.CENTER_HORIZONTAL);
        Button btn_crearC = new Button(this);
        btn_crearC.setTextColor(Color.WHITE);
        btn_crearC.setText("ENTRAR");
        btn_crearC.setTextSize(config.getHeight(20));
        btn_crearC.setBackgroundColor(Color.parseColor("#E53935"));
        btn_crearC.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        btn_crearC.setPadding(config.getWidth(65), 0, config.getWidth(65), 0);
        btn_crearC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherfunLogin();
            }
        });

        contentButton.addView(btn_crearC);

        linearGeneral.addView(contentButton);

        mainLayout.addView(linearGeneral);

        /*linearGeneral = new LinearLayout(this);
        linearGeneral.setOrientation(LinearLayout.VERTICAL);

        TextView textIniSesion = new TextView(this);
        textIniSesion.setText("Iniciar Sesión");
        textIniSesion.setTextColor(Color.parseColor("#ffffff"));
        textIniSesion.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeue.ttf"));
        textIniSesion.setTextSize(config.getHeight(20));

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");
        Drawable d = new BitmapDrawable(config.escalarImagen("icons/cajatexto.png", config.getWidth(507), config.getHeight(80)));
        EditText editUser = new EditText(this);
        editUser.setHint("Usuario");
        editUser.setSingleLine(true);
        editUser.setTypeface(tf);
        editUser.setTextSize(config.getHeight(20));
        editUser.setTextColor(Color.WHITE);editUser.setHintTextColor(Color.parseColor("#BDBDBD"));
        editUser.setBackground(d);
        editUser.setLayoutParams(new ViewGroup.LayoutParams(config.getWidth(507), config.getHeight(78)));
        editUser.setPadding(config.getWidth(25), 0, 0, 0);

        LinearLayout linearSpace = new LinearLayout(this);
        linearSpace.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 20));

        EditText editPass = new EditText(this);
        editPass.setHint("Contraseña");
        editPass.setSingleLine(true);
        editPass.setTypeface(tf);
        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editPass.setTextSize(config.getHeight(20));
        editPass.setTextColor(Color.WHITE);editPass.setHintTextColor(Color.parseColor("#BDBDBD"));
        editPass.setBackground(d);
        editPass.setLayoutParams(new ViewGroup.LayoutParams(config.getWidth(507), config.getHeight(78)));
        editPass.setPadding(config.getWidth(25), 0, 0, 0);

        linearGeneral.addView(editUser);
        linearGeneral.addView(linearSpace);
        linearGeneral.addView(editPass);

        ImageButton btnLoginInto = new ImageButton(this);
        btnLoginInto.setBackground(new BitmapDrawable(config.escalarImagen("icons/otherlogin.png", config.getWidth(242), config.getHeight(78))));
        btnLoginInto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherfunLogin();
            }
        });

        LinearLayout linearText = new LinearLayout(this);
        linearText.setOrientation(LinearLayout.VERTICAL);
        TextView textForgot = new TextView(this);
        textForgot.setText("FORGOT PASSWORD?");
        textForgot.setTextSize(config.getHeight(20));
        textForgot.setTextColor(Color.WHITE);
        textForgot.setTypeface(tf);
        TextView textChange = new TextView(this);
        textChange.setText("CHANGE");
        textChange.setTextSize(config.getHeight(20));
        textChange.setGravity(Gravity.CENTER_HORIZONTAL);
        textChange.setTextColor(Color.parseColor("#00c6ff"));
        textChange.setTypeface(tf);

        linearText.addView(textForgot);
        linearText.addView(textChange);

        textIniSesion.setX(config.getWidth(75));textIniSesion.setY(config.getHeight(680));
        linearGeneral.setX(config.getWidth(75));linearGeneral.setY(config.getHeight(741));
        btnLoginInto.setX(config.getWidth(75));btnLoginInto.setY(config.getHeight(980));
        linearText.setX(config.getWidth(345)); linearText.setY(config.getHeight(980));

        mainLayout.addView(textIniSesion);
        mainLayout.addView(linearGeneral);
        mainLayout.addView(btnLoginInto);
        mainLayout.addView(linearText);*/
    }


    public void otherfunLogin(){
        Intent intent = new Intent(LoginActivity.this,NavigatorMapas.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
