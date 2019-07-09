package com.example.hw20190705_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class secondImage extends Activity {
    ImageView image;
    int i = 0;
    int[] drawable_Value;
    Intent putintent;
    float x1 = 0;
    float x2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_second);

        Intent intent = getIntent();
        drawable_Value = intent.getIntArrayExtra("array");
        i = intent.getIntExtra("image", 0);

        image = findViewById(R.id.imageView);
        image.setImageResource(drawable_Value[i]);

        putintent = new Intent(this, ImageActivity.class);
        View.OnTouchListener TouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    x1 = motionEvent.getRawX();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    x2 = motionEvent.getRawX();
                    if (x2 - x1 < 0) {
                        if (i == drawable_Value.length - 1)
                            i = -1;
                        i++;
                        putintent.putExtra("image",i);
                        startActivity(putintent);
                        overridePendingTransition(R.anim.intoright, R.anim.outtoleft);
                        finish();
                    } else if (x2 - x1 > 0) {
                        if (i == 0)
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
        };
        image.setOnTouchListener(TouchListener);
    }
    public void onClick(View view) {
        finish();
    }

}
