package com.example.fixturepractice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fixturepractice.R
import com.example.fixturepractice.ViewModel.MainViewModel
import com.example.fixturepractice.databinding.FragmentMainBinding
import com.example.fixturepractice.model.MyFixtures
import com.example.fixturepractice.util.Resource
import com.example.fixturepractice.util.Resource.*
import java.util.Collections.addAll

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private val vm by viewModels<MainViewModel>()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(
        LayoutInflater.from(context),
        container,
        false
    ).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        observeObservables()
    }
    private fun setupRV(){
        binding.rvFixture.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = FixturesAdapter(::thisDataClicked)
        }
    }

    private fun thisDataClicked(data: MyFixtures){
        Toast.makeText(context, data.competitionStage.competition.name, Toast.LENGTH_SHORT).show()
    }

    private fun observeObservables() {
        vm.fixturesObservable.observe(viewLifecycleOwner, Observer { resources ->
            when(resources.status){
                Status.LOADING -> print("loading")
                Status.SUCCESS -> {
                    resources.data?.let { list ->
                        (binding.rvFixture.adapter as FixturesAdapter).setFixtures(list)
                        print("SUCCESS ${list}")
                    }
                }
                Status.ERROR -> print("ERROR")
            }
        })
    }

}