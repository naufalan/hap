package com.example.ceria.ui.carousel

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.ceria.R
import com.example.ceria.databinding.FragmentCarouselBinding
import com.example.ceria.databinding.ItemCarouselBinding
import com.example.ceria.ui.main.MainActivity
import org.jetbrains.anko.imageResource
import timber.log.Timber


class CarouselFragment : Fragment() {
    private lateinit var binding: FragmentCarouselBinding
    private lateinit var dots: Array<TextView?>
    private lateinit var carouselList: ArrayList<CarouselModel>
    private lateinit var pagerAdapter: ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarouselBinding.inflate(inflater, container, false)

        carouselList = ArrayList()
        carouselList.add(
            CarouselModel(
                R.drawable.ic_carousel_1,
                "Belanja Online Mudah tanpa Kartu Kredit di Merchant terpilih kami",
                ""
            )
        )
        carouselList.add(
            CarouselModel(
                R.drawable.ic_carousel_2,
                "Pengajuan dan penarikan Uang Kredit yang cepat hanya dengan Face ID",
                ""
            )
        )
        carouselList.add(
            CarouselModel(
                R.drawable.ic_carousel_3,
                "Banyak Promo Menarik hingga 25% dari Berbagai Merchant Favorit Kamu",
                ""
            )
        )

        addBottomDots(0)

        pagerAdapter = ViewPagerAdapter()
        binding.apply {
            vpCarousel.adapter = pagerAdapter
            vpCarousel.addOnPageChangeListener(viewPagerPageChangeListener)
            tvCarouselTitle.text = carouselList[0].title
            tvCarouselDesc.text = carouselList[0].description

            setClickListener { view ->
                when (view.id) {

                    R.id.btn_signup -> {
                        view.findNavController()
                            .navigate(R.id.action_carouselFragment_to_signUpFragment)
                    }
                    R.id.btn_login ->{
                        view.findNavController()
                            .navigate(R.id.action_carouselFragment_to_loginFragment)
                    }
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(carouselList.size)
        binding.llIndicator.removeAllViews()
        for (i in dots.indices) {
            dots = arrayOfNulls(carouselList.size)
            val colorActive: Int
            val colorInactive: Int

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                colorActive = resources.getColor(R.color.dotActive, null)
                colorInactive = resources.getColor(R.color.dotInactive, null)
            } else {
                colorActive = resources.getColor(R.color.dotActive)
                colorInactive = resources.getColor(R.color.dotInactive)
            }

            binding.llIndicator.removeAllViews()
            for (i in dots.indices) {
                dots[i] = TextView(requireContext())
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    dots[i]?.text = Html.fromHtml("&#8226;", Html.FROM_HTML_MODE_LEGACY)
                } else {
                    dots[i]?.text = Html.fromHtml("&#8226;")
                }
                dots[i]?.textSize = 35F
                dots[i]?.setTextColor(colorInactive)
                binding.llIndicator.addView(dots[i])
            }

            if (dots.isNotEmpty())
                dots[currentPage]?.setTextColor(colorActive)
        }
    }

    //  viewpager change listener
    private var viewPagerPageChangeListener: ViewPager.OnPageChangeListener =
        object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                val carouselItem = carouselList[position]
                binding.apply {
                    tvCarouselTitle.text = carouselItem.title
                    tvCarouselDesc.text = carouselItem.description
                }
                addBottomDots(position)
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {
            }

            override fun onPageScrollStateChanged(arg0: Int) {
            }
        }

    inner class ViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        private var authActivity = requireActivity() as MainActivity

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater =
                    authActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val carouselItem = carouselList[position]
            val view = ItemCarouselBinding.inflate(layoutInflater!!, container, false)
            view.ivCarousel.imageResource = carouselItem.image
            //Timber.e("ini resource image ${carouselItem.image}")
            val root = view.root
            container.addView(root)
            return root
        }

        override fun getCount(): Int {
            return carouselList.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }


        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            val view = obj as View
            container.removeView(view)
        }
    }
}