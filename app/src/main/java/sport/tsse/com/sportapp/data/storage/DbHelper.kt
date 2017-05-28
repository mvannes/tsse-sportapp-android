package sport.tsse.com.sportapp.data.storage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import sport.tsse.com.sportapp.data.storage.DbSchema.ExerciseTable
import sport.tsse.com.sportapp.data.storage.DbSchema.WorkoutTable

/**
 * Created by mitchelldevries on 26/05/2017.
 */
class DbHelper(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        val NAME = "sport.db"
        val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        createExerciseTable(db)
        createWorkoutTable(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + ExerciseTable.NAME)
        db?.execSQL("DROP TABLE IF EXISTS " + WorkoutTable.NAME)

        onCreate(db)
    }

    private fun createExerciseTable(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE " + ExerciseTable.NAME + "(" +
                ExerciseTable.Cols.ID + " primary key, " +
                ExerciseTable.Cols.NAME + ", " +
                ExerciseTable.Cols.DESCRIPTION + ", " +
                ExerciseTable.Cols.CATEGORY + ", " +
                ExerciseTable.Cols.WORKOUT_ID +
                ")"
        )
    }

    private fun createWorkoutTable(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE " + WorkoutTable.NAME + "(" +
                WorkoutTable.Cols.ID + " primary key, " +
                WorkoutTable.Cols.NAME + ", " +
                WorkoutTable.Cols.DESCRIPTION +
                ")"
        )
    }
}