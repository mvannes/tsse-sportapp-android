package sport.tsse.com.sportapp.data.storage

import android.database.Cursor
import android.database.sqlite.SQLiteCursor
import android.database.sqlite.SQLiteCursorDriver
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteQuery
import android.util.Log

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class SQLiteCursorFactory : SQLiteDatabase.CursorFactory{

    companion object {
        val TAG = SQLiteCursorFactory::class.java.simpleName
    }

    override fun newCursor(db: SQLiteDatabase?, masterQuery: SQLiteCursorDriver?, editTable: String?, query: SQLiteQuery?): Cursor {
        Log.d(TAG, query?.toString() + "table $editTable")

        return SQLiteCursor(masterQuery, editTable, query)
    }
}