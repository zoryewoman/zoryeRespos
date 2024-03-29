package com.post.zorye;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/*
 * Sample code to demonstrate the use of the v2 Quote Tweets endpoint
 * */
public class Post_Twitter2 {

  // To set your environment variables in your terminal run the following line:
  // export 'BEARER_TOKEN'='<your_bearer_token>'

  public static void main(String args[]) throws IOException, URISyntaxException {
    final String bearerToken = "AAAAAAAAAAAAAAAAAAAAAFfUbgEAAAAAaXOfRfrkPRumP2vQ%2FLsL24v9oyo%3Da0u8FKwNAgsqqCwNCjecydDPj6NyIAuFz37Z0gjADIxWzclqYz"; //System.getenv("BEARER_TOKEN");
    if (null != bearerToken) {
      //Replace with Tweet ID below
      String response = getTweets(20, bearerToken);
      System.out.println(response);
    } else {
      System.out.println("There was a problem getting your bearer token. Please make sure you set the BEARER_TOKEN environment variable");
    }
  }

  /*
   * This method calls the v2 Quote Tweets endpoint by Tweet ID
   * */
  private static String getTweets(int tweetId, String bearerToken) throws IOException, URISyntaxException {
    String tweetResponse = null;

    HttpClient httpClient = HttpClients.custom()
        .setDefaultRequestConfig(RequestConfig.custom()
            .setCookieSpec(CookieSpecs.STANDARD).build())
        .build();

    URIBuilder uriBuilder = new URIBuilder(String.format("https://api.twitter.com/2/tweets/%s/quote_tweets", tweetId));
    ArrayList<NameValuePair> queryParameters;
    queryParameters = new ArrayList<>();
    queryParameters.add(new BasicNameValuePair("tweet.fields", "created_at"));
    uriBuilder.addParameters(queryParameters);

    HttpGet httpGet = new HttpGet(uriBuilder.build());
    httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));
    httpGet.setHeader("Content-Type", "application/json");

    HttpResponse response = httpClient.execute(httpGet);
    HttpEntity entity = response.getEntity();
    if (null != entity) {
      tweetResponse = EntityUtils.toString(entity, "UTF-8");
    }
    return tweetResponse;
  }
}