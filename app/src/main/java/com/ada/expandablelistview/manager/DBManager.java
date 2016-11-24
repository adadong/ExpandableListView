package com.ada.expandablelistview.manager;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;

import com.ada.expandablelistview.libs.DBHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ada on 2016/11/15.
 */

public class DBManager {
    public static String BASEPATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LIVESURVEYDATA";
    public static final String RULE_DB_NAME = BASEPATH + "/DEMAND/RULE.db";
    public static final String TTABLE_ZWCY_NAME = "DIC_ZWCY";
    public static final String TTABLE_ZW_NAME = "DIC_ZW";

    /**
     * 填报作物信息列表
     */
    public static List<HashMap<String, String>> LISTCROPS = new ArrayList<HashMap<String, String>>();
    /**
     * 默认作物列表
     */
    public static List<HashMap<String, String>> DEFAULT_CROPS_LIST = new ArrayList<HashMap<String, String>>();

    /**
     * 作物分类
     */
    public static List<String> ClassificationList = new ArrayList<String>();

    /**
     * 按分类存放作物
     */
    public static HashMap<String, List<HashMap<String, String>>> Crops_Group_By_Kind_List = new HashMap<String, List<HashMap<String, String>>>();


    private static DBHelper helper = null;

    public DBManager(Context context) {
        System.out.println(RULE_DB_NAME);
        helper = new DBHelper(context, RULE_DB_NAME);
    }

    public static List<HashMap<String, String>> getCropsList() {
        if (LISTCROPS.size() <= 0) {
            HashMap<String, String> Crop;
            Cursor cursor = helper.getWritableDatabase().query(TTABLE_ZW_NAME, null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    Crop = new HashMap<String, String>();
                    Crop.put("PID", cursor.getString(0));
                    Crop.put("VALUE", cursor.getString(1));
                    Crop.put("CLASSIFICATION", cursor.getString(2));
                    Crop.put("COLOR", cursor.getString(3));
                    LISTCROPS.add(Crop);
                } while (cursor.moveToNext());
            }
        }
        return LISTCROPS;
    }

    public static List<String> getClassifications() {
        if(ClassificationList.size()<=0) {
            String[] str = {"CLASSIFICATION"};
            Cursor cursor = helper.getWritableDatabase().query(true, TTABLE_ZW_NAME, str, null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    ClassificationList.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
        }
        return ClassificationList;
    }

    public static HashMap<String, List<HashMap<String, String>>> getCropsGroupByKindList() {
        List<HashMap<String, String>> temp = null;
        for (int j = 0; j < ClassificationList.size(); j++) {
            temp = new ArrayList<HashMap<String, String>>();
            Crops_Group_By_Kind_List.put(ClassificationList.get(j), temp);
        }
        for (int i = 0; i < LISTCROPS.size(); i++) {
            HashMap<String, String> crop = LISTCROPS.get(i);
            List<HashMap<String, String>> temp1 = Crops_Group_By_Kind_List.get(crop.get("CLASSIFICATION"));
            temp1.add(crop);
            Crops_Group_By_Kind_List.put(crop.get("CLASSIFICATION"),temp1);
        }
        return Crops_Group_By_Kind_List;
    }

}
