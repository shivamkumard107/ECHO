package com.developersk.echo_themusicplayer.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.developersk.echo_themusicplayer.R
import com.developersk.echo_themusicplayer.activities.MainActivity
import com.developersk.echo_themusicplayer.fragments.AboutUsFragment
import com.developersk.echo_themusicplayer.fragments.FavoriteFragment
import com.developersk.echo_themusicplayer.fragments.MainScreenFragment
import com.developersk.echo_themusicplayer.fragments.SettingsFragment

/**
 * Created by Shivam Kumar on 07-01-2018.
 */
class NavigationDrawerAdapter(_contentList:ArrayList<String>,_getimages: IntArray, _context : Context):RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder>() {

    var contentList : ArrayList<String>?=null
    var getImages : IntArray?=null
    var mcontext : Context?= null
    init {
        this.contentList = _contentList
        this.getImages = _getimages
        this.mcontext = _context
    }

    override fun getItemCount(): Int {
return contentList?.size as Int
    }

    override fun onBindViewHolder(holder: NavViewHolder?, position: Int) {

        holder?.icon_GET?.setBackgroundResource(getImages?.get(position) as Int)
        holder?.text_GET?.setText(contentList?.get(position))
        holder?.contentHolder?.setOnClickListener({
            if(position==0){
                val mainScreenFragment = MainScreenFragment()
                (mcontext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragments, mainScreenFragment)
                        .commit()
            }else if(position==1){
                val favoriteFragment = FavoriteFragment()
                (mcontext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragments, favoriteFragment)
                        .commit()
            }else if(position==2){
                val settingsFragment = SettingsFragment()
                (mcontext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragments, settingsFragment)
                        .commit()
            }else{
                val aboutUsFragment = AboutUsFragment()
                (mcontext as MainActivity).supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.details_fragments, aboutUsFragment)
                        .commit()
            }
MainActivity.Statified.drawerLayout?.closeDrawers()
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NavViewHolder {
        var itemView = LayoutInflater.from(parent?.context)
               .inflate(R.layout.row_custom_navigationdrawer, parent, false)
        var returnThis = NavViewHolder(itemView)
        return returnThis
    }

    class NavViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var icon_GET : ImageView?= null
        var text_GET : TextView?=null
        var contentHolder : RelativeLayout?=null
        init {
            icon_GET = itemView?.findViewById(R.id.icon_navdrawer)
            text_GET = itemView?.findViewById(R.id.text_navdrawer)
            contentHolder = itemView?.findViewById(R.id.navdrawer_item_content_holder)
        }
    }
}