package com.example.hw7_3month

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw7_3month.databinding.FragmentSubCategoriesBinding

class SubCategories : Fragment() {

    private lateinit var binding: FragmentSubCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = arguments?.getParcelable<Product>("product")

        // Настройка RecyclerView для подкатегорий
        val subCategories = when (product?.id) {
            1 -> listOf(
                SubCategory("X5 M", "https://www.bmw.kg/content/dam/bmw/common/all-models/x-series/x5/2023/highlights/bmw-X-series-x5-cp-exterior-desktop.jpg"),
                SubCategory("X5 xDrive40i", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXqq51tqHES-1FRJgtYs890t9DUBHGyNPGVw&s")
            )
            2 -> listOf(
                SubCategory("X3 M", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjyNTokWAbnOYjq5uw_I8stK12t11sQsa-2Q&s"),
                SubCategory("X3 xDrive30i", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsK04RP4kkrl37N_tjw3l3L9xMFQVFywatvQ&s")
            )
            3 -> listOf(
                SubCategory("X1 sDrive28i", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSL6X1ZsrOr03ftU2bGIq1fKlJTyLWsXJafmg&s"),
                SubCategory("X1 xDrive28i", "https://media.ed.edmunds-media.com/bmw/x1/2023/oem/2023_bmw_x1_4dr-suv_xdrive28i_fq_oem_1_600.jpg")
            )
            4 -> listOf(
                SubCategory("X6 M", "https://www.bmw.kg/content/dam/bmw/common/all-models/m-series/x6m/2023/highlights/bmw-m-series-x6-m-gallery-image-impressionen-03_1920.jpg.asset.1675123934752.jpg"),
                SubCategory("X6 xDrive40i", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvmhPBqz8YTSbEpSG2CZBNzFmCjz-4LCHRWg&s")
            )
            else -> listOf()
        }

        val adapter = SubCategoryAdapter(subCategories)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
    }

    companion object {
        fun newInstance(product: Product): SubCategories {
            val fragment = SubCategories()
            val args = Bundle().apply {
                putParcelable("product", product)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
