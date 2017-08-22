package com.example.tony.consumercontentprovider;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public static final String TAG= MainActivity.class.getSimpleName()+"_TAG";
    Uri uriContentProvider;
    ContentProviderClient contentProviderClient;
    public static final String TABLE_MOVIE="movie";
    public static final String TABLE_GENRE="genre";
    public static final String COLUMN_DATE=TABLE_MOVIE+"/date";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         uriContentProvider= Uri.parse("content://com.example.tony.w5d3ex01/");
         contentProviderClient= getContentResolver().acquireContentProviderClient(
                uriContentProvider
        );
        readContent();
    }
    public void readContent(){
        this.grantUriPermission("com.example.tony.w5d3ex01",uriContentProvider, Intent.FLAG_GRANT_READ_URI_PERMISSION|
        Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        Cursor cursor= getContentResolver().query(
                uriContentProvider.buildUpon().appendPath(TABLE_MOVIE).build(),
                null,null,null,null
        );
        Log.d(TAG, "readContent: "+cursor+"//"+uriContentProvider);
        /*cursor.
        Map<String,String> movieSet;
        movieSet.put(cursor.)
        ListView newListView= new ListView(this);
        newListView.setAdapter(new ArrayAdapter<>());*/
    }
    public void insertContent(){
        //TODO some day
        ContentValues values= new ContentValues();
        values.put(uriContentProvider.buildUpon().appendPath(TABLE_MOVIE).appendPath("name").build()
                        .toString(),
                "STAR WARS THE RETURN OF THE JEDI");
        values.put(uriContentProvider.buildUpon().appendPath(COLUMN_DATE).build().toString(),
                "08-16-1986");
    }
}
