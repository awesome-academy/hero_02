package com.sun.hero_02.screen.group.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.sun.hero_02.R
import com.sun.hero_02.data.model.CategoryHero
import com.sun.hero_02.databinding.ItemLayoutGroupBinding

class SpinnerAdapter(context: Context, listHeroClass: MutableList<CategoryHero>) :
    ArrayAdapter<CategoryHero>(context, 0, listHeroClass) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) =
        initView(position, parent)

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup) =
        initView(position, parent)

    private fun initView(position: Int, parent: ViewGroup): View {

        val binding: ItemLayoutGroupBinding = DataBindingUtil.inflate<ItemLayoutGroupBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_layout_group,
            parent,
            false
        ).apply {
            viewModel = ItemGroupViewModel()

        }
        binding.viewModel?.hero = getItem(position)
        return binding.root
    }
}
