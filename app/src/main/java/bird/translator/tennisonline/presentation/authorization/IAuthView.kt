package bird.translator.tennisonline.presentation.authorization

import com.arellomobile.mvp.MvpView

interface IAuthView: MvpView {

    fun showError(message: String)
}