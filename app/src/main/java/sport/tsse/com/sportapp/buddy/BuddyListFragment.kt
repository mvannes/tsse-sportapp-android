package sport.tsse.com.sportapp.buddy

import android.content.res.Resources
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.*
import com.mindorks.placeholderview.SwipeDecor
import kotlinx.android.synthetic.main.fragment_buddy_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.data.User
import sport.tsse.com.sportapp.network.Api


/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class BuddyListFragment : Fragment(), Callback<List<User>> {
    var users = emptyList<User>()

    override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
        if (response?.isSuccessful!!) {
            users = response.body()
        }
        updateView()
    }

    override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_buddy_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val api = Api()
        api.service.getAllUsers().enqueue(this)

        updateView()
    }

    fun updateView() {

        val bottomMargin = dpToPx(160)
        val windowSize = getDisplaySize((context as AppCompatActivity).windowManager)

        swipeView.builder
                .setDisplayViewCount(3)
                .setSwipeDecor(SwipeDecor()
                        .setPaddingTop(40)
                        .setRelativeScale(0.01f)
                        .setViewWidth(windowSize.x)
                        .setViewHeight((windowSize.y - bottomMargin).toInt())
                        .setViewGravity(Gravity.TOP)
                )

        users.forEach { swipeView.addView(BuddyCard(context, it, swipeView)) }

        rejectBtn.setOnClickListener { swipeView.doSwipe(false) }
        acceptBtn.setOnClickListener { swipeView.doSwipe(true) }
    }

    fun getDisplaySize(windowManager: WindowManager): Point {
        try {
            if (Build.VERSION.SDK_INT > 16) {
                val display = windowManager.defaultDisplay
                val displayMetrics = DisplayMetrics()
                display.getMetrics(displayMetrics)
                return Point(displayMetrics.widthPixels, displayMetrics.heightPixels)
            } else {
                return Point(0, 0)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return Point(0, 0)
        }

    }

    fun dpToPx(dp: Int): Float {
        return (dp * Resources.getSystem().displayMetrics.density)
    }
}