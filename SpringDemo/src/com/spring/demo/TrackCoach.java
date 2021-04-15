package com.spring.demo;

import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach, DisposableBean {
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k race.";
	}

	@Override
	public String getDailyFortune() {
		return String.format("Just do it: %s", fortuneService.getFortune());
	}
	
	public void initFunction() {
		System.out.println("Track Coach: initializing...");
	}
	
	public void destroyFunction() {
		System.out.println("Track Coach: destroying a singleton bean...");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Track Coach: destroying a prototype bean...");	
	}
}
