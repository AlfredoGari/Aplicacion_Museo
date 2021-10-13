package com.example.museo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.museo.databinding.ActivityCrearUsuarioBinding
import com.example.museo.databinding.ActivityNavigationUserBinding
import com.example.museo.databinding.ActivitySplashBinding
import com.google.android.material.navigation.NavigationView
import com.google.zxing.integration.android.IntentIntegrator

class navigation_user : AppCompatActivity() {
    lateinit var toogle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var binding: ActivityNavigationUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val objetoIntent: Intent = intent
        val persona: Usuario
        persona = intent.getSerializableExtra("dato") as Usuario
        drawerLayout = findViewById(R.id.drawerLayout)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        val navigationView : NavigationView  = findViewById(R.id.nav_view)
        val headerView : View = navigationView.getHeaderView(0)
        val navUsername : TextView = headerView.findViewById(R.id.txtuser)
        val navcorreo : TextView = headerView.findViewById(R.id.txtcorreo)
        val abrir: Intent =Intent(this, MainActivity::class.java)
        navUsername.text = persona.usua.toString()
        navcorreo.text = persona.ema.toString()




        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        navView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.nav_home ->replaceFragment(HomeFragment(), it.title.toString())
                R.id.nav_fav ->replaceFragment(FavoriteFragment() , it.title.toString())
                R.id.nav_cs ->{
                    startActivity(abrir)
                    finish()
                }
                R.id.nav_ema ->{
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("museum@gmail.com"))
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Apreciación")
                    intent.putExtra(Intent.EXTRA_TEXT, "Me gustaria realizar la siguiente apreciación:")
                    startActivity(intent)
                }
                R.id.nav_qr ->{
                    initScanner()
                }


            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun initScanner(){
       val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Escanea")
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        if(result != null){
            if(result.contents ==null){

            }else{
                Toast.makeText(this, "El valor escaneado es: ${result.contents}", Toast.LENGTH_SHORT).show()
            }

        }else{

            super.onActivityResult(requestCode, resultCode, data)

        }



    }
}