package com.nanda.sika;

import android.content.Intent;
import android.os.Bundle;
import android.view.PixelCopy;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    Button register;
    private EditText t_username, t_password;
    private Button btn_registrasi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        t_username = findViewById(R.id.t_username);
        t_password = findViewById(R.id.t_password);

//        register = findViewById(R.id.btn_registrasi);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);

                String username = t_username.getText().toString();
                String password = t_password.getText().toString();

                if (! (username.isEmpty() || password.isEmpty())){

                    RequestQueue  requestQueue = Volley.newRequestQueue(getApplicationContext());

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, Db_Contract.urlLogin + "?username=" + username + "&password=" + password, new );

                    @Override
                    public void onResponse(String response) {
                        if (response.equals("selamat datang")) {
                            Toast.makeText(getApplicationContext(), "Login berhasil", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        }else {
                            Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                        }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });

                    requestQueue.add(stringRequest);
            }else {
                    Toast.makeText(getApplicationContext(), "PASSWORD ATAU USERNAME SALAH", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;

    }
}