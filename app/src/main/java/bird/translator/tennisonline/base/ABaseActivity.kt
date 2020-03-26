package bird.translator.tennisonline.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import bird.translator.tennisonline.R

abstract class ABaseActivity: AppCompatActivity() {
    fun replace(fragment: Fragment, backstack: String? = null, tag: String? = null){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, tag).apply{
                backstack?.let{addToBackStack(it)}
            }
            .commit()
    }
}