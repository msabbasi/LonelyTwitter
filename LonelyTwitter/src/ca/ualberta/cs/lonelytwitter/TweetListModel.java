package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TweetListModel
{
	
	private ArrayList<LonelyTweetModel> tweets;
	
	public TweetListModel(){
		super();
		tweets = new ArrayList<LonelyTweetModel>();
	}

	public void addTweet(LonelyTweetModel lonelyTweetModel)
	{
		if (tweets.contains(lonelyTweetModel)) {
			throw new IllegalArgumentException();
		}
		else {
			tweets.add(lonelyTweetModel);
		}
	}

	public int getCount()
	{
		return tweets.size();
	}

	public boolean hasTweet(LonelyTweetModel lonelyTweetModel)
	{
		if (tweets.contains(lonelyTweetModel)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void removeTweet(LonelyTweetModel lonelyTweetModel)
	{
		tweets.remove(lonelyTweetModel);
	}

	public ArrayList<LonelyTweetModel> getTweets()
	{
		Collections.sort(tweets, new Comparator<LonelyTweetModel>() {

			public int compare(LonelyTweetModel lhs, LonelyTweetModel rhs)
			{
				return lhs.getTimestamp().compareTo(rhs.getTimestamp());
			}
			
		});
		return tweets;
	}

}
