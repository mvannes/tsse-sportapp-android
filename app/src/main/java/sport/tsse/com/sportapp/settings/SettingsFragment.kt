package sport.tsse.com.sportapp.settings

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import sport.tsse.com.sportapp.R

/**
 * tsse-sportapp-android
 *
 * @author Mitchell de Vries
 */
class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }

}