package com.example.mvitestproject

import android.view.View
import android.widget.TextView
import com.arkivanov.mvikotlin.core.utils.diff
import com.arkivanov.mvikotlin.core.view.BaseMviView

class CalculatorViewImpl(root: View) : BaseMviView<CalculatorStore.State, CalculatorStore.Intent>(), CalculatorView {

    private val textView = root.findViewById<TextView>(R.id.tv_value)

    init {
        root.findViewById<View>(R.id.btn_increment).setOnClickListener {
            dispatch(CalculatorStore.Intent.Increment)
        }
        root.findViewById<View>(R.id.btn_decrement).setOnClickListener {
            dispatch(CalculatorStore.Intent.Decrement)
        }
    }

    override fun render(model: CalculatorStore.State) {
        super.render(model)
        diff<CalculatorStore.State> {
            diff(get = CalculatorStore.State::value, set = textView::setText)
        }
    }


}