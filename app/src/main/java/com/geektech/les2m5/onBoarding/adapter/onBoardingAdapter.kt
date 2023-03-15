package com.geektech.tasks.ui.onBoarding.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.les2m5.R
import com.geektech.les2m5.databinding.ItemOnBoardingBinding
import com.geektech.les2m5.models.onBoard

class onBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<onBoardingAdapter.onBoardingViewHolger>() {
    var data = arrayListOf(
        onBoard(
"Скоро на свидание? Узнайте совместимость!",
            R.raw.love_anim
            ),
        onBoard(
            "Стоит ли жениться, или этот человек не для вас?",
            R.raw.love_anim2
        ),
        onBoard(
            "Удобный калькулятор у вас в телефоне!",
            R.raw.love_anim3
        ),
        onBoard(
            "Внимание! Приложение не имеет связи с реальным миром. Все совпадения случайны!",
            R.raw.love_anim4
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardingViewHolger {
        return onBoardingViewHolger(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: onBoardingViewHolger, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class onBoardingViewHolger(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: onBoard) {
            onBoard.anim.let { binding.loveAnim.setAnimation(it) }
            binding.messageTw.text = onBoard.message
            binding.getstartBtn.isVisible = adapterPosition == data.lastIndex
            binding.getstartBtn.setOnClickListener{
                onClick()
                Log.e("xvr", "Adapter")
            }
        }
    }

}
