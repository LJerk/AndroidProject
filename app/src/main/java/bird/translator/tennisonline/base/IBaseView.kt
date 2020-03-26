package bird.translator.tennisonline.base

import com.arellomobile.mvp.MvpView

interface IBaseView : MvpView {

    fun lock()
    fun unlock()
    fun onSuccess(message: String)
    fun onError(message: String)
}