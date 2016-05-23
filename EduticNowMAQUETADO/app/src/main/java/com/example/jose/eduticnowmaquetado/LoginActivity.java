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

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.lang.reflect.Type;
import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    Configuration config;
    LinearLayout mainLayout;
    LinearLayout linearGeneral;

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);

        if (Profile.getCurrentProfile() != null) {//Si se inicio session abre el nuevo activity

            Intent intent = new Intent(LoginActivity.this,NavigatorMapas.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
        //REMOVE TITLE AND FULLSCREEN enable
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "user_friends", "email", "pages_messaging", "user_birthday"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
                ProfileTracker profileTracker = new ProfileTracker() {//Actualiza el Profile
                    @Override
                    protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                        this.stopTracking();
                        Profile.setCurrentProfile(currentProfile);

                        Intent intent = new Intent(LoginActivity.this, NavigatorMapas.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                };
                profileTracker.startTracking();

            }

            @Override
            public void onCancel() {
                //info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                //info.setText("Login attempt failed.");
            }
        });

        iniciarConfig();
        funMainLayout();
    }


    public void otherfunLogin(){
        Intent intent = new Intent(LoginActivity.this,NavigatorMapas.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        //finish();
    }

    public void funRegister(){
        //if(chkLogin.isChecked()){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        //finish();
        //}
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    //MIS FUNCIONES

    public void iniciarConfig(){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        int w = displayMetrics.widthPixels;
        int h = displayMetrics.heightPixels;
        config = new Configuration(w,h, this);
    }

    public void funMainLayout(){
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        mainLayout.setPadding(config.getWidth(30), config.getHeight(75), config.getWidth(30), config.getHeight(30));
        mainLayout.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);
        mainLayout.setBackgroundColor(Color.WHITE);

        funLinearGeneral();
    }

    public void funLinearGeneral() {
        ImageView logo = (ImageView)findViewById(R.id.logo_);
        logo.setImageBitmap(config.escalarImagen("icons/logo2.png", config.getWidth(500), config.getHeight(82)));

        linearGeneral = (LinearLayout)findViewById(R.id.linear_general);
        linearGeneral.setPadding(config.getWidth(100), config.getHeight(155), config.getWidth(100), config.getHeight(30));

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLight.ttf");

        TextView textIniSesion = (TextView)findViewById(R.id.text_inisesion);
        textIniSesion.setPadding(0, 0, 0, config.getHeight(35));
        textIniSesion.setText("INICIAR SESIÓN");
        textIniSesion.setTextColor(Color.BLACK);
        textIniSesion.setGravity(Gravity.CENTER_HORIZONTAL);
        textIniSesion.setTypeface(tf);
        textIniSesion.setTextSize(config.getHeight(20));

        EditText correo = (EditText)findViewById(R.id.edit_email);
        correo.setHint("Correo Electrónico");
        correo.setSingleLine(true);
        correo.setTypeface(tf);
        correo.setTextSize(config.getHeight(20));
        correo.setTextColor(Color.BLACK);
        correo.setHintTextColor(Color.parseColor("#BDBDBD"));

        EditText editPass = (EditText)findViewById(R.id.edit_pass);
        editPass.setHint("Contraseña");
        editPass.setSingleLine(true);
        editPass.setTypeface(tf);
        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        editPass.setTextSize(config.getHeight(20));
        editPass.setTextColor(Color.BLACK);
        editPass.setHintTextColor(Color.parseColor("#BDBDBD"));

        Button btn_crearC = (Button)findViewById(R.id.btn_iniSesion);
        btn_crearC.setTextColor(Color.WHITE);
        btn_crearC.setText("Iniciar Sesión");
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

        TextView text_infosesion = (TextView)findViewById(R.id.text_tamb_inisesion);
        text_infosesion.setPadding(0, config.getHeight(35), 0, config.getHeight(35));
        text_infosesion.setText("Tambien puedes iniciarcsesión usando:");
        text_infosesion.setTextColor(Color.parseColor("#616161"));
        text_infosesion.setTypeface(tf);
        text_infosesion.setTextSize(config.getHeight(18));
        text_infosesion.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView text_registro1 = (TextView)findViewById(R.id.text_sinoReg);
        text_registro1.setPadding(0, config.getHeight(35), 0, config.getHeight(35));
        text_registro1.setText("Si no estas registrado,");
        text_registro1.setTextColor(Color.parseColor("#616161"));
        text_registro1.setTypeface(tf);
        text_registro1.setTextSize(config.getHeight(18));
        text_registro1.setGravity(Gravity.RIGHT);

        TextView text_registro2 = (TextView)findViewById(R.id.text_registr);
        text_registro2.setPadding(0, config.getHeight(35), 0, config.getHeight(35));
        text_registro2.setText("registrate aqui!");
        text_registro2.setTextColor(Color.parseColor("#F44336"));
        text_registro2.setTypeface(tf);
        text_registro2.setTextSize(config.getHeight(18));
        text_registro2.setGravity(Gravity.LEFT);
        text_registro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funRegister();
            }
        });
    }
}
