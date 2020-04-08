package bird.translator.tennisonline.presentation.credentials.loading

import bird.translator.tennisonline.R
import bird.translator.tennisonline.base.ABaseFragment
import bird.translator.tennisonline.domain.di.components.DaggerAppComponent
import bird.translator.tennisonline.presentation.credentials.ICredentialsRouter
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject

class LoadingFragment : ABaseFragment(), ILoadingView {

    @Inject
    @InjectPresenter
    lateinit var presenter: LoadingPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun getViewId() = R.layout.fragment_loading

    override fun showAuth() {
        activity?.let {
            if (it is ICredentialsRouter)
                it.showAuth()
        }
    }
}