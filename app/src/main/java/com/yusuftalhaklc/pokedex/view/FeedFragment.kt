package com.yusuftalhaklc.pokedex.view

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.yusuftalhaklc.pokedex.viewmodel.FeedViewModel
import com.yusuftalhaklc.pokedex.R
import com.yusuftalhaklc.pokedex.adapter.FeedModelAdapter
import com.yusuftalhaklc.pokedex.model.FeedModel
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class FeedFragment : Fragment() {

    private lateinit var viewModel : FeedViewModel
    lateinit var adapter : FeedModelAdapter
    private var myList = arrayListOf<FeedModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // ID = R.layout.fragment_name
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FeedModelAdapter(arrayListOf())

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.getData()

        feedRecyclerView.layoutManager = GridLayoutManager(this.context,2)
        feedRecyclerView.adapter = adapter


        settingsButton.setOnClickListener {
            settingsButton.playAnimation()
            settingsButton.addAnimatorListener(object:Animator.AnimatorListener{
                override fun onAnimationStart(p0: Animator?) {
                    TODO("Not yet implemented")
                }

                override fun onAnimationEnd(p0: Animator?) {
                    // it will been changed as setting fragment
                    val action = FeedFragmentDirections.actionFeedFragmentToDetailsFragment()
                    Navigation.findNavController(it).navigate(action)
                }

                override fun onAnimationCancel(p0: Animator?) {
                    TODO("Not yet implemented")
                }

                override fun onAnimationRepeat(p0: Animator?) {
                    TODO("Not yet implemented")
                }

            })
        }

        observeData()
    }

    private fun observeData(){
        viewModel.livefeedModelList.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.refreshData(it)
            }

        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it == true){
                loadingBar.playAnimation()
                feedRecyclerView.visibility =  View.GONE
                loadingBar.visibility = View.VISIBLE
            }
            else{
                loadingBar.visibility = View.GONE
                loadingBar.pauseAnimation()
                feedRecyclerView.visibility =  View.VISIBLE
            }
        })
    }

}