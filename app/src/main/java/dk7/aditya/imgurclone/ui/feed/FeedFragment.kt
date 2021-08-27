package dk7.aditya.imgurclone.ui.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dk7.aditya.imgurclone.R
import dk7.aditya.imgurclone.databinding.FeedFragmentBinding

class FeedFragment : Fragment() {
    companion object {
        fun newInstance() = FeedFragment()
    }
    private lateinit var viewModel: FeedViewModel
    private var _binding: FeedFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val feed = arguments?.getString("feed")
        _binding = FeedFragmentBinding.inflate(inflater, container, false)
        feed?.let {
            binding.tvTextView.text = feed.toString()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}