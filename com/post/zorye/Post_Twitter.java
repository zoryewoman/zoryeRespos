package com.post.zorye;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Post_Twitter {

	

	static AccessToken accessToken=null;
	static String accessSecret="";
	static Twitter twitter;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("3ghnRI4HHWc4EQC5SQZwSJP8k", "AdfnHm0Q1nWRsxwDYzegHsRr0jbtw7YUHptnMYdmNQWJvFJcMs");
		
		//자동트윗 START
		AccessToken accessToken = null;
		accessToken = new AccessToken("1392411048477532168-eAS3jQ62R4Y7FbZ20IXMlCYwsR4jHE","5ejXfuZryCHbOPGTHtUVwzCIOaNpGmdWZHZXlpk9a94Cj"); //내 계정
		twitter.setOAuthAccessToken(accessToken);
				
		try {
			Status status=twitter.updateStatus("test"); //트윗
			
		} catch (TwitterException e1) {
			System.out.println("e1 : "+e1);
			
		}
		//자동트윗 END
			

	}

}
