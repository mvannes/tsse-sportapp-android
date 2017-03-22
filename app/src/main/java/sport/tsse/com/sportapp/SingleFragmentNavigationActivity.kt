package sport.tsse.com.sportapp

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.fragment_exercise_detail.*
import sport.tsse.com.sportapp.exercise.list.ExerciseListFragment
import sport.tsse.com.sportapp.home.HomeFragment
import sport.tsse.com.sportapp.schedule.list.ScheduleListFragment

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
        replaceFragment(HomeFragment())
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // TODO: Uncomment navigation cases.
        val id = item.itemId

        when (id) {
            R.id.nav_home -> {
                replaceFragment(HomeFragment())
                replaceTitle(getString(R.string.home))
            }
            R.id.nav_schedules -> {
                replaceFragment(ScheduleListFragment())
                replaceTitle(getString(R.string.schedules))
            }
            R.id.nav_workouts -> {
//                replaceFragment(WorkoutListFragment())
                replaceTitle(getString(R.string.workouts))
            }
            R.id.nav_exercises -> {
                replaceFragment(ExerciseListFragment())
                replaceTitle(getString(R.string.exercises))
            }
            R.id.nav_statistics -> {
//            replaceFragment(StatisticsFragment())
                replaceTitle(getString(R.string.statistics))
            }
            R.id.nav_settings -> {
//                replaceFragment(AccountSettingsFragment())
                replaceTitle(getString(R.string.settings))
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }

    private fun replaceTitle(title: String) {
        supportActionBar?.title = title
    }
}