package com.example.dell.sregister;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import br.com.bloder.magic.view.MagicButton;


public class MainActivity extends AppCompatActivity {

    EditText name, dob, mob, city;
    Calendar c;
    int dd, mm, yy;
    Register r = new Register();
    String phone = "[987]";
    MagicButton mag;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        dob = (EditText) findViewById(R.id.dob);
        mob = (EditText) findViewById(R.id.mob);
        mag=(MagicButton)findViewById(R.id.magic);
        city = (EditText) findViewById(R.id.city);
        c = Calendar.getInstance();
        dd = c.get(Calendar.DAY_OF_MONTH);
        mm = c.get(Calendar.MONTH);
        yy = c.get(Calendar.YEAR);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dob.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

                    }
                }, dd, (mm + 1), yy);
                datePickerDialog.setTitle("\n\tSelect Date");
                datePickerDialog.show();

            }
        });
        mag.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initalize();
            }
        });
    }



    public void initalize() {
        String no = mob.getText().toString();
        boolean f1, f2, f3, f4;
        f1 = f2 = f3 = f4 = true;

        if (name.length() == 0 || name.length() >= 15) {
            name.setError("Enter the name less than 15 char");
            f1 = false;

        }

        if (dob.isClickable() == false) {
            dob.setError("Select the date");
            f2 = true;
        }

        if (mob.length() == 0 || mob.length() != 10 || (!String.valueOf(no.charAt(0)).matches(phone))) {
            mob.setError(" Enter the valid 10 digit mob.no");
            f3 = false;
        }
        if (city.length() == 0) {
            city.setError("Enter the valid city");
            f3 = false;
        }
        if (f1 && f2 && f3 && f4) {

            r.getuname(name.getText().toString());
            r.getudob(dob.getText().toString());
            r.getumob(mob.getText().toString());
            r.getucity(city.getText().toString());
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("\t\t\t\tShall I Submit User-Data");
            b.setMessage("\n\t\t Name :" + r.setuname() + "\n\t\t D.O.B :" + r.setudob() + "\n\t\t Mob.No :" + r.setumob() + "\n\t\t City :" + r.setucity());


            b.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("name", r.setuname());
                    i.putExtra("dob", r.setudob());
                    i.putExtra("mob", r.setumob());
                    i.putExtra("city", r.setucity());
                    startActivity(i);

                }
            }).setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog a = b.create();
            a.show();

        }
    }
}
