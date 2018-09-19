package com.developer.bianca.authenticatorproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuestionsActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

//        viewPager = findViewById(R.id.view_pager);
//        QuestionPagerAdapter adapter = new QuestionPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
    }
}
