package com.example.capelli14014.login;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity
{
    private Button login;
    private EditText username,password;
    private AlertDialog.Builder errorUsr,errorPwd,success,emptyField;
    private String[] usernameList = {"luca","capelli","bropac","capelli.14014"};
    private String[] passwordList = {"password1","password2","password3","password4"};

    //modifica 4

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.l);
        username = (EditText)findViewById(R.id.usr);
        password = (EditText)findViewById(R.id.pwd);

        setAlert();

        login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                if(!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty())
                {
                    if(cercaUsername(username.getText().toString())!=-1)
                    {
                        if(passwordList[cercaUsername(username.getText().toString())].equals(password.getText().toString()))
                            success.show();
                        else
                            errorPwd.show();
                    }
                    else
                        errorUsr.show();
                }
                else
                    emptyField.show();
             }
        });
    }

    int cercaUsername(String u)
    {
        for(int i=0;i<usernameList.length;i++)
        {
            if(usernameList[i].equals(u))
                return i;
        }
        return -1;
    }

    void setAlert()
    {
        //USERNAME ERRATO
        errorUsr = new AlertDialog.Builder(this);
        errorUsr.setTitle("ATTENZIONE");
        errorUsr.setMessage("USERNAME ERRATO!");
        errorUsr.setPositiveButton("OK",null);
        //PASSWORD ERRATA
        errorPwd = new AlertDialog.Builder(this);
        errorPwd.setTitle("ATTENZIONE");
        errorPwd.setMessage("PASSWORD ERRATA!");
        errorPwd.setPositiveButton("OK",null);
        //CAMPI VUOTI
        emptyField = new AlertDialog.Builder(this);
        emptyField.setTitle("ATTENZIONE");
        emptyField.setMessage("HAI LASCIATO QUALCHE CAMPO VUOTO");
        emptyField.setPositiveButton("OK",null);
        //LOGIN AVVENUTO CON SUCCESSO
        success = new AlertDialog.Builder(this);
        success.setMessage("LOGIN ESEGUITO");
        success.setPositiveButton("OK",null);
    }
}
