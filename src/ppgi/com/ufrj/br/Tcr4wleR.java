package ppgi.com.ufrj.br;

import java.io.IOException;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class Tcr4wleR {
	private final static String CONSUMER_KEY = "KupIPdszqZlW78bu05XD0ZZ3H";
	private final static String CONSUMER_KEY_SECRET = "msWbjwqZGhLZyw19QqALv6V9y8L96S3LENNIIKgzWz9BjOoOMr";

	public void start() throws TwitterException, IOException {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
		
		// here's the difference
		String accessToken = getSavedAccessToken();
		String accessTokenSecret = getSavedAccessTokenSecret();
		AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
		twitter.setOAuthAccessToken(oathAccessToken);
		// end of difference
	
		twitter.updateStatus("enesimo teste em 2s");
		//mensagens repetidas geram erro!!!
	
		System.out.println("\nMy Timeline:");
		// I'm reading your timeline
		ResponseList<Status> list = twitter.getHomeTimeline();
		for (Status each : list) {
			System.out.println("Sent by: @" + each.getUser().getScreenName()
					+ " - " + each.getUser().getName() + "\n" + each.getText()
					+ "\n");
		}
	}
	private String getSavedAccessTokenSecret() {
		// consider this is method to get your previously saved Access Token
		// Secret
		return "WqMzALUSq37WrXpZRI67DpdsuXrBstiE8RCoOsAeZAgrJ";
	}
	private String getSavedAccessToken() {
		// consider this is method to get your previously saved Access Token
		return "116500283-5wbu7J8IphXfyuxcMdS540PbqlDCo4LUvnB5d5Zt";
	}
	public static void main(String[] args) throws Exception {
		new Tcr4wleR().start();
	}
}
