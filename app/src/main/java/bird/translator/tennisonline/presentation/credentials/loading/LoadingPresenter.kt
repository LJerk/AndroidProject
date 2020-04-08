package bird.translator.tennisonline.presentation.credentials.loading

import android.os.Handler
import bird.translator.tennisonline.domain.repositories.UserRepository
import bird.translator.tennisonline.presentation.main.MainActivity
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject


@InjectViewState
class LoadingPresenter : MvpPresenter<ILoadingView> {

    private val userRepository: UserRepository

    @Inject
    constructor(userRepository: UserRepository) {
        this.userRepository = userRepository
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadStaticResources()
    }

    fun loadStaticResources() {
        Handler().postDelayed({

            val user = userRepository.getUser()
            if (user != null) {
                MainActivity.show()
                return@postDelayed
            }

            viewState.showAuth()

        }, 2000)
    }
}