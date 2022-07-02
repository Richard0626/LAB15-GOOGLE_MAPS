package com.fernandez.practica2.home
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.fernandez.practica2.R
import com.fernandez.practica2.comida.ComidaFragment

class HomeActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val actionBar = supportActionBar
        getActionBar()
        actionBar?.setDisplayShowHomeEnabled(true)
        title="Platos D'Marco"
        openFragment(ComidaFragment.newInstance())

    }
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContent,fragment)
        transaction.commit()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        setIcon(menu?.findItem(R.id.item_phone)!!)
        return super.onCreateOptionsMenu(menu)
    }
    private fun setIcon(menuItem: MenuItem){
        val id = R.drawable.icon_phone
        menuItem.icon = ContextCompat.getDrawable(this,id)
    }
}
