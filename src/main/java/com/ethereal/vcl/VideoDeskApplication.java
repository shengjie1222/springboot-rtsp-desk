package com.ethereal.vcl;

import com.ethereal.vcl.menu.VclMain;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ResourceUtils;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import java.io.File;

/**
 * @author Administrator
 */
@SpringBootApplication
public class VideoDeskApplication {


    public static void main(String[] args) {

        try {
            File file = ResourceUtils.getFile("classpath:vcl");
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), file.getAbsolutePath());
            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
            String media = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov";
            new VclMain(media);
        } catch(Exception e) {
            e.printStackTrace();
        }
        ApplicationContext ctx = new SpringApplicationBuilder(VideoDeskApplication.class)
                .headless(false).run(args);
    }

}
