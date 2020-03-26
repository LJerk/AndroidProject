package bird.translator.tennisonline.presentation.credentials.loading

import com.arellomobile.mvp.MvpView

interface ILoadingView : MvpView {

    fun onLoadingComplete()
}