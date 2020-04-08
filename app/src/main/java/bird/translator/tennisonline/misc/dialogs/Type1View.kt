package bird.translator.tennisonline.misc.dialogs


import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import bird.translator.tennisonline.R
import bird.translator.tennisonline.base.ABaseView
import bird.translator.tennisonline.domain.repositories.models.DialogItem
import kotlinx.android.synthetic.main.view_dialog_type_1.view.*

class Type1View @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ABaseView(context, attrs, defStyleAttr), ITypeView {

    override fun getViewId(): Int = R.layout.view_dialog_type_1

    override fun bind(data: DialogItem) {
        tvTitle.text = data.title
    }
}