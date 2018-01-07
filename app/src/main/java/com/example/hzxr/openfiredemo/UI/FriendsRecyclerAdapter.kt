package com.example.hzxr.openfiredemo.UI

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hzxr.openfiredemo.R
import com.example.hzxr.openfiredemo.net.XmppConnection
import org.jivesoftware.smack.XMPPException


/**
 * Created by Hzxr on 2018/1/7.
 */
class FriendsRecyclerAdapter(private val context: Context, private val friendList: ArrayList<HashMap<String, String>>) : RecyclerView.Adapter<FriendsRecyclerAdapter.FriendViewHolder>() {

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friendList[position].get("Name") ?: return)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FriendViewHolder {
        val holder = FriendViewHolder(LayoutInflater.from(context).inflate(R.layout.item_friend, parent, false))
        return holder
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val friendTv: TextView

        init {
            friendTv = itemView.findViewById(R.id.item_friend)
        }

        fun bind(name: String) {
            friendTv.text = name
        }
    }
}