package sport.tsse.com.sportapp.data.storage

/**
 * Created by mitchelldevries on 26/05/2017.
 */
class DbSchema {

    class ExerciseTable {
        companion object {
            val NAME = "exercises"
        }

        class Cols {
            companion object {
                val ID = "id"
                val NAME = "name"
                val DESCRIPTION = "description"
                val CATEGORY = "category"
                val FAVORITE = "favorite"
                val IMAGE_URL = "img_url"
            }
        }
    }

    class WorkoutTable {
        companion object {
            val NAME = "workouts"
        }

        class Cols {
            companion object {
                val ID = "id"
                val NAME = "name"
                val DESCRIPTION = "description"
            }
        }
    }

    class WorkoutExerciseTable {
        companion object {
            val NAME = "workout_exercises"
        }

        class Cols {
            companion object {
                val ID = "id"
                val WORKOUT_ID = "workout_id"
                val EXERCISE_ID = "exercise_id"
            }
        }
    }
}