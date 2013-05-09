package com.foobarsite.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.pointer;

import java.util.ArrayList;
import java.util.List;

import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Pointer;

public class PlayGameMain extends Game.Default {

	public static int UPDATE_RATE = 33;
	private GroupLayer peaLayer;
	private List<Pea> peas = new ArrayList<Pea>(0);

	public PlayGameMain() {
		super(UPDATE_RATE); // call update every 33ms (30 times per second)
	}

	@Override
	public void init() {
		// create and add background image layer
		Image bgImage = assets().getImage("images/bg.png");
		ImageLayer bgLayer = graphics().createImageLayer(bgImage);
		graphics().rootLayer().add(bgLayer);

		// create a group layer to hold the peas
		peaLayer = graphics().createGroupLayer();
		graphics().rootLayer().add(peaLayer);

		// preload the pea image into the asset manager cache
		assets().getImage(Pea.IMAGE);

		// add a listener for pointer (mouse, touch) input
		pointer().setListener(new Pointer.Adapter() {
			@Override
			public void onPointerEnd(Pointer.Event event) {
				Pea pea = new Pea(peaLayer, event.x(), event.y());
				peas.add(pea);
			}
		});

	}

	@Override
	public void update(int delta) {
		for (Pea pea : peas) {
			pea.update(delta);
		}
	}

	@Override
	public void paint(float alpha	) {
		for (Pea pea : peas) {
			pea.paint(alpha);
		}
	}
}
