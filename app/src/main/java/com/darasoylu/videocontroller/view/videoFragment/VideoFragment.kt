package com.darasoylu.videocontroller.view.videoFragment

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.darasoylu.videocontroller.databinding.FragmentVideoBinding
import com.darasoylu.videocontroller.model.VideoModel

class VideoFragment : Fragment() {

    private lateinit var binding: FragmentVideoBinding
    private var model: VideoModel? = null
    private lateinit var player: ExoPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //hide status bar (has problem)
        //activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //get model
        model = arguments?.getParcelable("videoModelBundle")

     //   activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        binding = FragmentVideoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPlayer()
    }

    private fun setPlayer() {

        //get videoUrl
        val videoFileName = model?.videoUrl
        val videoUri = Uri.parse("asset:///videos/${videoFileName}")


        player = ExoPlayer.Builder(requireContext()).build()
        binding.videoPlayer.player = player

        // Build the media item.
        val mediaItem = MediaItem.fromUri(videoUri)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }


    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

}