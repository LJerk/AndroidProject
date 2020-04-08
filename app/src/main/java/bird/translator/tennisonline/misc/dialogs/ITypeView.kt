package bird.translator.tennisonline.misc.dialogs

import bird.translator.tennisonline.domain.repositories.models.DialogItem

interface ITypeView {
    fun bind(data: DialogItem)
}