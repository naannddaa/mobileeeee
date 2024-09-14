package com.nanda.sika;

import android.content.Intent;
import android.os.Bundle;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;
import java.util.HashMap;

public class Registrasi extends AppCompatActivity {

    private EditText t_longname, t_username, t_email, t_tanggalLahir, t_password, t_notelp, t_addres;
    private Button btn_registrasi;
    private Spinner t_gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrasi);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        t_longname = findViewById(R.id.t_longname);
        t_username = findViewById(R.id.t_username);
        t_email = findViewById(R.id.t_email);
        t_tanggalLahir = findViewById(R.id.t_date);
        t_gender = findViewById(R.id.jeniskelamin);
        t_password = findViewById(R.id.t_password);
        t_notelp = findViewById(R.id.t_phone);
        t_addres = findViewById(R.id.t_addres);

        btn_registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = t_username.getText().toString();
                String password = t_password.getText().toString();
                String alamat = t_addres.getText().toString();
                String namaPanjang = t_longname.getText().toString();
                String email = t_email.getText().toString();
                String tanggalLahir = t_tanggalLahir.getText().toString();
//                String gender = t_gender.getBaseline();
                String notelp = t_notelp.getText().toString();


            if (!(username.isEmpty() || password.isEmpty() || alamat.isEmpty() || namaPanjang.isEmpty() || email.isEmpty() || tanggalLahir.isEmpty() || notelp.isEmpty())){


                //menyimpan ke database

                StringRequest stringRequest = new StringRequest(Request.Method.POST, Db_Contract.urlRegister, new Response.Listener<String>()) {
                    @Override
                         public void onResponse(String response) {
                              Toast.makeText(getApplicationContext(), response.toString() Toast.LENGTH_SHORT).show();

                              startActivity(new Intent(getApplicationContext(), Login.class));
                    }
                    }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                      };

                     {

                         //menyimpan data ke database
                    @Override
                    protected HashMap<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> params = new HashMap<>();

                    params.put("username", username);
                    params.put("alamat", alamat);
                    params.put("password", password);
                    params.put("namaPanjang", namaPanjang);
                    params.put("email", email);
                    params.put("tanggalLahir", tanggalLahir);
                    params.put("notelp", notelp);
                    params.put("alamat", alamat);

                    return params;
                }
                };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);

            }else{
                    Toast.makeText(getApplicationContext(), "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}