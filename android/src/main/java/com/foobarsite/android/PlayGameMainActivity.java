package com.foobarsite.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.foobarsite.core.PlayGameMain;

public class PlayGameMainActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new PlayGameMain());
  }
}
