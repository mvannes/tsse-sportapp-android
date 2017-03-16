package sport.tsse.com.sportapp.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sport.tsse.com.sportapp.R

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val homeView = inflater?.inflate(R.layout.fragment_home, container, false)

        return homeView
    }
}