package mobile.unisinos.br.jsonvimeo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mobile.unisinos.br.jsonvimeo.pojo.UserVideo;

/**
 * Created by alan on 24/07/2016.
 */
public class DBVideo {

    private SQLiteDatabase db;

    public DBVideo(Context context) {
        DBCore access = new DBCore(context);
        db = access.getWritableDatabase();
    }

    public void inserirVideo(UserVideo video) {
        ContentValues values = new ContentValues();

        values.put("_id", video.get_id());
        values.put("title", video.getTitle());
        values.put("description", video.getDescription());
        values.put("url", video.getUrl());
        values.put("uploadDate", video.getUploadDate());
        values.put("userId", video.getUserId());
        values.put("userName", video.getUserName());
        values.put("userUrl", video.getUserUrl());
        values.put("statsNumberOfLikes", video.getStatsNumberOfLikes());
        values.put("statsNumberOfPlays", video.getStatsNumberOfPlays());
        values.put("statsNumberOfComments", video.getStatsNumberOfComments());
        values.put("duration", video.getDuration());
        values.put("width", video.getWidth());
        values.put("height", video.getHeight());
        values.put("tags", video.getTags());

        db.insert("uservideo", null, values);
    }

    public void atualizarVideo(UserVideo video) {
        ContentValues values = new ContentValues();
        values.put("title", video.getTitle());
        values.put("description", video.getDescription());
        values.put("url", video.getUrl());
        values.put("uploadDate", video.getUploadDate());
        values.put("userId", video.getUserId());
        values.put("userName", video.getUserName());
        values.put("userUrl", video.getUserUrl());
        values.put("statsNumberOfLikes", video.getStatsNumberOfLikes());
        values.put("statsNumberOfPlays", video.getStatsNumberOfPlays());
        values.put("statsNumberOfComments", video.getStatsNumberOfComments());
        values.put("duration", video.getDuration());
        values.put("width", video.getWidth());
        values.put("height", video.getHeight());
        values.put("tags", video.getTags());

        db.update("uservideo", values, "_id = ?", new String[]{String.valueOf(video.get_id())});
    }

    public boolean existeVideo (long _id) {
        String[] columns = {"_id"};
        String[] filter = {String.valueOf(_id)};
        Cursor cursor = db.query("uservideo", columns, "_id = ?", filter, null, null, null);
        return (cursor != null && cursor.getCount() > 0);
    }
}
