package com.mad.thriftone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class Home extends AppCompatActivity {


    ImageView topimg,denimg,dressimg,accimg,footimg,linimg,set;

    VideoView simpleVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //category
        topimg=findViewById(R.id.topicon);
        denimg=findViewById(R.id.denimicon);
        accimg=findViewById(R.id.accicon);
        footimg=findViewById(R.id.footicon);
        linimg=findViewById(R.id.linicon);
        dressimg=findViewById(R.id.dressicon);



        //video banner
        VideoView simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.arrivalbanner));
        simpleVideoView.start(); // start a video

        simpleVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });


        set=findViewById(R.id.settinghome);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,Settings.class);
                startActivity(i);
            }
        });




    }


    public void onclicktopimg(View view)
    {
        Intent intent=new Intent(Home.this,Tops.class);
        startActivity(intent);

    }

    public void onclickdenimimg(View view)
    {
        Intent intent=new Intent(Home.this,Denim.class);
        startActivity(intent);

    }
    public void onclickdressimg(View view)
    {
        Intent intent=new Intent(Home.this,Dresses.class);
        startActivity(intent);

    }
    public void onclicklingereimg(View view)
    {
        Intent intent=new Intent(Home.this,Lingerie.class);
        startActivity(intent);

    }
    public void onclickfootwearimg(View view)
    {
        Intent intent=new Intent(Home.this,Footwear.class);
        startActivity(intent);

    }
    public void onclickaccimg(View view)
    {
        Intent intent=new Intent(Home.this,Acessories.class);
        startActivity(intent);

    }
}