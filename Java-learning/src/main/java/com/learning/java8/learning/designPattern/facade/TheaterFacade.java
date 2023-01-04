package com.learning.java8.learning.designPattern.facade;

/**
 * 外观模式主类，主要是多封装一层简化调用逻辑
 *
 */
public class TheaterFacade {
    private DvdPlayer dvdPlayer;
    private Screen screen;
    private Stereo stereo;
    private TheaterLights theaterLights;

    public TheaterFacade(DvdPlayer dvdPlayer, Screen screen, Stereo stereo, TheaterLights theaterLights) {
        this.dvdPlayer = dvdPlayer;
        this.screen = screen;
        this.stereo = stereo;
        this.theaterLights = theaterLights;
    }

    public void ready() {
        dvdPlayer.setDvd();
        screen.down();
        stereo.setVolume();
        theaterLights.dim();
    }
    public void end() {
        dvdPlayer.off();
        screen.up();
        stereo.off();
        theaterLights.off();
    }
    public void play() {
        dvdPlayer.play();
        stereo.on();
    }
    public void pause() {
        dvdPlayer.pause();
    }
}
