package com.sanket.expandable.navigation;

import info.androidhive.expandablelistview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvexp);

		// preparing list data
		prepareListData();

		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		// Listview Group click listener
		expListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				// Toast.makeText(getApplicationContext(),
				// "Group Clicked " + listDataHeader.get(groupPosition),
				// Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		// Listview Group expanded listener
		expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Expanded",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Listview Group collasped listener
		expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

			@Override
			public void onGroupCollapse(int groupPosition) {
				Toast.makeText(getApplicationContext(),
						listDataHeader.get(groupPosition) + " Collapsed",
						Toast.LENGTH_SHORT).show();

			}
		});

		// Listview on child click listener
		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						getApplicationContext(),
						listDataHeader.get(groupPosition)
								+ " : "
								+ listDataChild.get(
										listDataHeader.get(groupPosition)).get(
										childPosition), Toast.LENGTH_SHORT)
						.show();
				return false;
			}
		});
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("By Fragrance");
		listDataHeader.add("By Category");
		listDataHeader.add("By Product Type");
		listDataHeader.add("By Brand");

		// Adding child data
		List<String> Fragrance = new ArrayList<String>();
		Fragrance.add("Floral");
		Fragrance.add("Herbal");
		Fragrance.add("Woody");
		Fragrance.add("Perfumy");
		Fragrance.add("sweet");
		Fragrance.add("Natural");
		

		List<String> Category = new ArrayList<String>();
		Category.add("Regular Masala Series");
		Category.add("Premium Series");
		Category.add("Classic Masala");
		Category.add("3G Collection");
		Category.add("Big Pouch Series");
		Category.add("Premium Masala Series");
		Category.add("Regular Series");
		Category.add("Good Morning Series");
		Category.add("Long Aggarbatti Series");
		Category.add("Wooden Aggarbatti Stand");

		List<String> Type = new ArrayList<String>();
		Type.add("Machine Crafted Perfumed Sticks");
		Type.add("Hand rolled Masala Sticks");
		Type.add("Economy + Quality");
		
		List<String> Brand = new ArrayList<String>();
		Brand.add("Shree Krishna Parnami");
		Brand.add("Feel Good");
		Brand.add("Nijanand Darshan");
		Brand.add("Suverna");
		

		listDataChild.put(listDataHeader.get(0), Fragrance); // Header, Child data
		listDataChild.put(listDataHeader.get(1), Category);
		listDataChild.put(listDataHeader.get(2),Type );
		listDataChild.put(listDataHeader.get(3),Brand );
	}
}
