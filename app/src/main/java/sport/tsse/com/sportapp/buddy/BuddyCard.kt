package sport.tsse.com.sportapp.buddy

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
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
        Log.d("TAG", "RESOLVED!!")
        if (user.displayName == "M") {
            Glide.with(context).load("https://randomuser.me/api/portraits/men/" + user.id + ".jpg").into(profileImageView)
        } else {
            Glide.with(context).load("https://randomuser.me/api/portraits/women/" + user.id + ".jpg").into(profileImageView)
        }

        nameAgeTxt?.text = (user.username)
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