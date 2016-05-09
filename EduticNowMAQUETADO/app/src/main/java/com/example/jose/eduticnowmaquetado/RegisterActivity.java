package com.example.jose.eduticnowmaquetado;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    Configuration config;
    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register);
        //REMOVE TITLE AND FULLSCREEN enable
        //this.getSupportActionBar().hide();
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("Registrate");
        iniciarConfig();

        iniciarMainLayout();
    }

    public void iniciarConfig(){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        int w = displayMetrics.widthPixels;
        int h = displayMetrics.heightPixels;
        config = new Configuration(w,h, this);
    }

    public void iniciarMainLayout(){
        mainLayout = new LinearLayout(this);
        mainLayout.setPadding(config.getWidth(50),config.getHeight(35),config.getWidth(50),config.getHeight(35));
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER_VERTICAL);
        mainLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        mainLayout.setBackgroundColor(Color.WHITE);

        funDentro();

        setContentView(mainLayout);
    }

    public void funDentro(){
        String listStringTitle[] = {"NOMBRES","APELLIDOS","CORREO ELECTRÓNICO","CONTRASEÑA"};
        String listStringHit[] = {"Nombres","Apellidos","Correo Electrónico","Contraseña"};

        List<TextView> listTitle = new ArrayList<TextView>();
        List<EditText> listHint= new ArrayList<EditText>();
        Typeface tf_ = Typeface.createFromAsset(getAssets(),"fonts/HelveticaNeue.ttf");
        for(int i=0;i<listStringTitle.length;i++){
            TextView tmp = new TextView(this);
            tmp.setText(listStringTitle[i]);
            tmp.setTextColor(Color.BLACK);
            tmp.setTextSize(config.getHeight(18));

            EditText tmpEdt = new EditText(this);
            tmpEdt.setHint(listStringHit[i]);
            tmpEdt.setSingleLine(true);
            tmpEdt.setTypeface(tf_);

            listTitle.add(tmp);
            listHint.add(tmpEdt);

            mainLayout.addView(tmp);
            mainLayout.addView(tmpEdt);
        }

        LinearLayout contentButton = new LinearLayout(this);
        contentButton.setPadding(0,config.getHeight(65),0,0);
        contentButton.setOrientation(LinearLayout.HORIZONTAL);
        contentButton.setGravity(Gravity.CENTER_HORIZONTAL);
        Button btn_crearC = new Button(this);
        btn_crearC.setTextColor(Color.WHITE);
        btn_crearC.setText("CREAR CUENTA");
        btn_crearC.setTextSize(config.getHeight(20));
        btn_crearC.setBackgroundColor(Color.parseColor("#E53935"));
        btn_crearC.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        contentButton.addView(btn_crearC);

        mainLayout.addView(contentButton);
/*
        TextView textRegistro = new TextView(this);
        textRegistro.setText("Registro");
        textRegistro.setTextColor(Color.WHITE);
        textRegistro.setTextSize(config.getHeight(25));

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/HelveticaNeue.ttf");
        Drawable d = new BitmapDrawable(config.escalarImagen("icons/cajatexto.png",config.getWidth(507),config.getHeight(80)));
        String listString[] = {"Nombre de Usuario","Dirección de correo","Contraseña"};
        for(int i =0;i<listString.length;i++){
            EditText editText = new EditText(this);
            editText.setLayoutParams(new LinearLayout.LayoutParams(config.getWidth(507),config.getHeight(78)));
            editText.setHint(listString[i]);
            editText.setTextColor(Color.WHITE); editText.setHintTextColor(Color.parseColor("#BDBDBD"));
            editText.setTypeface(tf);
            editText.setSingleLine(true);
            editText.setTextSize(config.getHeight(20));
            editText.setPadding(config.getWidth(25),0,0,0);
            editText.setBackground(new BitmapDrawable(config.escalarImagen("icons/cajatexto.png", config.getWidth(507), config.getHeight(80))));
            linearLayout.addView(editText);
            if(i<listString.length-1){
                LinearLayout linearSpace = new LinearLayout(this);
                linearSpace.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,20));
                linearLayout.addView(linearSpace);
            }
        }

        LinearLayout linearBtnCrearcuenta = new LinearLayout(this);
        linearBtnCrearcuenta.setOrientation(LinearLayout.VERTICAL);
        linearBtnCrearcuenta.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearBtnCrearcuenta.setGravity(Gravity.CENTER_HORIZONTAL);
        ImageButton btnCrearcuenta = new ImageButton(this);
        btnCrearcuenta.setImageBitmap(config.escalarImagen("icons/crearcuenta.png",config.getWidth(507),config.getHeight(80)));
        btnCrearcuenta.setBackgroundColor(Color.TRANSPARENT);
        linearBtnCrearcuenta.addView(btnCrearcuenta);

        textRegistro.setX(config.getWidth(72)); textRegistro.setY(config.getHeight(535));
        linearLayout.setX(config.getWidth(72)); linearLayout.setY(config.getHeight(592));
        linearBtnCrearcuenta.setX(0); linearBtnCrearcuenta.setY(config.getHeight(975));

        mainLayout.addView(textRegistro);
        mainLayout.addView(linearLayout);
        mainLayout.addView(linearBtnCrearcuenta);*/
    }
}
