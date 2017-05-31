package sport.tsse.com.sportapp.buddy

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.User

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
@Layout(R.layout.list_item_buddy)
class BuddyCard(val context: Context,
                val user: User,
                val swipeView: SwipePlaceHolderView) {

    @View(R.id.profileImageView)
    private val profileImageView: ImageView? = null

    @View(R.id.nameAgeTxt)
    private val nameAgeTxt: TextView? = null

    @View(R.id.locationNameTxt)
    private val locationNameTxt: TextView? = null

    @Resolve
    private fun onResolved() {
        if (user.username == "Meter Peijer") {
            profileImageView?.setImageDrawable(context.resources.getDrawable(R.drawable.peter))
        } else {
            profileImageView?.setImageDrawable(context.resources.getDrawable(R.drawable.buddy_image_placeholder))
        }

        nameAgeTxt?.text = (user.username + ", " + 42)
        locationNameTxt?.text = "Amsterdam"
    }

    @SwipeOut
    private fun onSwipedOut() {
        Log.d("EVENT", "onSwipedOut")
        swipeView.addView(this)
    }

    @SwipeCancelState
    private fun onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState")
    }

    @SwipeIn
    private fun onSwipeIn() {
        Log.d("EVENT", "onSwipedIn")
    }

    @SwipeInState
    private fun onSwipeInState() {
        Log.d("EVENT", "onSwipeInState")
    }

    @SwipeOutState
    private fun onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState")
    }
}