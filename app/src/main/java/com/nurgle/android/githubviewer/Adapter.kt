package com.nurgle.android.githubviewer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Nurgle on 15.02.2018.
 */
/*class Adapter(val values: ArrayList<GitHubRepositoryInfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textView?.text = values[position].name
    }

    override fun getItemCount() = values.size

   /*override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        // val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.text_item_list, parent, false)
        // return ViewHolder(itemView)
    }*/

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null

        init {
           // textView = itemView?.findViewById(R.id.text_list_item)
        }
    }

}
*/