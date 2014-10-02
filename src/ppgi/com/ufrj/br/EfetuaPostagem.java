package ppgi.com.ufrj.br;

import twitter4j.auth.AccessToken;

import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class EfetuaPostagem {
	
	private String getSavedAccessTokenSecret() {
		// consider this is method to get your previously saved Access Token
		// Secret
		return "WqMzALUSq37WrXpZRI67DpdsuXrBstiE8RCoOsAeZAgrJ";
	}
	private String getSavedAccessToken() {
		// consider this is method to get your previously saved Access Token
		return "116500283-5wbu7J8IphXfyuxcMdS540PbqlDCo4LUvnB5d5Zt";
	}
	
	public EfetuaPostagem(String consumerKey, String consumerKeySecret, String msg){
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerKeySecret);
		String accessToken = getSavedAccessToken();
		String accessTokenSecret = getSavedAccessTokenSecret();
		AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
		twitter.setOAuthAccessToken(oathAccessToken);	
		
		try {
			twitter.updateStatus(msg);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
