package sport.tsse.com.sportapp.data

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
data class Exercise(
        val id: Int,
        val name: String,
        val description: String,
        val category: String,
        var favorite: Int)