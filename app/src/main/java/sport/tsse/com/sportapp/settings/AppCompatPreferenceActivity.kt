package sport.tsse.com.sportapp.settings

import android.content.res.Configuration
import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.annotation.LayoutRes
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup

/**
 * A [android.preference.PreferenceActivity] which implements and proxies the necessary calls
 * to be used with AppCompat.
 */
abstract class AppCompatPreferenceActivity : android.preference.PreferenceActivity() {

    private var mDelegate: android.support.v7.app.AppCompatDelegate? = null

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        delegate.installViewFactory()
        delegate.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: android.os.Bundle?) {
        super.onPostCreate(savedInstanceState)
        delegate.onPostCreate(savedInstanceState)
    }

    val supportActionBar: android.support.v7.app.ActionBar
        get() = delegate.supportActionBar!!

    fun setSupportActionBar(toolbar: android.support.v7.widget.Toolbar?) {
        delegate.setSupportActionBar(toolbar)
    }

    override fun getMenuInflater(): android.view.MenuInflater {
        return delegate.menuInflater
    }

    override fun setContentView(@android.support.annotation.LayoutRes layoutResID: Int) {
        delegate.setContentView(layoutResID)
    }

    override fun setContentView(view: android.view.View) {
        delegate.setContentView(view)
    }

    override fun setContentView(view: android.view.View, params: android.view.ViewGroup.LayoutParams) {
        delegate.setContentView(view, params)
    }

    override fun addContentView(view: android.view.View, params: android.view.ViewGroup.LayoutParams) {
        delegate.addContentView(view, params)
    }

    override fun onPostResume() {
        super.onPostResume()
        delegate.onPostResume()
    }

    override fun onTitleChanged(title: CharSequence, color: Int) {
        super.onTitleChanged(title, color)
        delegate.setTitle(title)
    }

    override fun onConfigurationChanged(newConfig: android.content.res.Configuration) {
        super.onConfigurationChanged(newConfig)
        delegate.onConfigurationChanged(newConfig)
    }

    override fun onStop() {
        super.onStop()
        delegate.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        delegate.onDestroy()
    }

    override fun invalidateOptionsMenu() {
        delegate.invalidateOptionsMenu()
    }

    private val delegate: android.support.v7.app.AppCompatDelegate
        get() {
            if (mDelegate == null) {
                mDelegate = android.support.v7.app.AppCompatDelegate.create(this, null)
            }
            return mDelegate!!
        }
}
