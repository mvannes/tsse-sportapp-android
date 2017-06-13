package sport.tsse.com.sportapp.data.storage.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import org.jetbrains.anko.db.*
import sport.tsse.com.sportapp.data.Exercise
import sport.tsse.com.sportapp.data.storage.DbSchema
import sport.tsse.com.sportapp.data.storage.DbSchema.ExerciseTable
import sport.tsse.com.sportapp.data.storage.database

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class ExerciseRepository(context: Context) {

    companion object {

        private var instance: ExerciseRepository? = null

        @Synchronized
        fun getInstance(context: Context): ExerciseRepository {
            if (instance == null) {
                instance = ExerciseRepository(context)
            }

            return instance!!
        }
    }

    val database: SQLiteDatabase = context.database.writableDatabase

    fun findAll() = queryExercises()

    fun findOne(id: Int) = queryExercise(id)

    fun save(exercise: Exercise) {
        database.insert(ExerciseTable.NAME,
                ExerciseTable.Cols.ID to exercise.id,
                ExerciseTable.Cols.NAME to exercise.name,
                ExerciseTable.Cols.DESCRIPTION to exercise.description,
                ExerciseTable.Cols.CATEGORY to exercise.category,
                ExerciseTable.Cols.FAVORITE to exercise.favorite
        )
    }

    fun save(exercises: List<Exercise>) {
        exercises.forEach {
            save(it)
        }
    }

    fun update(exercise: Exercise) {
        Log.d("TAG update():", exercise.toString())
        database.update(ExerciseTable.NAME,
                ExerciseTable.Cols.NAME to exercise.name,
                ExerciseTable.Cols.DESCRIPTION to exercise.description,
                ExerciseTable.Cols.CATEGORY to exercise.category,
                ExerciseTable.Cols.FAVORITE to exercise.favorite)
                .where(ExerciseTable.Cols.ID + " = {exerciseId}", "exerciseId" to exercise.id)
                .exec()
    }

    fun delete(id: Int) {
        database.delete(ExerciseTable.NAME,
                ExerciseTable.Cols.ID + " = {exerciseId}", "exerciseId" to id)
    }

    fun findExercisesForWorkout(id: Int)
            = database.rawQuery("SELECT e.id, e.name, e.description, e.category, e.favorite " +
            "FROM " + DbSchema.ExerciseTable.NAME + " e " +
            "LEFT JOIN " + DbSchema.WorkoutExerciseTable.NAME + " we ON " +
            "we." + DbSchema.WorkoutExerciseTable.Cols.EXERCISE_ID + " = " +
            "e." + DbSchema.ExerciseTable.Cols.ID +
            " WHERE we." + DbSchema.WorkoutExerciseTable.Cols.WORKOUT_ID + " = " + id, null
    ).parseList(exerciseParser()).distinct()


    private fun queryExercises() = database.select(ExerciseTable.NAME).parseList(exerciseParser())

    private fun queryExercise(id: Int)
            = database
            .select(ExerciseTable.NAME)
            .where(ExerciseTable.Cols.ID + " = {exerciseId}", "exerciseId" to id)
            .parseOpt(exerciseParser())

    private fun exerciseParser(): RowParser<Exercise> {
        return rowParser {
            id: Int, name: String, description: String, category: String, favorite: Int ->
            Exercise(id, name, description, category, favorite)
        }
    }
}
