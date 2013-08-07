package com.example.qcs;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class FilterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
		//绑定Layout里面的ListView
				ListView list = (ListView)findViewById(R.id.lv_filter_01);
				list.setDividerHeight(0);
				//生成动态数组，加入数据
				ArrayList<HashMap<String , Object>> listItem = new ArrayList<HashMap<String , Object>>();
				for(int i=0;i<10;i++){
					HashMap<String,Object> map = new HashMap<String ,Object>();					
					map.put("ItemText_filter", "Title");
					
					listItem.add(map);
				}
				SimpleAdapter listItemAdapter = new SimpleAdapter(this , listItem//数据源
						,R.layout.view_filter,//ListItem的XML实现
						//动态数组与ImageItem对应的子项
						new String[]{"ItemText_filter"},
						new int[]{R.id.ItemText_filter}
						);
				list.setAdapter(listItemAdapter);
	
	list.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			setTitle("单击第"+arg2+"个项目");
			
		}
	});
	
//添加长按点击
	list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
		
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
			// TODO Auto-generated method stub
			menu.setHeaderTitle("长按菜单-ContextMenu");
			menu.add(0,0,0,"弹出长按菜单0");
			menu.add(0,0,0,"弹出长按菜单1");
			
			
		}
	});
	
}

@Override
public boolean onContextItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
setTitle("点击了长按菜单里面的第"+item.getItemId()+"个项目");
	
	
	return super.onContextItemSelected(item);
}


}
