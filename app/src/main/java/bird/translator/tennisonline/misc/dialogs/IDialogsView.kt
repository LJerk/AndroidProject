package bird.translator.tennisonline.misc.dialogs

import bird.translator.tennisonline.domain.repositories.models.DialogItem
import com.arellomobile.mvp.MvpView

interface IDialogsView : MvpView {

    fun bindDialogs(dialogs: List<DialogItem>)
}