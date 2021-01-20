package com.example.chewie_is_on_netflix;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1,textView2,textView3,textView4,textView5;

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

        setColorToGradiant(textView1);
        setColorToGradiant(textView2);
        setColorToGradiant(textView3);
        setColorToGradiant(textView4);
        setColorToGradiant(textView5);
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
}