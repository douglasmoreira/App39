package com.example.app39;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewFlipper viewFlipper;
    ImageButton btnAnimalImageNext;
    ImageButton btnAnimalImagePrevious;
    ViewAnimator viewAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewFlipper = findViewById(R.id.viewFlipper);
        btnAnimalImageNext = findViewById(R.id.btnAnimalImageNext);
        btnAnimalImagePrevious = findViewById(R.id.btnAnimalImagePrevious);
        viewAnimator = findViewById(R.id.viewAnimator);

        letsAddImageToTheViewAnimator(viewAnimator);
        letsAddImageToTheViewFlipper(viewFlipper);

        useAnimationForTheViewFlipper(viewFlipper);
        useAnimatorForTotheViewAnimator(viewAnimator);

        btnAnimalImageNext.setOnClickListener(MainActivity.this);
        btnAnimalImagePrevious.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAnimalImageNext:
                viewFlipper.showNext();
                viewAnimator.showNext();
            break;
            case R.id.btnAnimalImagePrevious:
                viewFlipper.showPrevious();
                viewAnimator.showPrevious();
            break;
        }
    }

    public void letsSetLayoutParams(ImageView imageView){
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));
     }

     private void letsAddImageToTheViewFlipper(ViewFlipper viewFlipper){
        for(int index = 0; index < Animal.animalImage.length; index++){
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(Animal.animalImage[index]);
            imageView.setPadding(100,100,100,100);
            letsSetLayoutParams(imageView);
            viewFlipper.addView(imageView);
        }
     }
     private void letsAddImageToTheViewAnimator(ViewAnimator viewAnimator){
        for (int index = 0; index < Animal.animalImage.length; index++){
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(Animal.animalImage[index]);
            imageView.setPadding(100,100,100,100);
            letsSetLayoutParams(imageView);
            viewAnimator.addView(imageView);
        }
     }
     private void useAnimationForTheViewFlipper(ViewFlipper viewFlipper){
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_in_left));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_out_right));
     }

     private void useAnimatorForTotheViewAnimator(ViewAnimator viewAnimator){
        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_in_left));
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,
                android.R.anim.slide_out_right));
     }

}
