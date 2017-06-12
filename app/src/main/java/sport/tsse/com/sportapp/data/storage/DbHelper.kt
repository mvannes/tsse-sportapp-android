package sport.tsse.com.sportapp.data.storage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import sport.tsse.com.sportapp.data.storage.DbSchema.*

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class DbHelper(context: Context) : ManagedSQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object {
        val NAME = "sport.db"
        val VERSION = 1

        private var instance: DbHelper? = null

        @Synchronized
        fun getInstance(context: Context): DbHelper {
            if (instance == null) {
                instance = DbHelper(context)
            }

            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        createExerciseTable(db)
        createWorkoutTable(db)
        createWorkoutExercisesTable(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(ExerciseTable.NAME, true)
        db?.dropTable(WorkoutTable.NAME, true)
        onCreate(db)
    }

    private fun createExerciseTable(db: SQLiteDatabase?) {
        db?.createTable(ExerciseTable.NAME, true,
                ExerciseTable.Cols.ID to INTEGER + PRIMARY_KEY + UNIQUE,
                ExerciseTable.Cols.NAME to TEXT,
                ExerciseTable.Cols.DESCRIPTION to TEXT,
                ExerciseTable.Cols.CATEGORY to TEXT,
                ExerciseTable.Cols.FAVORITE to INTEGER + DEFAULT("0"),
                ExerciseTable.Cols.IMAGE_URL to TEXT
                )
    }

    private fun createWorkoutTable(db: SQLiteDatabase?) {
        db?.createTable(WorkoutTable.NAME, true,
                WorkoutTable.Cols.ID to INTEGER + PRIMARY_KEY + UNIQUE,
                WorkoutTable.Cols.NAME to TEXT,
                WorkoutTable.Cols.DESCRIPTION to TEXT
        )
    }

    private fun createWorkoutExercisesTable(db: SQLiteDatabase?) {
        db?.createTable(WorkoutExerciseTable.NAME, true,
                WorkoutExerciseTable.Cols.ID to INTEGER + PRIMARY_KEY + UNIQUE,
                WorkoutExerciseTable.Cols.WORKOUT_ID to INTEGER,
                WorkoutExerciseTable.Cols.EXERCISE_ID to INTEGER,
                "" to FOREIGN_KEY(
                        WorkoutExerciseTable.Cols.WORKOUT_ID,
                        WorkoutTable.NAME,
                        WorkoutTable.Cols.ID),
                "" to FOREIGN_KEY(
                        WorkoutExerciseTable.Cols.EXERCISE_ID,
                        ExerciseTable.NAME,
                        ExerciseTable.Cols.ID)

        )
    }
}

val Context.database: DbHelper
    get() = DbHelper.getInstance(applicationContext)