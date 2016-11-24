package com.ada.expandablelistview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.ada.expandablelistview.R;
import com.ada.expandablelistview.adapter.ExtendAdapter;
import com.ada.expandablelistview.manager.DBManager;

public class ExtendListActivity extends AppCompatActivity {

    private ExpandableListView expandableListView=null;
    private ExtendAdapter extendAdapter;

    private int lastItem = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend_list);
        DBManager rcm=new DBManager(this);
        rcm.getCropsList();
        rcm.getClassifications();
        rcm.getCropsGroupByKindList();
        expandableListView=(ExpandableListView) findViewById(R.id.elv_extend);
        extendAdapter= new ExtendAdapter(this);
        expandableListView.setAdapter(extendAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if( lastItem >= 0 && lastItem!=groupPosition) {
                    expandableListView.collapseGroup(lastItem);
                }
                lastItem = groupPosition;
            }
        });



    }
}
