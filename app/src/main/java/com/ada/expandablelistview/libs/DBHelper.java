package com.ada.expandablelistview.libs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ada on 2016/11/7.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String LOG_TAG = "DBHelper";

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context, String name, int version){
        this(context,name,null,version);
    }

    public DBHelper(Context context, String name){
        this(context,name,VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable = "create table mark_info(id integer primary key autoincrement,code text,name text,path text,time text,longitude text,latitude text,direct text,pitch text,roll text, altitude text,extent text)";
        //输出创建数据库的日志信息
        Log.i(LOG_TAG, "create Database------------->");
        //execSQL函数用于执行SQL语句
        db.execSQL(sqlCreateTable);

        //String sql = "create table photo_info(id integer primary key autoincrement,name text,path text,time text,info text,longitude text,latitude text,direct int,pitch int,roll int, altitude int,extent text)";
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(LOG_TAG, "update Database------------->");
    }
}
