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

public class MainActivity4 extends AppCompatActivity {
    TextView textView1,textView2;

    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        textView1 = findViewById(R.id.text_1);
        textView2 = findViewById(R.id.text_2);

        imageView1 = findViewById(R.id.image_1);
        
        setColorToGradiant(textView1);
        setColorToGradiant(textView2);

        click_1();
    }

    private void setColorToGradiant(TextView textView){
        TextPaint textPaint = textView.getPaint();
        float width = textPaint.measureText(textView.getText().toString());

        Shader shader = new LinearGradient(width/2,0,width/2,textView.getTextSize(),
                new int[]{
                        Color.parseColor("#ffffff"),
                        Color.parseColor("#828282")
                },null, Shader.TileMode.CLAMP);
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

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                Pair[] pairs = new Pair[9];
                pairs[0] = new Pair<View,String>(imageView1,"1.1");
                pairs[1] = new Pair<View,String>(imageView1,"1.2");
                pairs[2] = new Pair<View,String>(imageView1,"1.3");
                pairs[3] = new Pair<View,String>(imageView1,"1.4");
                pairs[4] = new Pair<View,String>(imageView1,"1.5");
                pairs[5] = new Pair<View,String>(imageView1,"1.6");
                pairs[6] = new Pair<View,String>(imageView1,"1.7");
                pairs[7] = new Pair<View,String>(imageView1,"1.8");
                pairs[8] = new Pair<View,String>(imageView1,"1.9");
                ActivityOptions options =
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity4.this,
                                pairs);

                startActivity(intent,options.toBundle());
            }
        });
    }
}