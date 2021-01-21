package com.example.chewie_is_on_netflix;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1,textView2,textView3,textView4,textView5;

    ImageView imageView1,imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        textView1 = findViewById(R.id.text_1);
        textView2 = findViewById(R.id.image_rec_1_text);
        textView3 = findViewById(R.id.image_rec_2_text);
        textView4 = findViewById(R.id.image_rec_3_text);
        textView5 = findViewById(R.id.image_rec_4_text);

        imageView1 = findViewById(R.id.image_rec_1);
        imageView2 = findViewById(R.id.image_rec_2);
        imageView3 = findViewById(R.id.image_rec_3);
        imageView4 = findViewById(R.id.image_rec_4);

        setColorToGradiant(textView1);
        setColorToGradiant(textView2);
        setColorToGradiant(textView3);
        setColorToGradiant(textView4);
        setColorToGradiant(textView5);

        click_1();
        click_2();
        click_3();
        click_4();
    }

    private void setColorToGradiant(TextView textView){
        TextPaint textPaint = textView.getPaint();
        float width = textPaint.measureText(textView.getText().toString());

        Shader shader = new LinearGradient(width/2,0,width/2,textView.getTextSize(),
                new int[]{
                        Color.parseColor("#ffffff"),
                        Color.parseColor("#828282")
                },null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
    }
    private void setColorToGradiant2(TextView textView){
        TextPaint textPaint = textView.getPaint();
        float width = textPaint.measureText(textView.getText().toString());

        Shader shader = new LinearGradient(width/2,0,width/2,textView.getTextSize(),
                new int[]{
                        Color.parseColor("#ffffff"),
                        Color.parseColor("#286086")
                },null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
    }

    public void click_1(){
        imageView1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View,String>(imageView1,"2.1");
                pairs[1] = new Pair<View,String>(imageView1,"2.2");
                pairs[2] = new Pair<View,String>(imageView1,"2.3");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(intent,options.toBundle());
            }
        });
    }

    public void click_2(){
        imageView2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity3.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View,String>(imageView2,"3.1");
                pairs[1] = new Pair<View,String>(imageView2,"3.2");
                pairs[2] = new Pair<View,String>(imageView2,"3.3");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        pairs);

                startActivity(intent,options.toBundle());
            }
        });
    }

    public void click_3(){
        imageView3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity4.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View,String>(imageView3,"4.1");
                pairs[1] = new Pair<View,String>(imageView3,"4.2");
                pairs[2] = new Pair<View,String>(imageView3,"4.3");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        pairs);

                startActivity(intent,options.toBundle());
            }
        });
    }

    public void click_4(){
        imageView4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity5.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View,String>(imageView4,"5.1");
                pairs[1] = new Pair<View,String>(imageView4,"5.2");
                pairs[2] = new Pair<View,String>(imageView4,"5.3");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        pairs);

                startActivity(intent,options.toBundle());
            }
        });
    }
}