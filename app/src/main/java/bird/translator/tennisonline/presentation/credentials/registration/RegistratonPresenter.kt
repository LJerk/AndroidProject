package bird.translator.tennisonline.presentation.credentials.registration

import bird.translator.tennisonline.base.SubRX
import bird.translator.tennisonline.domain.repositories.UserRepository
import bird.translator.tennisonline.presentation.main.MainActivity
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter : MvpPresenter<IRegistrationView> {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    constructor()

    fun registration(login: String, pass: String) {

        viewState.lock()
        userRepository.registration(SubRX { _, e ->
            viewState.unlock()

            if (e != null) {
                e.printStackTrace()
                viewState.onError(e.localizedMessage)
                return@SubRX
            }

            MainActivity.show()

        }, login, pass)
    }
}