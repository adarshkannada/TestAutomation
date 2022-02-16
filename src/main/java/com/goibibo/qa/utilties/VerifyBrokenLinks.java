package com.goibibo.qa.utilties;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class VerifyBrokenLinks {
	int validLink = 0;
	int invalidLink = 0;
	
	public void checkBrokenLinks(String linkURL) {
		try {
			URL url = new URL(linkURL);
			HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
			httpUrlConnect.connect();

			int responseCode = httpUrlConnect.getResponseCode();

			if(responseCode >= 400) {
				System.out.println(linkURL + " : is a broken link. " + httpUrlConnect.getResponseMessage() + " --- "+ httpUrlConnect.getResponseCode());
				invalidLink = invalidLink + 1;
			}
			else {
				System.out.println(linkURL + " : is a valid link. " + httpUrlConnect.getResponseMessage() + " --- "+ httpUrlConnect.getResponseCode());
				validLink = validLink + 1;
			}

			System.err.println("Total Valid Links: "+ validLink);
			System.err.println("Total Invalid Links: "+ invalidLink);

			httpUrlConnect.disconnect();
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
