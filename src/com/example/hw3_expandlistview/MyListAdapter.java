package com.example.hw3_expandlistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyListAdapter extends BaseExpandableListAdapter {
	
	private ArrayList<NameDataPair> mGroups;
    private Context mContext;
	
	public MyListAdapter(Context context, ArrayList<NameDataPair> groups) {
		
		mContext = context;
		mGroups = groups;
	}
    
    @Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return mGroups.get(groupPosition).getData().get(childPosition);
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return groupPosition * 10 + childPosition;
	}
	
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
							 View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//convertView - это параметр, который пропал из поля видимости. 
		//Но если элементы только создаются вначале, то его еще вообще нет
		if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_view, null);
        }
		
		TextView titleChild = (TextView) convertView.findViewById(R.id.titleChild);
        titleChild.setText(mGroups.get(groupPosition).getData().get(childPosition).getTitle());
		
		TextView textChild = (TextView) convertView.findViewById(R.id.textChild);
        textChild.setText(mGroups.get(groupPosition).getData().get(childPosition).getText());
		
        return convertView;
	}
	
	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return mGroups.get(groupPosition).getData().size();
	}
	
	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return mGroups.get(groupPosition);
	}
	
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return mGroups.size();
	}
	
	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, 
							 View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_view, null);
        }
		
		TextView textGroup = (TextView) convertView.findViewById(R.id.textGroup);
        textGroup.setText(mGroups.get(groupPosition).getName());
        
        return convertView;
	}
	
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
}
