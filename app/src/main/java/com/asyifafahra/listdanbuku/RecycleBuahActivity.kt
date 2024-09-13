package com.asyifafahra.listdanbuku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.contextaware.ContextAware
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asyifafahra.listdanbuku.adapter.BuahAdapter
import com.asyifafahra.listdanbuku.model.ModelBuah
import com.asyifafahra.listdanbuku.model.MockList

class RecycleBuahActivity : ComponentActivity() {
    private lateinit var rv_buah: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_buah)

        rv_buah = findViewById(R.id.rv_buah)

        // Use GridLayoutManager with a span count
        rv_buah.layoutManager = GridLayoutManager(this, 1)

        // Set adapter
        val adapter = BuahAdapter(MockList.getModel() as ArrayList<ModelBuah>)
        rv_buah.adapter = adapter

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
