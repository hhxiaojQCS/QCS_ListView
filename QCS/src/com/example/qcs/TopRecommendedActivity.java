package com.example.qcs;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class TopRecommendedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toprecommended);
		//��Layout�����ListView
		ListView list = (ListView)findViewById(R.id.lv01);
		list.setDividerHeight(0);
		//���ɶ�̬���飬��������
		ArrayList<HashMap<String , Object>> listItem = new ArrayList<HashMap<String , Object>>();
		for(int i=0;i<10;i++){
			HashMap<String,Object> map = new HashMap<String ,Object>();
			map.put("ItemImage", R.drawable.aaa);
			map.put("ItemTitle", "Title for the best choie"+i);
			map.put("ItemText", "Description:");
			listItem.add(map);
		}
		// ������������Item�Ͷ�̬������ڵ�Ԫ��
		SimpleAdapter listItemAdapter = new SimpleAdapter(this , listItem//����Դ
				,R.layout.view_toprecommended_listview,//ListItem��XMLʵ��
				//��̬������ImageItem��Ӧ������
				new String[]{"ItemImage","ItemTitle","ItemText"},
				new int[]{R.id.ItemImage,R.id.ItemTitle,R.id.ItemText}
				);
		//���Ӳ�����ʾ
		list.setAdapter(listItemAdapter);
		//���ӵ��
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setTitle("������"+arg2+"����Ŀ");
				
			}
		});
		
	//���ӳ������
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