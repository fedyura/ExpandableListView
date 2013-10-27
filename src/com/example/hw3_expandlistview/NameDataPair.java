package com.example.hw3_expandlistview;

import java.util.ArrayList;

public class NameDataPair {
	
	private String mName;
	private ArrayList<TitleTextPair> mData;
	
	public NameDataPair(String name, ArrayList<TitleTextPair> data) {
		
		mName = name;
		mData = data;
	}
	
	public String getName() {
		
		return mName;
	}
	
	public ArrayList<TitleTextPair> getData() {
		
		return mData;
	}
	
	
}
