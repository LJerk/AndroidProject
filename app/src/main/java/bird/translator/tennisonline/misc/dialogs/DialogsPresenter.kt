package bird.translator.tennisonline.misc.dialogs

import bird.translator.tennisonline.domain.repositories.DialogsRepository
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class DialogsPresenter : MvpPresenter<IDialogsView> {

    private val repository: DialogsRepository

    @Inject
    constructor(repository: DialogsRepository) {
        this.repository = repository
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        repository.loadDialogs {
            viewState.bindDialogs(it)
        }
    }
}