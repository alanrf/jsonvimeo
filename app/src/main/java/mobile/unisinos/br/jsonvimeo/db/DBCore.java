package mobile.unisinos.br.jsonvimeo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alan on 24/07/2016.
 */
public class DBCore extends SQLiteOpenHelper {

    private static final String NOME_BD = "bdvimeo";
    private static final int VERSAO_BD = 1;

    public DBCore(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //cria a tabela
        sqLiteDatabase.execSQL("create table uservideo (" +
                "_id integer primary key,\n" +
                "title text not null,\n" +
                "description text,\n" +
                "url text not null,\n" +
                "uploadDate text not null,\n" +
                "userId integer,\n" +
                "userName text,\n" +
                "userUrl text,\n" +
                "statsNumberOfLikes integer,\n" +
                "statsNumberOfPlays integer,\n" +
                "statsNumberOfComments integer,\n" +
                "duration integer,\n" +
                "width integer,\n" +
                "height integer,\n" +
                "tags text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // caso mude a versâo, recria o db, o correto seria neste caso ter scrits de migração ou apenas readequar a base atual
        sqLiteDatabase.execSQL("drop table uservideo;");
        onCreate(sqLiteDatabase);
    }

}
