package sport.tsse.com.sportapp.data

import java.io.Serializable
import java.util.*

/**
 * Created by mohammedali on 30/03/2017.
 */
data class User(val userId: Int,
                var birthdate: Date,
                var displayName: String,
                var enabled: Boolean,
                var firstName: String,
                var lastName: String,
                var password: String,
                var status: String,
                var username: String

) : Serializable {
    constructor() : this(0, Date(), "", false, "", "", "", "", "")
}