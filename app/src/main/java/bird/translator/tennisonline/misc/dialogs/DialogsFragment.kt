package bird.translator.tennisonline.misc.dialogs

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bird.translator.tennisonline.R
import bird.translator.tennisonline.base.ABaseAdapter
import bird.translator.tennisonline.base.ABaseListFragment
import bird.translator.tennisonline.domain.di.components.DaggerAppComponent
import bird.translator.tennisonline.domain.repositories.models.DialogItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import javax.inject.Inject

class DialogsFragment : ABaseListFragment<DialogItem, RecyclerView.ViewHolder>(), IDialogsView {

    class Adapter : ABaseAdapter<DialogItem, RecyclerView.ViewHolder>() {

        companion object {
            const val TYPE_1 = 0
            const val TYPE_2 = 1
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            val view: View = if (viewType == TYPE_1) Type1View(parent.context)
            else Type2View(parent.context)
            view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            return object : RecyclerView.ViewHolder(view) { }
        }

        override fun getItemViewType(position: Int): Int {
            return if (data[position].isType1) TYPE_1 else TYPE_2
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val view = holder.itemView
            if (view is ITypeView)
                view.bind(data[position])
        }
    }

    override fun getListId(): Int = R.id.rvList
    override fun getViewId(): Int = R.layout.fragment_dialogs

    @Inject
    @InjectPresenter
    lateinit var presenter: DialogsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    private val adapter = Adapter()

    override fun provideAdapter() = adapter

    override fun inject() {
        DaggerAppComponent.create().inject(this)
    }

    override fun bindDialogs(dialogs: List<DialogItem>) {
        adapter.data = dialogs.toMutableList()
    }
}