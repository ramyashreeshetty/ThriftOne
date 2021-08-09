package com.mad.thriftone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tops extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView back,set;

    //Firebase
    private DatabaseReference myRef;

    //Variables
    private ArrayList<Messages> messagesList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops);

        //recycler view

        recyclerView=findViewById(R.id.rcv);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        //Firebase
        myRef= FirebaseDatabase.getInstance().getReference();


        //Arraylist
        messagesList=new ArrayList<>();

        //Clear Arraylist
        ClearAll();


        //Get Data method
        GetDataFromFirebase();

        //back

        back=findViewById(R.id.topback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Tops.this,Home.class);
                startActivity(i);
            }
        });

        //settings

        set=findViewById(R.id.setting6);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Tops.this,Settings.class);
                startActivity(i);
            }
        });


    }


    private void GetDataFromFirebase() {

        Query query= myRef.child("category").child("tops");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Messages messages= new Messages();
                    messages.setImageUrl(snapshot.child("image").getValue().toString());
                    messages.setName(snapshot.child("name").getValue().toString());
//                    messages.setInstaUrl(snapshot.child("instaurl").getValue().toString());

                    messagesList.add(messages);
                }


                recyclerAdapter=new RecyclerAdapter(getApplicationContext(), messagesList, new RecyclerAdapter.ListeItemclick() {
                    @Override
                    public void onclicklistener(int pos) {
                        switch (pos)
                        {
                            case 0:
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/luna.shopify/?hl=en")));
                                break;
                            case 1:
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/kleine.thrift/")));
                                break;
                            case 2:
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/bonbon.thrifts__/")));
                                break;
                            case 3:
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_nicetwice__/")));
                                break;
                            case 4:
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_oasis_closet_/")));
                                break;
                            case 5:
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/stop_n_shop_ladies/")));
                                break;
                            default:
                                Toast.makeText(Tops.this, "No url found", Toast.LENGTH_SHORT).show();
                                break;


                        }
                    }
                });
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    private void ClearAll(){
        if(messagesList!=null)
        {
            messagesList.clear();

            if(recyclerAdapter!=null)
            {
                recyclerAdapter.notifyDataSetChanged();
            }
        }

        messagesList=new ArrayList<>();
    }
}