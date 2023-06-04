package com.example.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.R
import com.example.ui.fragments.language.Language

class LanguageAdapter : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    private var isSelectedIndex: Int = 0
    private val languageListItems = mutableListOf(

        Language(
            "en", "English", R.drawable.ic_flag_england, true
        ),
        Language(
            "fr", "French", R.drawable.ic_flag_france, false
        ),
        Language(
            "de", "Germany", R.drawable.ic_flag_germany, false
        ),
        Language(
            "hi", "Hindi", R.drawable.ic_flag_india, false
        ),
        Language(
            "it", "Italian", R.drawable.ic_flag_italy, false
        ),
        Language(
            "ja", "Japanese", R.drawable.ic_flag_japan, false
        ),
        Language(
            "ko", "Korean", R.drawable.ic_flag_korea, false
        ),
        Language(
            "pt", "Portuguese", R.drawable.ic_flag_portugal, false
        ),
        Language(
            "ru", "Russian", R.drawable.ic_flag_russia, false
        ),
        Language(
            "es", "Spanish", R.drawable.ic_flag_spanish, false
        ),
        Language(
            "vi", "Vietnamese", R.drawable.ic_flag_vietnam, false
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_language, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageListItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val language = languageListItems[position]

        holder.run {
            val typeface = ResourcesCompat.getFont(
                tvName.context,
                if (language.isChosen) R.font.montserrat_bold else R.font.montserrat_regular
            )

            if (language.isChosen) {
                val white = ContextCompat.getColor(holder.itemView.context, R.color.white)
                tvName.setTextColor(white)
                layout.setBackgroundResource(R.drawable.bg_theme_radius_10)
            } else {
                val black = ContextCompat.getColor(holder.itemView.context, R.color.black)
                tvName.setTextColor(black)
                layout.setBackgroundResource(R.drawable.bg_white_radius_10)
            }


            tvName.typeface = typeface
            tvName.text = language.fullName

            ivCountry.setBackgroundResource(language.icon)

            /*ivCheckBox.isSelected = language.isChosen*/

            itemView.setOnClickListener {
                languageListItems[isSelectedIndex].isChosen = false
                languageListItems[holder.adapterPosition].isChosen = true
                notifyItemChanged(isSelectedIndex)
                notifyItemChanged(holder.adapterPosition)

                isSelectedIndex = holder.adapterPosition
            }
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivCountry: ImageView = view.findViewById(R.id.imgIconLanguage)
        val tvName: TextView = view.findViewById(R.id.txtNameLanguage)

        /*val ivCheckBox: ImageView = view.findViewById(R.id.imgChooseLanguage)*/
        val layout = view.findViewById<ConstraintLayout>(R.id.rootView)
    }

    fun getSelectedLanguage(): Language? {
        return languageListItems.findLast { language -> language.isChosen }
    }
}