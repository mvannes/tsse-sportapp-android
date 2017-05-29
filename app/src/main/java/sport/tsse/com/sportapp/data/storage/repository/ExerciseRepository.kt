package sport.tsse.com.sportapp.data.storage.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.RowParser
import org.jetbrains.anko.db.rowParser
import org.jetbrains.anko.db.select
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.storage.DbCursorWrapper
import sport.tsse.com.sportapp.data.storage.DbSchema.ExerciseTable
import sport.tsse.com.sportapp.data.storage.SQLiteCursorFactory
import sport.tsse.com.sportapp.data.storage.database

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseRepository(context: Context) {

    val database: SQLiteDatabase = context.database.writableDatabase

    fun findAll() = queryExercises()

    fun findAllForWorkout(id: Int) = queryExercises()

    fun findOne(id: Int) = queryExercise(id)

    fun save(exercise: Exercise) {
        val values = getValues(exercise)
        database.insert(ExerciseTable.NAME, null, values)
    }

    fun update(exercise: Exercise) {
        val values = getValues(exercise)

        database.update(ExerciseTable.NAME, values, ExerciseTable.Cols.ID + " =?",
                arrayOf(exercise.id.toString()))
    }

    fun delete(id: Int) {
        database.delete(ExerciseTable.NAME, ExerciseTable.Cols.ID + " =?",
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

    private fun queryExercises() = database.select(ExerciseTable.NAME).parseList(exerciseParser())

    private fun queryExercise(id: Int)
            = database
            .select(ExerciseTable.NAME)
            .where(ExerciseTable.Cols.ID + " = {exerciseId}", "exerciseId" to id)
            .parseOpt(exerciseParser())

    private fun exerciseParser(): RowParser<Exercise> {
        return rowParser {
            id: Int, name: String, description: String, category: String, workoutId: Int? ->
            Exercise(id, name, description, category)
        }
    }
}
