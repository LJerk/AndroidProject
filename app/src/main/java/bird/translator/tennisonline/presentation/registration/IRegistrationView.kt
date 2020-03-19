package bird.translator.tennisonline.presentation.registration

import com.arellomobile.mvp.MvpView

interface IRegistrationView : MvpView {

    fun showError(message: String)
}