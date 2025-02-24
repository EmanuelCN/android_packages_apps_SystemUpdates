package com.dot.updater.changelog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dot.updater.R
import com.dot.updater.model.ChangelogItem

class ChangelogAdapter(private val items: ArrayList<ChangelogItem>) :
        RecyclerView.Adapter<ChangelogAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cIcon: ImageView = view.findViewById(R.id.updateChangelogIcon)
        val cTitle: TextView = view.findViewById(R.id.updateChangelogTitle)
        val cSubtitle: TextView = view.findViewById(R.id.updateChangelogSubtitle)
        val cSummary: TextView = view.findViewById(R.id.updateChangelogSummary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.update_changelog_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val changelog: ChangelogItem = items[position]
        holder.cIcon.setImageResource(changelog.iconRes!!)
        holder.cTitle.text = changelog.title
        if (changelog.subtitle == "") holder.cSubtitle.visibility = View.GONE
        else holder.cSubtitle.text = changelog.subtitle
        holder.cSummary.text = changelog.summary
    }
}