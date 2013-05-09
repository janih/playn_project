package com.foobarsite.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.foobarsite.core.PlayGameMain;

public class PlayGameMainJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new PlayGameMain());
  }
}
