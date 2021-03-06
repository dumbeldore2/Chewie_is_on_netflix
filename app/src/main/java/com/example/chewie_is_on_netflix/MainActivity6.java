package com.example.chewie_is_on_netflix;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.bson.Document;

import java.lang.annotation.Documented;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;
import io.realm.mongodb.mongo.iterable.FindIterable;

public class MainActivity6 extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;

    TextView textView1;

    ImageView imageView1,imageView2;

    Animation animation1,animation2;

    String appId = "application-0-zwxlc";
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(Color.parseColor("#7C0A02"));
        getWindow().setStatusBarColor(Color.parseColor("#000000"));

        Realm.init(this);
        final App app = new App(new AppConfiguration.Builder(appId).build());


        app.loginAsync(Credentials.anonymous(), new App.Callback<User>() {
            @Override
            public void onResult(App.Result<User> result) {
                if (result.isSuccess()){

                    User user = app.currentUser();
                    mongoClient = user.getMongoClient("mongodb-atlas");
                    mongoDatabase = mongoClient.getDatabase("myFirstDatabase");
                    MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("shemas");

                    Toast.makeText(getApplicationContext(),"login was a succes",Toast.LENGTH_LONG).show();

                    //FindIterable<Document> resultdata = mongoCollection.find();
                    //Document myDoc = (Document) mongoCollection.find().first();
                    //System.out.println(myDoc.toJson());
                    //System.out.println(mongoCollection.count());
                    //Document document = mongoCollection.count().get();
                } else {
                    Log.v("User" , "mission failed");
                }
            }
        });



        textView1 = findViewById(R.id.text_1);

        imageView1 = findViewById(R.id.image_1);
        imageView2 = findViewById(R.id.image_2);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.anim_1);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.anim_2);

        imageView1.setAnimation(animation1);
        textView1.setAnimation(animation2);
        imageView2.setAnimation(animation1);

        imageView1.animate();

        setColorToGradiant(textView1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity6.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
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
}