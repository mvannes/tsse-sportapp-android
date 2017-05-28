package sport.tsse.com.sportapp.data.storage.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.storage.DbCursorWrapper
import sport.tsse.com.sportapp.data.storage.DbHelper
import sport.tsse.com.sportapp.data.storage.DbSchema.ExerciseTable

/**
* tsse-sportapp-android
*
* @author Mitchell de Vries
*/
class ExerciseRepository(context: Context) {

    val database: SQLiteDatabase = DbHelper(context).writableDatabase

    fun findAll(): List<Exercise> {
        val exercises = ArrayList<Exercise>()

        val cursor = queryExercises(null, null)

        try {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                exercises.add(cursor.getExercise())
                cursor.moveToNext()
            }
        } finally {
            cursor.close()
        }

        return exercises
    }

    fun findAllForWorkout(id: Int): List<Exercise> {
        val exercises = ArrayList<Exercise>()

        val cursor = queryExercises(ExerciseTable.Cols.WORKOUT_ID + "=" + id, null)

        try {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                exercises.add(cursor.getExercise())
                cursor.moveToNext()
            }
        } finally {
            cursor.close()
        }

        return exercises
    }

    fun findOne(id: Int): Exercise? {

        val cursor = queryExercises(ExerciseTable.Cols.ID + "=" + id, null) //TODO: Temporary Fix NOT SAFE!!, Mitchell de Vries

        try {
            if (cursor.count == 0) {
                return null
            }

            cursor.moveToFirst()
            return cursor.getExercise()
        } finally {
            cursor.close()
        }
    }

    fun save(exercise: Exercise) {
        val values = getValues(exercise)
        database.insert(ExerciseTable.NAME, null, values)
    }

    fun update(exercise: Exercise) {
        val values = getValues(exercise)

        database.update(ExerciseTable.NAME, values, ExerciseTable.Cols.ID + " = ?",
                Array(1, { exercise.id.toString() })) //TODO NEED FIX, Mitchell de Vries
    }

    fun delete(id: Int) {
        database.delete(ExerciseTable.NAME, ExerciseTable.Cols.ID + " = ?",
                Array(1, { id.toString() }))
    }

    fun isEmpty(): Boolean = findAll().isEmpty()

    private fun getValues(exercise: Exercise): ContentValues {
        val values = ContentValues()
        values.put(ExerciseTable.Cols.ID, exercise.id)
        values.put(ExerciseTable.Cols.NAME, exercise.name)
        values.put(ExerciseTable.Cols.DESCRIPTION, exercise.description)
        values.put(ExerciseTable.Cols.CATEGORY, exercise.category)

        return values
    }

    private fun queryExercises(whereClause: String?, whereArgs: Array<String>?): DbCursorWrapper {
        val cursor = database.query(
                ExerciseTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // Group By
                null, // Having
                null    // Order By
        )

        return DbCursorWrapper(cursor)
    }
}
