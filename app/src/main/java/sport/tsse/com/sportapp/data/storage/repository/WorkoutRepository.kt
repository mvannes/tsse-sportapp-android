package sport.tsse.com.sportapp.data.storage.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import sport.tsse.com.sportapp.data.Workout
import sport.tsse.com.sportapp.data.storage.DbCursorWrapper
import sport.tsse.com.sportapp.data.storage.DbHelper
import sport.tsse.com.sportapp.data.storage.DbSchema
import sport.tsse.com.sportapp.data.storage.DbSchema.WorkoutTable

/**
 * Created by mitchelldevries on 23/05/2017.
 */
class WorkoutRepository(context: Context) {

    val database: SQLiteDatabase = DbHelper(context).writableDatabase
    val exerciseRepository = ExerciseRepository(context)

    fun findAll(): List<Workout> {
        val workouts = ArrayList<Workout>()

        val cursor = queryWorkouts(null, null)

        try {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                val workout = cursor.getWorkout()
                val exercises = exerciseRepository.findAllForWorkout(workout.id)
                if (exercises.isNotEmpty()) {
                    workout.exercises = exercises
                }

                workouts.add(workout)
                cursor.moveToNext()
            }
        } finally {
            cursor.close()
        }

        return workouts
    }

    fun findOne(id: Int): Workout? {
        val cursor = queryWorkouts(WorkoutTable.Cols.ID + "=" + id, null) //TODO FIX, Mitchell de Vries

        try {
            if (cursor.count == 0) {
                return null
            }

            cursor.moveToFirst()
            val workout = cursor.getWorkout()
            val exercises = exerciseRepository.findAllForWorkout(workout.id)
            workout.exercises = exercises

            return workout
        } finally {
            cursor.close()
        }
    }

    fun save(workout: Workout) {
        val values = getValues(workout)
        database.insert(WorkoutTable.NAME, null, values)
    }

    fun update(workout: Workout) {
        val values = getValues(workout)

        database.update(WorkoutTable.NAME, values, WorkoutTable.Cols.ID + " = ?",
                Array(1, { workout.id.toString() }))
    }

    fun delete(id: Int) {
        database.delete(WorkoutTable.NAME, WorkoutTable.Cols.ID + " = ?",
                Array(1, { id.toString() }))
    }

    fun isEmpty() = findAll().isEmpty()

    private fun getValues(workout: Workout): ContentValues {
        val values = ContentValues()
        values.put(WorkoutTable.Cols.ID, workout.id)
        values.put(WorkoutTable.Cols.NAME, workout.name)
        values.put(WorkoutTable.Cols.DESCRIPTION, workout.description)

        return values
    }

    private fun queryWorkouts(whereClause: String?, whereArgs: Array<String>?): DbCursorWrapper {
        val cursor = database.query(
                DbSchema.WorkoutTable.NAME,
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
