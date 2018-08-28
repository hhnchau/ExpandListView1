package info.kingpes.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Chau Huynh on 3/21/2017.
 */

public class Adapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> group;
    private Map<String, List<ChildObiect>> item;

    public Adapter(Context context, List<String> group, Map<String, List<ChildObiect>> item) {
        this.context = context;
        this.group = group;
        this.item = item;
    }

    private int[] img = {
            R.drawable.icon_1,
            R.drawable.icon_2,
            R.drawable.icon_3,
            R.drawable.icon_4,
            R.drawable.icon_5,
            R.drawable.icon_6,
            R.drawable.icon_7,
            R.drawable.icon_8};

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return item.get(group.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return group.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return item.get(group.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String l = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group, null);
        }
        ImageView i = (ImageView) convertView.findViewById(R.id.group_img);
        //i.setImageResource(R.drawable.icon_8);
        TextView g = (TextView) convertView.findViewById(R.id.group_text);

        g.setText(l);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chlid, null);
        }

        ImageView i = (ImageView) convertView.findViewById(R.id.child_img);
        i.setImageResource(img[item.get(group.get(groupPosition)).get(childPosition).getImg()]);
        TextView c = (TextView) convertView.findViewById(R.id.child_text);
        c.setText(item.get(group.get(groupPosition)).get(childPosition).getName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
