package info.kingpes.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    List<String> group;
    Map<String, List<ChildObiect>> item;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expand_listVIew);
        fillData();

        adapter = new Adapter(this, group, item);
        expandableListView.setAdapter(adapter);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, group.get(groupPosition) + "===" + item.get(group.get(groupPosition)).get(childPosition).getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public void fillData() {
        group = new ArrayList<>();

        //Add List Group
        group.add("ONE");
        group.add("TWO");

        //Create Item
        List<ChildObiect> one = new ArrayList<>();
        one.add(new ChildObiect(0, "1-1"));
        one.add(new ChildObiect(1, "1-2"));

        //Create Item
        List<ChildObiect> two = new ArrayList<>();
        two.add(new ChildObiect(0, "2-1"));
        two.add(new ChildObiect(1, "2-2"));

        //Add List Item
        item = new HashMap<>();
        item.put(group.get(0), one);
        item.put(group.get(1), two);


    }
}
