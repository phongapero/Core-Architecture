package com.example.ui.fragments.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.R

class SettingAdapter
constructor(val callback: Callback): RecyclerView.Adapter<SettingAdapter.ViewHolder>()
{
    private var list = mutableListOf(
        Setting(R.drawable.ic_language, R.string.language),
        Setting(R.drawable.ic_language, R.string.app_name),
        Setting(R.drawable.ic_language, R.string.settings),
        Setting(R.drawable.ic_language, R.string.home)
    )

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val icon: ImageView = itemView.findViewById(R.id.elementIcon)
        val name: TextView = itemView.findViewById(R.id.elementName)
        val layout: LinearLayout = itemView.findViewById(R.id.elementLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_setting, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val setting = list[position]

        holder.icon.setImageResource(setting.icon)
        holder.name.setText(setting.name)
        holder.layout.setOnClickListener {
            when(setting.icon)
            {
                R.drawable.ic_language -> callback.setupLanguage()
            }
        }
    }

    interface Callback{
        fun setupLanguage()
    }
}