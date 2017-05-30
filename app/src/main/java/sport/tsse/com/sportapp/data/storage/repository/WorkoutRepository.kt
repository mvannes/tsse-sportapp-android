package sport.tsse.com.sportapp.data.storage.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import sport.tsse.com.sportapp.data.Workout
import sport.tsse.com.sportapp.data.storage.DbSchema
import sport.tsse.com.sportapp.data.storage.database

/**
 * Created by mitchelldevries on 23/05/2017.
 */
class WorkoutRepository(context: Context) {

    companion object {

        private var instance: WorkoutRepository? = null

        @Synchronized
        fun getInstance(context: Context): WorkoutRepository {
            if (instance == null) {
                instance = WorkoutRepository(context)
            }

            return instance!!
        }
    }

    val database: SQLiteDatabase = context.database.writableDatabase
    val exerciseRepository = ExerciseRepository.getInstance(context)

    fun findAll() = queryWorkouts()

    fun findOne(id: Int) = queryWorkout(id)

    fun save(workout: Workout) {
        database.insert(DbSchema.WorkoutTable.NAME,
                DbSchema.WorkoutTable.Cols.ID to workout.id,
                DbSchema.WorkoutTable.Cols.NAME to workout.name,
                DbSchema.WorkoutTable.Cols.DESCRIPTION to workout.description)

        workout.exercises.forEach {
            database.insert(DbSchema.WorkoutExerciseTable.NAME,
                    DbSchema.WorkoutExerciseTable.Cols.WORKOUT_ID to workout.id,
                    DbSchema.WorkoutExerciseTable.Cols.EXERCISE_ID to it.id
            )
        }
    }

    fun save(workouts: List<Workout>) {
        workouts.forEach {
            save(it)
        }
    }

    fun update(workout: Workout) {
        database.update(DbSchema.WorkoutTable.NAME,
                DbSchema.WorkoutTable.Cols.NAME to workout.name,
                DbSchema.WorkoutTable.Cols.DESCRIPTION to workout.description)
                .where(DbSchema.WorkoutTable.Cols.ID + " = {workoutId}", "workoutId" to workout.id)
                .exec()
    }

    fun delete(id: Int) {
        database.delete(DbSchema.WorkoutTable.NAME,
                DbSchema.WorkoutTable.Cols.ID + " = {workoutId}", "workoutId" to id)
    }

    private fun queryWorkouts() = database.select(DbSchema.WorkoutTable.NAME).parseList(workoutParser())

    private fun queryWorkout(id: Int)
            = database
            .select(DbSchema.WorkoutTable.NAME)
            .where(DbSchema.WorkoutTable.Cols.ID + " = {workoutId}", "workoutId" to id)
            .parseOpt(workoutParser())

    private fun workoutParser(): RowParser<Workout> {
        return rowParser {
            id: Int, name: String, description: String ->
            Workout(id, name, description, exerciseRepository.findExercisesForWorkout(id))
        }
    }
}
