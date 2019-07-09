package com.example.hw20190705_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    final int id_Value[] = {R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img6,R.id.img7,R.id.img8,R.id.img9,R.id.img10,R.id.img11,R.id.img12,R.id.img13};
    final int drawable_Value[] = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,R.drawable.img13};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView allImage[] = new ImageView[id_Value.length];
        for(int i = 0 ; i < allImage.length; i++) {
            allImage[i] = findViewById(id_Value[i]);
        }
        final Intent intent = new Intent(this,ImageActivity.class);

        View.OnTouchListener TouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        for (int i = 0; i < id_Value.length; i++) {
                            if (view.getId() == id_Value[i]) {
                                intent.putExtra("array",drawable_Value);
                                intent.putExtra("Image",i);
                                startActivity(intent);
                                break;
                            }
                        }
                    }
                return true;
            }
        };
        for(int i = 0;i < allImage.length;i++)
            allImage[i].setOnTouchListener(TouchListener);
    }
}
