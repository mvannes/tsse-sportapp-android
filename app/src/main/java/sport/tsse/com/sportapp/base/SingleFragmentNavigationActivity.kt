package sport.tsse.com.sportapp.base

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation.*
import sport.tsse.com.sportapp.R
import sport.tsse.com.sportapp.buddy.BuddyListFragment
import sport.tsse.com.sportapp.chat.ChatActivity
import sport.tsse.com.sportapp.exercise.list.ExerciseListFragment
import sport.tsse.com.sportapp.home.HomeFragment
import sport.tsse.com.sportapp.schedule.list.ScheduleListFragment
import sport.tsse.com.sportapp.settings.SettingsActivity
import sport.tsse.com.sportapp.workout.list.WorkoutListFragment

class SingleFragmentNavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        replaceFragment(HomeFragment(), getString(R.string.home))

        navView.menu.getItem(0).isChecked = true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // TODO: Uncomment navigation cases.
        val id = item.itemId

        when (id) {
            R.id.nav_home -> {
                replaceFragment(HomeFragment(), getString(R.string.home))
            }
            R.id.nav_schedules -> {
                replaceFragment(ScheduleListFragment(), getString(R.string.schedules))
            }
            R.id.nav_workouts -> {
                replaceFragment(WorkoutListFragment(), getString(R.string.workouts))
            }
            R.id.nav_exercises -> {
                replaceFragment(ExerciseListFragment(), getString(R.string.exercises))
            }
            R.id.nav_chat -> {
                startActivity(Intent(this, ChatActivity::class.java))
            }
            R.id.nav_buddies -> {
                replaceFragment(BuddyListFragment(), getString(R.string.buddies))
            }
            R.id.nav_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()

        supportActionBar?.title = title
    }
}
