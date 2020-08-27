package com.jayqu.partner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.versionedparcelable.VersionedParcel;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class viniii extends AppCompatActivity {
    private EditText name, mobile, email, address;
    private Button save;
    private Spinner spinner;
    TextView timer1,timer2;
    int t1Hour,t1Minute,t2Hour,t2Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viniii);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.itdescription);
        email = findViewById(R.id.itprice);
        address = findViewById(R.id.itavailability);
        save = findViewById(R.id.save);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(viniii.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        mySpinner.setAdapter(myAdapter);

        timer1 = findViewById(R.id.timer1);
        timer2 = findViewById(R.id.timer2);


        timer1.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          TimePickerDialog timePickerDialog = new TimePickerDialog(
                                                  viniii.this, android.R.style.Theme_Material_Light_Dialog_MinWidth,
                                                  new TimePickerDialog.OnTimeSetListener() {
                                                      @Override
                                                      public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                                          t1Hour = hourOfDay;
                                                          t1Minute = minute;
                                                          Calendar calendar = Calendar.getInstance();
                                                          calendar.set(0, 0, 0, t1Hour, t1Minute);
                                                          timer1.setText(DateFormat.format("hh:mm aa", calendar));
                                                      }

                                                  }, 12, 0, false
                                          );
                                          timePickerDialog.updateTime(t1Hour, t1Minute);
                                          timePickerDialog.show();
                                      }
                                  });


        timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        viniii.this, android.R.style.Theme_Material_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t2Hour = hourOfDay;
                                t2Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, t2Hour, t2Minute);
                                timer2.setText(DateFormat.format("hh:mm aa", calendar));

                            }
                        },12,0,false
                );
               // timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t2Hour,t2Minute);
                timePickerDialog.show();
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, Object> map = new HashMap<>();
                map.put("name", name.getText().toString());
                map.put("mobile", mobile.getText().toString());
                map.put("email", email.getText().toString());
                map.put("address", address.getText().toString());
               // map.put("spinner",spinner.getSelectedItem().toString());

                FirebaseDatabase.getInstance().getReference().child("Registrations").push()
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("abc", "onComplete: ");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("abc", "onFailure: " + e.toString());
                            }
                        }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.i("abc", "onSuccess: ");
                        startActivity(new Intent(viniii.this, HomeActivity.class));
                    }
                });


            }
        });
    }
}