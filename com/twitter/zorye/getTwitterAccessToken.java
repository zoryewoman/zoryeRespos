package com.twitter.zorye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class getTwitterAccessToken {
	
	static AccessToken accessToken=null;
	static String accessSecret="";
	static Twitter twitter;

	public static void main(String[] args) {
		
		
		RequestToken requestToken=null;
		
		twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("3ghnRI4HHWc4EQC5SQZwSJP8k", "AdfnHm0Q1nWRsxwDYzegHsRr0jbtw7YUHptnMYdmNQWJvFJcMs");
		
		
		//토큰
		requestToken=null;
		try {
			requestToken = twitter.getOAuthRequestToken();
		}catch(TwitterException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(requestToken.getAuthorizationURL());
		
		System.out.println("Enter the PIN and hit enter after you granted access");
		String pin="";
		try {
			pin=br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			if(pin.length()>0) {
				accessToken = twitter.getOAuthAccessToken(requestToken,pin);
			}else {
				accessToken = twitter.getOAuthAccessToken(requestToken);
			}
			
			String key1 = accessToken.getToken();
			String key2 = accessToken.getTokenSecret();
			
			System.out.println("accessToken : "+accessToken);
			System.out.println("getToken : "+key1);
			System.out.println("getTokenSecret : "+key2);
			
		}catch(TwitterException te) {
			if(401==te.getStatusCode()) {
				System.out.println("unable to get the access token");
				System.out.println(te);
			}else {
				te.printStackTrace();
			}
		}
		
	}
		
		
		
		
	}
	

