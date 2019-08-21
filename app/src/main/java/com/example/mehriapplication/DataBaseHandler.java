package com.example.mehriapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mehriapplication.MOVIE.Search;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {

    String TableName = "MovieList";
    String column1 = "TITLE";
    String column2 = "YEAR";
    String column3 = "POSTER";

    public DataBaseHandler(@Nullable Context context, @Nullable String name,
                           @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TableQuery = "CREATE TABLE" + TableName + "("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                column1 + " TEXT"+
                column2 + "TEXT"+
                column3 + "TEXT"
                + ")";
        db.execSQL(TableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addData (List<Search> list){
        SQLiteDatabase db = this.getWritableDatabase();
        for (int x=0; x< list.size(); x++){
            if (list.get(x).getTitle().contains("'")){
                list.get(x).setTitle(list.get(x).getTitle().replaceAll("'","'"));
            }
        }
        for (int y = 0; y <list.size(); y++){
            String insert = "INSERT INTO" + TableName + "(" +
                    column1 + "," + column2 + "," + column3 + ")" +
                    "VALUES( '" + list.get(y).getTitle() + "' , " +
                    "'" + list.get(y).getYear() + "' , " +
                    "'" + list.get(y).getPoster() + "' )";
            db.execSQL(insert);
        }
        db.close();
    }

    public List<Search> GetData(String string){
        String DataQuery = "SELECT TITLE,YEAR,POSTER FROM" + TableName +
                "WHERE TITLE LIKE '%" + string + "%'";
        List<Search> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(DataQuery,null);

        while (cursor.moveToNext()){
            Search search = new Search();
            search.setTitle(cursor.getString(0));
            search.setYear(cursor.getString(1));
            search.setPoster(cursor.getString(2));
            list.add(search);
        }
        db.close();
        return list;
    }
}
