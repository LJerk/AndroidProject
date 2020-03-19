package bird.translator.tennisonline.presentation.registration

import bird.translator.tennisonline.repositories.UserRepository
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class RegistrationPresenter : MvpPresenter<IRegistrationView>() {

    //    @Inject
    var userRepository: UserRepository = UserRepository()

    fun registration(login: String, pass: String, mail: String) {

        // показать диалог блокировки

        userRepository.registration({

            // дилог блокировки убрать

            // Тут будет ответ
            // Если ОК, то отправляем на гл. экран
            // иначе показываем сообщение об ошибки
            viewState.showError(it)

        }, login, pass, mail)
    }
}