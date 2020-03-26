package bird.translator.tennisonline.presentation.credentials.registration

import android.os.Bundle
import android.view.View
import bird.translator.tennisonline.R
import bird.translator.tennisonline.base.ABaseFragment
import bird.translator.tennisonline.domain.di.components.DaggerAppComponent
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_registration.*
import javax.inject.Inject

class RegistrationFragment : ABaseFragment(), IRegistrationView {

    @Inject
    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    @ProvidePresenter // Реализация для Dagger
    fun providePresenter() = presenter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId() = R.layout.fragment_registration

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRegistration.setOnClickListener {
            presenter.registration("${etLogin.text}", "${etPassword.text}")
        }
    }
}