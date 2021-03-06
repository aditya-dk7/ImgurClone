package dk7.aditya.imgurclone.ui.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dk7.aditya.imgurclone.databinding.FeedFragmentBinding

class FeedFragment : Fragment() {
    companion object {
        fun newInstance() = FeedFragment()
    }
    private val viewModel: FeedViewModel by viewModels()
    private val feedAdapter =  FeedRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed")
        feed?.let {
            viewModel.updateFeed(it)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val binding = FeedFragmentBinding.inflate(inflater, container, false)
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.feedRecyclerView.adapter = feedAdapter
        viewModel.feed.observe({lifecycle}){
            feedAdapter.submitList(it)
        }
        return binding.root
    }

}