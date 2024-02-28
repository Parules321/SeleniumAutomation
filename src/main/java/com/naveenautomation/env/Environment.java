package com.naveenAutomation.env;

public enum Environment {
	DEV("https://naveenautomationlabsdev.com/opencart/index.php?route=account/register"),
	STAGE("https://naveenautomationlabsstage.com/opencart/index.php?route=account/register"),
	PROD("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

	String envUrl;

	Environment(String envUrl) {
		this.envUrl = envUrl;
	}

	public String getEnvUrl() {
		return envUrl;
	}

}