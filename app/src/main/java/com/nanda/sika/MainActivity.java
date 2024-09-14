package com.nanda.sika;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    // database
    Connection connect;
    String ConnectionResult="";


    // MENGATUR TANGGAL
    EditText nama, username, email, password, telepon, addres, date;
    Button registrasi, login;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_registrasi);
        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT).show();

        nama = findViewById(R.id.t_longname);
        username = findViewById(R.id.t_username);
        email = findViewById(R.id.t_email);
        password = findViewById(R.id.t_password);
        telepon = findViewById(R.id.t_phone);
        addres = findViewById(R.id.t_addres);
        date = findViewById(R.id.t_date);
        Spinner spinner = findViewById(R.id.jeniskelamin);
        registrasi = findViewById(R.id.btn_registrasi);
        login = findViewById(R.id.btn_login);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                Calendar selectedDate = Calendar.getInstance();
                                selectedDate.set(year, monthOfYear, dayOfMonth);

                                SimpleDateFormat s = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                                String formattedDate = s.format(selectedDate.getTime());

                                date.setText(formattedDate);
                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });

        // BUTTON LOGIN
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Action", "OnStop");
    }

    @Override
    protected void  onRestart(){
        super.onRestart();
        Toast.makeText(this, "On Restart", Toast.LENGTH_SHORT).show();
    }

    //database
//    public void GetTextFromSQL(View v) {
//        EditText tx1 = (EditText) findViewById(R.id.t_username);
//        EditText tx2 = (EditText) findViewById(R.id.t_password);
//
//        try {
//                ConnectionHelper connectionHelper = new ConnectionHelper();
//                connect = connectionHelper.connectionclass();
//                if(connect!=null){
//                    String query= "Select * from Registrasi where username";;
//                    Statement st = connect.createStatement();
//                    ResultSet rs = st.executeQuery(query);;
//
//                    while (rs.next()) {
//                        int columnindex;
//                        tx1.setText(rs.getString( columnindex:);
//                        tx2.setText(rs.getString( columnindex:);
//                    }
//                } else {
//                    ConnectionResult="Check Connection";
//                }
//        }
//        catch ( Exception ex)
//        {
//    }
//
//    }
}