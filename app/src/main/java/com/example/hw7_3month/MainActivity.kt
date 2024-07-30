package com.example.hw7_3month

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw7_3month.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val products = listOf(
            Product(1, "BMW X5", "https://www.bmw.kg/content/dam/bmw/common/all-models/x-series/x5/2023/highlights/bmw-X-series-x5-cp-exterior-desktop.jpg"),
            Product(2, "BMW X3", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjyNTokWAbnOYjq5uw_I8stK12t11sQsa-2Q&s"),
            Product(3, "BMW X1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSL6X1ZsrOr03ftU2bGIq1fKlJTyLWsXJafmg&s"),
            Product(4, "BMW X6", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTArMyv0V2OYkhIBva5ESkE4zRRW3hv7TVVug&s")
        )

        val adapter = ProductAdapter(products) { product ->
            openSubCategoriesFragment(product)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
    }

    private fun openSubCategoriesFragment(product: Product) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, SubCategories.newInstance(product))
            addToBackStack(null)
        }
    }
}
