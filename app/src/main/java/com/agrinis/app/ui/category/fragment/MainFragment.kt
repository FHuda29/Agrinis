package com.agrinis.app.ui.category.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.agrinis.app.R
import com.agrinis.app.data.models.DataStatus
import com.agrinis.app.databinding.ActivityMainBinding
import com.agrinis.app.databinding.FragmentMainBinding
import com.agrinis.app.ui.NewsActivity
import com.agrinis.app.ui.category.adapter.HeadLineCategoryAdapter
import com.agrinis.app.ui.category.adapter.HeadlinesAdapter
import com.agrinis.app.ui.category.viewModel.MainFragmentViewModel
import com.agrinis.app.util.extensions.initHorizontal
import com.agrinis.app.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainFragmentViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.viewArticle.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, NewsActivity::class.java))
                //finish()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViews(view.context)
        initObservers(view.context)

        viewModel.apply {
            getTopHeadlines()
            getTopScienceHeadlines()
            getTopSportsHeadlines()
            getTopBusinessHeadlines()
            getTopEntertainmentHeadlines()
        }
    }

    private fun initRecyclerViews(context: Context) {
        binding.apply {
            rcvHeadlines.initHorizontal(context)
            rcvScience.initHorizontal(context)
            rcvSports.initHorizontal(context)
            rcvBusiness.initHorizontal(context)
            rcvEntertainment.initHorizontal(context)
        }
    }

    private fun initObservers(context: Context) {
        viewModel.topHeadlines.observe(viewLifecycleOwner, {
            when (it.status) {
                DataStatus.Status.SUCCESS ->
                    binding.rcvHeadlines.adapter = HeadlinesAdapter(it.data!!.articles,context)

                DataStatus.Status.LOADING -> println("loading top headlines")
                else -> println(it.message)
            }
        })

        viewModel.topScienceHeadlines.observe(viewLifecycleOwner, {
            when (it.status) {
                DataStatus.Status.SUCCESS ->
                    binding.rcvScience.adapter = HeadLineCategoryAdapter(it.data!!.articles,context)

                DataStatus.Status.LOADING -> println("loading science")
                else -> println(it.message)
            }
        })

        viewModel.topSportsHeadlines.observe(viewLifecycleOwner, {
            when (it.status) {
                DataStatus.Status.SUCCESS ->
                    binding.rcvSports.adapter = HeadLineCategoryAdapter(it.data!!.articles,context)

                DataStatus.Status.LOADING -> println("loading sports")
                else -> println(it.message)
            }
        })

        viewModel.topBusinessHeadlines.observe(viewLifecycleOwner, {
            when (it.status) {
                DataStatus.Status.SUCCESS ->
                    binding.rcvBusiness.adapter = HeadLineCategoryAdapter(it.data!!.articles,context)

                DataStatus.Status.LOADING -> println("loading business")
                else -> println(it.message)
            }
        })

        viewModel.topEntertainmentHeadlines.observe(viewLifecycleOwner, {
            when (it.status) {
                DataStatus.Status.SUCCESS ->
                    binding.rcvEntertainment.adapter = HeadLineCategoryAdapter(it.data!!.articles,context)

                DataStatus.Status.LOADING -> println("loading entertaiment")
                else -> println(it.message)
            }
        })
    }

}