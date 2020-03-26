package bird.translator.tennisonline.presentation.credentials.auth

import android.os.Bundle
import android.view.View
import bird.translator.tennisonline.R
import bird.translator.tennisonline.base.ABaseFragment
import bird.translator.tennisonline.domain.di.components.DaggerAppComponent
import bird.translator.tennisonline.presentation.credentials.ICredentialsRouter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_auth.*
import kotlinx.android.synthetic.main.fragment_registration.*
import javax.inject.Inject

class AuthFragment : ABaseFragment(), IAuthView {

    @Inject
    @InjectPresenter
    lateinit var presenter: AuthPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId() = R.layout.fragment_auth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {

            val login = "${etLogin.text}" // "null"
            val password = "${etPassword.text}"

            if (login.isEmpty() || password.isEmpty()) {
                toast(R.string.error_login_passwd_undefined)
                return@setOnClickListener
            }

            presenter.auth(login, password)
        }

        btnRegistration.setOnClickListener {
            activity?.let {
                if (it is ICredentialsRouter)
                    it.showRegistration()
            }
        }
    }

    override fun lock() {
        visibility(flBtnContainer)
    }

    override fun unlock() {
        visibility(flBtnContainer, false)
    }

    override fun onSuccess() {
        toast("SUCCESS")
        // Отправить на главную форму
    }
}