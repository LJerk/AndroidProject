package bird.translator.tennisonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bird.translator.tennisonline.presentation.registration.RegistrationFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
            return // Не будем пересоздавать фрагмент, пусть берется старый из стека

        supportFragmentManager.beginTransaction()
            .replace(R.id.container,
                RegistrationFragment()
            )
            .commit()
    }
}
