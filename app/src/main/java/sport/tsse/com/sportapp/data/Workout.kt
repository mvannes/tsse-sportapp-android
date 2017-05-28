package sport.tsse.com.sportapp.data

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
data class Workout(val id: Int,
                   val name: String,
                   val description: String,
                   var exercises: List<Exercise>?)