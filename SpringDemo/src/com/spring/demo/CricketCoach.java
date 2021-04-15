package com.spring.demo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	private String email;
	private String team;
	
	public CricketCoach() {}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 20 minutes.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	
}
