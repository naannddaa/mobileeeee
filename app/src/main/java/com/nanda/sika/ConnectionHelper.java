package com.nanda.sika;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection con;
    String fullName, username, email, birthday, gender,password, phone, addres, ip, port, database;

    public Connection connectionclass() {
        ip = "";
        database = "";
        username = "";
        fullName = "";
        email = "";
        birthday = "";
        gender = "";
        password = "";
        phone = "";
        addres = "";
        port = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection =  null;
        String ConnectionURL= null;

        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL= "jdbc:jtds:sqlserver://"+ ip + ":"+ port+";"+ "sika="+ database+";username="+username+";password="+password+";";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception ex) {
            Log.e("Eror", ex.getMessage());
        }

        return connection;

    }
}
