package com.egfbank.framework.springstudy.chap02.beanauto.impl;

import org.springframework.stereotype.Component;

import com.egfbank.framework.springstudy.chap02.beanauto.CompactDisc;

@Component("sgtPeppers")
public class SgtPeppers implements CompactDisc {

	private String title = "Sgt Peppers ";
	
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("playing "+title);
	}

}
