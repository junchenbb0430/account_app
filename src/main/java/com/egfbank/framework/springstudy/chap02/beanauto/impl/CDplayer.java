package com.egfbank.framework.springstudy.chap02.beanauto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egfbank.framework.springstudy.chap02.beanauto.CompactDisc;
import com.egfbank.framework.springstudy.chap02.beanauto.Media;

@Component
public class CDplayer implements Media {

	@Autowired
	private CompactDisc  disc; 
	
	public void play() {
		 
	}

}
