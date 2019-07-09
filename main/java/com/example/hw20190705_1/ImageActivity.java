package com.example.hw20190705_1;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {
    Intent intent,putintent;
    ImageView image;
    int[] drawable_Value;
    int i;
    float x1 = 0;
    float x2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //값 받은거 저장
        intent = getIntent();
        drawable_Value = intent.getIntArrayExtra("array");
        i = intent.getIntExtra("Image",0);

        //기본설정
        image = findViewById(R.id.imageView);
        Log.d("search_i",i+"");
        image.setImageResource(drawable_Value[i]);

        putintent = new Intent(this,secondImage.class);
        putintent.putExtra("array",drawable_Value);
        View.OnTouchListener TouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    x1 = motionEvent.getRawX();
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    x2 = motionEvent.getRawX();
                    if(x2-x1<0){
                        if(i == drawable_Value.length-1)
                            i = -1;
                        i++;

                        putintent.putExtra("image",i);
                        startActivity(putintent);
                        overridePendingTransition(R.anim.intoright, R.anim.outtoleft);
                        finish();
                    } else if (x2-x1>0) {
                        if(i == 0)
                            i = drawable_Value.length;
                        i--;

                        putintent.putExtra("image",i);
                        startActivity(putintent);
                        overridePendingTransition(R.anim.intoleft, R.anim.outtoright);
                        finish();
                    }
                }
                return true;
            }
        };image.setOnTouchListener(TouchListener);
    }

    public void onClick(View view) {
        finish();
    }
}
