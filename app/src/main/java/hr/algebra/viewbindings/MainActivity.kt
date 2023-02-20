package hr.algebra.viewbindings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hr.algebra.viewbindings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate( savedInstanceState )
        binding = ActivityMainBinding.inflate( layoutInflater )
        val view = binding.root
        setContentView( view )

        setupListeners( )
    }

    fun setupListeners( ) {
        binding.bLogin.setOnClickListener {
            if( binding.etFirst.text.toString( ).isEmpty( ) || binding.etSecond.text.toString( ).isEmpty( ) )
                Toast
                    .makeText( this, "Something is missing", Toast.LENGTH_SHORT )
                    .show( )
            else
                Toast
                    .makeText( this, "Successfuly logged in", Toast.LENGTH_SHORT )
                    .show( )
        }

        binding.bFragment.setOnClickListener {
            supportFragmentManager
                .beginTransaction( )
                .add( R.id.frameLayout, YellowFragment( ) )
                .commit( )
        }
    }
}