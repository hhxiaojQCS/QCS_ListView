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
		//��Layout�����ListView
				ListView list = (ListView)findViewById(R.id.lv_filter_01);
				list.setDividerHeight(0);
				//���ɶ�̬���飬��������
				ArrayList<HashMap<String , Object>> listItem = new ArrayList<HashMap<String , Object>>();
				for(int i=0;i<10;i++){
					HashMap<String,Object> map = new HashMap<String ,Object>();					
					map.put("ItemText_filter", "Title");
					
					listItem.add(map);
				}
				SimpleAdapter listItemAdapter = new SimpleAdapter(this , listItem//����Դ
						,R.layout.view_filter,//ListItem��XMLʵ��
						//��̬������ImageItem��Ӧ������
						new String[]{"ItemText_filter"},
						new int[]{R.id.ItemText_filter}
						);
				list.setAdapter(listItemAdapter);
	
	list.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			setTitle("������"+arg2+"����Ŀ");
			
		}
	});
	
//��ӳ������
	list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
		
		@Override
		public void onCreateContextMenu(ContextMenu menu, View v,
				ContextMenuInfo menuInfo) {
			// TODO Auto-generated method stub
			menu.setHeaderTitle("�����˵�-ContextMenu");
			menu.add(0,0,0,"���������˵�0");
			menu.add(0,0,0,"���������˵�1");
			
			
		}
	});
	
}

@Override
public boolean onContextItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
setTitle("����˳����˵�����ĵ�"+item.getItemId()+"����Ŀ");
	
	
	return super.onContextItemSelected(item);
}


}
