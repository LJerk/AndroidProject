package bird.translator.tennisonline.presentation.credentials.auth

import bird.translator.tennisonline.base.SubRX
import bird.translator.tennisonline.domain.repositories.UserRepository
import bird.translator.tennisonline.presentation.main.MainActivity
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class AuthPresenter : MvpPresenter<IAuthView> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor()

    fun auth(login: String, password: String) {

        userRepository.login(SubRX { _, e ->

            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }

            MainActivity.show()
        }, login, password)
    }
}