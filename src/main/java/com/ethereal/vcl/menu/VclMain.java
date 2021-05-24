package com.ethereal.vcl.menu;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;

import javax.swing.*;

/**
 * @author Administrator
 * @Description
 * @create 2021-05-19 16:39
 */
public class VclMain {
    public static final int WINDOW_WIDTH = 260;
    public static final int WINDOW_HEIGHT = 200;

    public VclMain(String rtspUrl){
        JFrame frame = new JFrame("VCLMain");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //播放器组件
        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.setSize(240, 160);
        //自然布局
        frame.getContentPane().setLayout(null);
        frame.add(mediaPlayerComponent);
        //居中
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        String[] options = {"video-filter=motionblur","network-caching=200","no-plugins-cache"};

        //弹出层播放
//        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
//        EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
//        mediaPlayer.playMedia(media, options);

        MediaPlayer player = mediaPlayerComponent.getMediaPlayer();
        player.playMedia(rtspUrl,options);
    }

}
