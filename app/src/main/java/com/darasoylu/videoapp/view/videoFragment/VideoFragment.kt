package com.darasoylu.videoapp.view.videoFragment

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.fragment.findNavController
import com.darasoylu.videoapp.R
import com.darasoylu.videoapp.databinding.CustomControllerBinding
import com.darasoylu.videoapp.databinding.FragmentVideoBinding
import com.darasoylu.videoapp.data.VideoModel

class VideoFragment : Fragment() {

    private lateinit var binding: FragmentVideoBinding
    private lateinit var bindingController: CustomControllerBinding
    private var model: VideoModel? = null
    private lateinit var player: ExoPlayer
    private var videoUri: Uri? = null
    private var subtitleUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //get model
        model = arguments?.getParcelable("videoModelBundle")

        //get videoUri
        val videoFileName = model?.videoUrl
        videoUri = Uri.parse("asset:///videos/${videoFileName}")

        subtitleUri = Uri.parse("asset:///subtitle/thedarkknight_subtitle.srt")

        enterFullscreen()

        binding = FragmentVideoBinding.inflate(inflater)
        bindingController = CustomControllerBinding.bind(binding.root)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPlayer(videoUri!!)

        binding.videoPlayer.player = player

        bindingController.videoNameTxt.text = model!!.videoName

        bindingController.exoPause.setOnClickListener {
            player.playWhenReady = false
            bindingController.exoPause.visibility = View.INVISIBLE
            bindingController.exoPlay.visibility = View.VISIBLE
        }

        bindingController.exoPlay.setOnClickListener {
            player.playWhenReady = true
            bindingController.exoPause.visibility = View.VISIBLE
            bindingController.exoPlay.visibility = View.INVISIBLE
        }

        bindingController.exoRew.setOnClickListener {
            seekBy(-10000)
        }

        bindingController.exoFfwd.setOnClickListener {
            seekBy(10000)
        }

        player.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)
                if (playbackState == Player.STATE_ENDED) {
                    player.seekTo(0)
                    player.playWhenReady = false
                    bindingController.exoPause.visibility = View.INVISIBLE
                    bindingController.exoPlay.visibility = View.VISIBLE
                }
            }
        })

        bindingController.videoFragmentBackBt.setOnClickListener {
            onDestroy()
            findNavController().navigate(R.id.homeFragment)
        }

    }

    private fun enterFullscreen() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        activity?.window?.decorView?.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                )
    }

    private fun exitFullscreen() {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
    }

    private fun setPlayer(videoUri: Uri) {

        player = ExoPlayer.Builder(requireContext()).build()

        Log.i("Dara_1", videoUri.toString())

        val subtitle1 = MediaItem.SubtitleConfiguration.Builder(subtitleUri!!)
            .setMimeType(MimeTypes.APPLICATION_SUBRIP)
            .setLabel("Subtitle")
            .build()

        val mediaItem = MediaItem.Builder()
            .setUri(videoUri)
            .setSubtitleConfigurations(listOf(subtitle1))
            .build()

        // Build the media item.
        player.setMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = true
    }

    private fun seekBy(milliseconds: Long) {
        val currentPositionMillis = player.currentPosition
        val newPositionMillis = currentPositionMillis + milliseconds
        player.seekTo(newPositionMillis.coerceIn(0, player.duration))
    }


    override fun onDestroy() {
        super.onDestroy()
        player.release()
        exitFullscreen()
    }

}