package com.example.jose.eduticnowmaquetado;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FacebookActivity extends AppCompatActivity {

    private  Configuration config;
    String fontPath = "fonts/HelveticaNeue.ttf";
    Button btnsignup;
    CheckBox chkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_facebook);
        //REMOVE TITLE AND FULLSCREEN enable
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        iniciarConfig();

        //Relative Layout General
        RelativeLayout rlayoutG = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rlayoutG.setLayoutParams(params);
        Drawable d = new BitmapDrawable(config.escalarImagen("icons/bfondo.PNG",768,1024));
        rlayoutG.setBackground(d);

        //Params Linear
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        //Button Login
        LinearLayout linearlogin = new LinearLayout(this);
        linearlogin.setOrientation(LinearLayout.HORIZONTAL);
        linearlogin.setLayoutParams(params1);
        linearlogin.setGravity(Gravity.RIGHT);
        Button btnLogin = new Button(this);
        btnLogin.setBackground(new BitmapDrawable(config.escalarImagen("icons/login.png",config.getWidth(210),config.getHeight(60))));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funLogin();
            }
        });
        linearlogin.addView(btnLogin);

        //Colocar Logo
        LinearLayout linearlogo = new LinearLayout(this);
        linearlogo.setOrientation(LinearLayout.VERTICAL);
        linearlogo.setLayoutParams(params1);
        ImageView logo = new ImageView(this);
        logo.setImageBitmap(config.escalarImagen("icons/logo2.png", config.getWidth(317), config.getHeight(70)));
        linearlogo.addView(logo);

        //Linear Layout General
        LinearLayout linearGeneral = layoutcontext(this);

        //Linear Layout Term use- Sign up- facebook
        LinearLayout linearSignup = new LinearLayout(this);
        linearSignup.setOrientation(LinearLayout.VERTICAL);
        linearSignup.setLayoutParams(params1);
        linearSignup.setGravity(Gravity.CENTER);

        //Linear Layout Term of Use
        LinearLayout linearTermUse = new LinearLayout(this);
        linearTermUse.setOrientation(LinearLayout.HORIZONTAL);
        linearTermUse.setGravity(Gravity.CENTER_HORIZONTAL);

        chkLogin = new CheckBox(this);
        chkLogin.setBackground(new BitmapDrawable(config.escalarImagen("icons/toregister.png", config.getWidth(47), config.getHeight(47))));
        chkLogin.setChecked(false);
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);
        TextView textacept = new TextView(this);
        textacept.setTextSize(config.getHeight(17));
        textacept.setTypeface(tf);
        textacept.setTextColor(Color.parseColor("#ffffff"));
        textacept.setText(" TO REGISTER ACCEPT THE ");
        TextView textTerm = new TextView(this);
        textTerm.setTextSize(config.getHeight(15));
        textTerm.setTypeface(tf);
        textTerm.setTextColor(Color.parseColor("#00c6ff"));
        textTerm.setText("TERMS OF USE");
        linearTermUse.addView(chkLogin);
        linearTermUse.addView(textacept);
        linearTermUse.addView(textTerm);

        LinearLayout linearbtnsignup = new LinearLayout(this);
        linearbtnsignup.setLayoutParams(params1);
        linearbtnsignup.setPadding(0, config.getHeight(25), 0, 0);
        linearbtnsignup.setGravity(Gravity.CENTER_HORIZONTAL);
        btnsignup = new Button(this);
        btnsignup.setBackground(new BitmapDrawable(config.escalarImagen("icons/signupnolisto.png", config.getWidth(507), config.getHeight(80))));
        chkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkLoginFunction(chkLogin);
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funRegister();
            }
        });
        linearbtnsignup.addView(btnsignup);

        LinearLayout linearbtnface = new LinearLayout(this);
        linearbtnface.setLayoutParams(params1);
        linearbtnface.setPadding(0, config.getHeight(25), 0, 0);
        linearbtnface.setGravity(Gravity.CENTER_HORIZONTAL);
        Button btnfaceb = new Button(this);
        btnfaceb.setBackground(new BitmapDrawable(config.escalarImagen("icons/signupface.png",config.getWidth(507),config.getHeight(80))));
        linearbtnface.addView(btnfaceb);

        linearSignup.addView(linearTermUse);
        linearSignup.addView(linearbtnsignup);
        linearSignup.addView(linearbtnface);

        linearlogin.setX(0);linearlogin.setY(config.getHeight(30));
        linearlogo.setX(0);linearlogo.setY(config.getHeight(447));
        linearGeneral.setX(0);linearGeneral.setY(config.getHeight(557));
        linearSignup.setX(0);linearSignup.setY(config.getHeight(785));

        rlayoutG.addView(linearlogin);
        rlayoutG.addView(linearlogo);
        rlayoutG.addView(linearGeneral);
        rlayoutG.addView(linearSignup);

        setContentView(rlayoutG);
    }

    public void iniciarConfig(){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        int w = displayMetrics.widthPixels;
        int h = displayMetrics.heightPixels;
        config = new Configuration(w,h, this);
    }

    public LinearLayout layoutcontext(Context contexto){
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout linearGeneral = new LinearLayout(contexto);
        linearGeneral.setOrientation(LinearLayout.VERTICAL);
        linearGeneral.setLayoutParams(params1);
        //Text View Context
        String listcontext[] = {"Connect ","whit your classmates", "Get help ","on homework", "Get better graces ","for real"};
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);
        TextView context[] = new TextView[6];
        for (int i=0;i<listcontext.length;i++){
            TextView tmp = new TextView(contexto);
            tmp.setText(listcontext[i]);
            tmp.setTypeface(tf);
            tmp.setTextSize(config.getHeight(20));
            if (i%2==0) tmp.setTextColor(Color.parseColor("#00c6ff"));
            else tmp.setTextColor(Color.parseColor("#ffffff"));
            context[i]=tmp;
        }
        //Linear Layout Context
        for (int i=0;i<listcontext.length;i+=2){
            LinearLayout linearcontext = new LinearLayout(contexto);
            linearcontext.setOrientation(LinearLayout.HORIZONTAL);
            linearcontext.setGravity(Gravity.CENTER_HORIZONTAL);
            linearcontext.setLayoutParams(params1);
            linearcontext.addView(context[i]);
            linearcontext.addView(context[i + 1]);
            linearGeneral.addView(linearcontext);
        }
        return linearGeneral;
    }

    public void chkLoginFunction(CheckBox chkb){
        if (chkb.isChecked()) {
            btnsignup.setBackground(new BitmapDrawable(config.escalarImagen("icons/signuplisto.png", config.getWidth(507), config.getHeight(80))));
        }else{
            btnsignup.setBackground(new BitmapDrawable(config.escalarImagen("icons/signupnolisto.png", config.getWidth(507), config.getHeight(80))));
        }
    }

    public void funLogin(){
        Intent intent = new Intent(FacebookActivity.this,LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void funRegister(){
        if(chkLogin.isChecked()){
            Intent intent = new Intent(FacebookActivity.this,RegisterActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
