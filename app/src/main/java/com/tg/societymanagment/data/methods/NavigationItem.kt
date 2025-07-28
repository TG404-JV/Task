package com.tg.societymanagment.data.methods

import com.tg.societymanagment.R

import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem

fun getMenuItem() : Array<CbnMenuItem>
{
    val menuItem = arrayOf(
        CbnMenuItem(
            R.drawable.ic_home,
            R.drawable.avd_home,
            R.id.homeFragment,
            "Home"

        ),
        CbnMenuItem(
            R.drawable.ic_folder,
            R.drawable.avd_folder,
            R.id.folderFragment,
            "Folder"
        ),
        CbnMenuItem(
            R.drawable.ic_add,
            R.drawable.avd_add,
        ),
        CbnMenuItem(
            R.drawable.ic_chat,
            R.drawable.avd_chat,
            R.id.messageFragment,
            "Chat"
        ),
        CbnMenuItem(
            R.drawable.ic_profile,
            R.drawable.avd_profile,
            R.id.profileFragment,
            "Profile"
        )

    )

    return menuItem
}