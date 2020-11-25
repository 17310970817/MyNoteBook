package com.zys.mynotebook;            //该类用来管理数据库的创建和版本的管理继承SQLiteopenhelper类

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NoteDataBaseHelper extends SQLiteOpenHelper {

    public NoteDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //表创建接口 有多张表时 方便统一调用
    public static interface TableCreateInterface {
        //创建数据库
        public void onCreate( SQLiteDatabase db );

        //升级数据库
        public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Note.getInstance().onCreate(db);
    }//用getinstance得到对象，保证每次都返回相同的对象，getinstance为静态的

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Note.getInstance().onUpgrade(db,oldVersion,newVersion);
    }
}
