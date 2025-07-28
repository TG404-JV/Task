package com.tg.societymanagment

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewGroupCompat
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import com.tg.societymanagment.data.methods.getMenuItem
import com.tg.societymanagment.databinding.ActivityMainBinding
import com.tg.societymanagment.fragments.bottomsheet.BottomsheetAddTask
import com.tg.societymanagment.utils.GetToast


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewGroupCompat.installCompatInsetsDispatch(findViewById(R.id.main))


        binding.bottomNav.setMenuItems(getMenuItem())

        binding.bottomNav.setOnMenuItemClickListener { menuItem, index ->
            when (index) {
                0 -> {
                    GetToast.showToast("Home clicked", this)
                    true
                }
                1 -> {
                    findNavController(R.id.fragmentContainer).navigate(R.id.folderFragment)
                    GetToast.showToast("Folder clicked", this)
                    true
                }
                2 -> {
                    val addTaskBottomsheet = BottomsheetAddTask()
                    addTaskBottomsheet.show(supportFragmentManager, "AddTaskFragment")
                    true
                }
                3 -> {
                    GetToast.showToast("Chat clicked", this)
                    true
                }
                4 -> {
                    GetToast.showToast("Profile clicked", this)
                    true
                }
                else -> false
            }
        }

    }
}