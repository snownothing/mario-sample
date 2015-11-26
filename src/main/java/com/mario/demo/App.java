package com.mario.demo;

import com.junicorn.mario.Bootstrap;
import com.junicorn.mario.Mario;
import com.mario.demo.controller.Index;

public class App implements Bootstrap {

	@Override
	public void init(Mario mario) {
		Index index = new Index();
		mario.addRoute("/", "index", index);
		mario.addRoute("/hello", "hello", index);
		mario.addRoute("/html", "html", index);
	}
	
}
