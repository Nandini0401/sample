package com.jayqu.partner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class upload extends AppCompatActivity {

    private static final int PICK_FILE = 1 ;
    private DatabaseReference databaseReference;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("UserOne");

    }


    public void FileUpload(View view) {
        this.view = view;

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent,PICK_FILE);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == PICK_FILE){

            if(resultCode == RESULT_OK){


                Uri FileUri = data.getData();

                StorageReference Folder = FirebaseStorage.getInstance().getReference().child("Files");


                final StorageReference file_name = Folder.child("file"+FileUri.getLastPathSegment());


                StorageTask<UploadTask.TaskSnapshot> taskSnapshotStorageTask = file_name.putFile(FileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        file_name.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("filelink", String.valueOf(uri));


                                databaseReference.setValue(hashMap);
                                Toast.makeText(upload.this, "File Uploaded", Toast.LENGTH_SHORT).show();


                            }
                        });


                    }
                });


            }



        }



    }
}


