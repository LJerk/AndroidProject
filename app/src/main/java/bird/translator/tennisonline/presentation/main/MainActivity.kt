package bird.translator.tennisonline.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bird.translator.tennisonline.App
import bird.translator.tennisonline.R
import bird.translator.tennisonline.presentation.credentials.CredentialsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
            return // Не будем пересоздавать фрагмент, пусть берется старый из стека

        btnLogout.setOnClickListener {
            CredentialsActivity.show()
        }
    }
}
