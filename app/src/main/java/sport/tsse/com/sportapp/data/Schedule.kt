package sport.tsse.com.sportapp.data

/**
 * @author Michael van Nes
 */
data class Schedule(val id: Long,
                    val name: String,
                    val description: String,
                    val workouts: List<String>, // TODO: make this a list of Workouts once Workout exists.
                    val amountOfTrainingsPerWeek: Int
)
