package com.spring.demo;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		String[] message = {"You deserve better!", "Fame and Fortune is coming!", "This is your best day!", "The journey is the reward!"};
		return message[ThreadLocalRandom.current().nextInt(0, message.length)];
	}

}
