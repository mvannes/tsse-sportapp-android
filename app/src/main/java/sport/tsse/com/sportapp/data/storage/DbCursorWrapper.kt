package sport.tsse.com.sportapp.data.storage

import android.database.Cursor
import android.database.CursorWrapper
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.Workout
import sport.tsse.com.sportapp.data.storage.DbSchema.ExerciseTable

/**
 * Created by mitchelldevries on 26/05/2017.
 */
class DbCursorWrapper(cursor: Cursor) : CursorWrapper(cursor) {

    fun getExercise(): Exercise {
        val id = getInt(getColumnIndex(ExerciseTable.Cols.ID))
        val name = getString(getColumnIndex(ExerciseTable.Cols.NAME))
        val description = getString(getColumnIndex(ExerciseTable.Cols.DESCRIPTION))
        val category = getString(getColumnIndex(ExerciseTable.Cols.CATEGORY))

        return Exercise(id, name, description, category)
    }

    fun getWorkout(): Workout {
        val id = getInt(getColumnIndex(ExerciseTable.Cols.ID))
        val name = getString(getColumnIndex(ExerciseTable.Cols.NAME))
        val description = getString(getColumnIndex(ExerciseTable.Cols.DESCRIPTION))

        return Workout(id, name, description, null)
    }
}