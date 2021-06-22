package com.alesha.dashboardframe.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.alesha.dashboardframe.R
import com.alesha.dashboardframe.databinding.ContentMainBinding
import com.alesha.dashboardframe.main.view.fragments.HomeFragment
import com.alesha.dashboardframe.main.view.fragments.PageOneFragment
import com.alesha.dashboardframe.main.view.fragments.PageThreeFragment
import com.alesha.dashboardframe.main.view.fragments.PageTwoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{
    private lateinit var binding: ContentMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ContentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.includeLayout.toolbarMain)

        initNavigationMenu()
        binding.navView.setNavigationItemSelectedListener(this)
        replaceFragment(HomeFragment(), "home")

        binding.includeLayout.bottomNavId.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navHome -> {
                    //tvBookStatus.setVisibility(View.VISIBLE);
                    clearAllFragment()
                    replaceFragment(HomeFragment(), "home")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navPage1 -> {
                    //tvBookStatus.setVisibility(View.VISIBLE);
                    clearAllFragment()
                    replaceFragment(PageOneFragment(), "home")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navPage2 -> {
                    //tvBookStatus.setVisibility(View.VISIBLE);
                    clearAllFragment()
                    replaceFragment(PageTwoFragment(), "home")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navPage3 -> {
                    //tvBookStatus.setVisibility(View.VISIBLE);
                    clearAllFragment()
                    replaceFragment(PageThreeFragment(), "home")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })


    }

    private fun initNavigationMenu() {

        val toggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.includeLayout.toolbarMain,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }
        }
        binding.drawerLayout!!.setDrawerListener(toggle)
        toggle.syncState()

        // open drawer at start
        //drawer.openDrawer(GravityCompat.START)
    }

    fun replaceFragment(fragment: Fragment?, tag: String?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment!!, tag)
            .addToBackStack(null)
        transaction.commit()
    }

    private fun clearAllFragment() {
        val fragmentManager = supportFragmentManager
        for (i in 0 until fragmentManager.backStackEntryCount) {
            fragmentManager.popBackStack()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                clearAllFragment()
                replaceFragment(HomeFragment(), "home")
                binding.drawerLayout!!.closeDrawer(GravityCompat.START)
            }
            R.id.nav_gallery -> {
                clearAllFragment()
                replaceFragment(HomeFragment(), "home")
                binding.drawerLayout!!.closeDrawer(GravityCompat.START)
            }
            R.id.nav_slideshow -> {
                clearAllFragment()
                replaceFragment(HomeFragment(), "home")
                binding.drawerLayout!!.closeDrawer(GravityCompat.START)
            }

        }
        return true
    }


}