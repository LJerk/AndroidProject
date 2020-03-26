package bird.translator.tennisonline.presentation.credentials

import android.content.Intent
import android.os.Bundle
import bird.translator.tennisonline.App
import bird.translator.tennisonline.R
import bird.translator.tennisonline.base.ABaseActivity
import bird.translator.tennisonline.domain.repositories.local.UserStorage
import bird.translator.tennisonline.presentation.credentials.auth.AuthFragment
import bird.translator.tennisonline.presentation.credentials.loading.LoadingFragment
import bird.translator.tennisonline.presentation.credentials.registration.RegistrationFragment

//@Layout(R.layout.)
class CredentialsActivity : ABaseActivity(), ICredentialsRouter {

    companion object {

        private const val ARG_DROP_CREDENTIALS = "ARG_DROP_CREDENTIALS"

        fun show() {
            App.appContext.let {
                it.startActivity(Intent(it, CredentialsActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra(ARG_DROP_CREDENTIALS, true)
                })
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        if (savedInstanceState != null)
            return

        // Немного не верно с т.з. архитектуры, но тут больше и не нужно
        if (intent.getBooleanExtra(ARG_DROP_CREDENTIALS, false)) {
            UserStorage().dropCredentials()
            showAuth()
            return
        }

        showLoading()
    }

    override fun showLoading() {
        replace(LoadingFragment())
    }

    override fun showRegistration() {
        replace(RegistrationFragment(), "Registration")
    }

    override fun showAuth() {
        replace(AuthFragment())
    }
}