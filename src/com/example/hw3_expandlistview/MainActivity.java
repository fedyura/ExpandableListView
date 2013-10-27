package com.example.hw3_expandlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	   
        ExpandableListView listView = (ExpandableListView)findViewById(R.id.exListView);
        
        //Создаем набор данных для адаптера        
        ArrayList<NameDataPair> groups = new ArrayList<NameDataPair>();
        ArrayList<TitleTextPair> children1 = new ArrayList<TitleTextPair>();
        ArrayList<TitleTextPair> children2 = new ArrayList<TitleTextPair>();
        
        children1.add(new TitleTextPair("Topic 1", "Fragments"));
        children1.add(new TitleTextPair("Topic 2", "RelativeLayout"));
        children1.add(new TitleTextPair("Topic 3", "State List Drawable"));
        NameDataPair group1 = new NameDataPair("Lesson2", children1); 
        groups.add(group1);
        
        children2.add(new TitleTextPair("Topic 1", "Java Threads"));
        children2.add(new TitleTextPair("Topic 2", "Android Threads"));
        children2.add(new TitleTextPair("Topic 3", "Looper"));
        children2.add(new TitleTextPair("Topic 4", "Handler"));
        children2.add(new TitleTextPair("Topic 5", "AsyncTask"));
        children2.add(new TitleTextPair("Topic 6", "Processes"));
        NameDataPair group2 = new NameDataPair("Lesson3", children2);
        groups.add(group2);       
        
        //Создаем адаптер и передаем context и список с данными
        MyListAdapter adapter = new MyListAdapter(getApplicationContext(), groups);
        listView.setAdapter(adapter);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
