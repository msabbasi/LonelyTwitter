package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;
import android.test.ActivityInstrumentationTestCase2;


public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{

	public TweetListModelTest()
	{
		super(LonelyTwitterActivity.class);
	}
	
	public void testFiveIsFive() {
		assertEquals(5, 5);
	}
	
	public void testTweetListModel() {
		TweetListModel tlm = new TweetListModel();
	}
	
	public void testAddTweet() {
		TweetListModel tlm = new TweetListModel();
		tlm.addTweet(new LonelyTweetModel("test"));
		assertTrue(tlm.getCount() == 1);
		try {
			tlm.addTweet(new LonelyTweetModel("test"));
			fail("Should throw exception");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	public void testHasTweet() {
		TweetListModel tlm = new TweetListModel();
		tlm.addTweet(new LonelyTweetModel("test"));
		assertTrue(tlm.hasTweet(new LonelyTweetModel("test")));
	}
	
	public void testRemoveTweet() {
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel tweet = new LonelyTweetModel("test");
		tlm.addTweet(tweet);
		assertTrue(tlm.hasTweet(tweet));
		tlm.removeTweet(tweet);
		assertFalse(tlm.hasTweet(tweet));
	}
	
	public void testGetCount() {
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel tweet1 = new LonelyTweetModel("test1");
		tlm.addTweet(tweet1);
		assertTrue(tlm.getCount() == 1);
		LonelyTweetModel tweet2 = new LonelyTweetModel("test2");
		tlm.addTweet(tweet2);
		assertTrue(tlm.getCount() == 2);
		tlm.removeTweet(tweet1);
		assertTrue(tlm.getCount() == 1);
		tlm.removeTweet(tweet2);
		assertTrue(tlm.getCount() == 0);
	}
	
	public void testGetTweets() {
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel tweet1 = new LonelyTweetModel("test1");
		LonelyTweetModel tweet2 = new LonelyTweetModel("test2");
		tlm.addTweet(tweet1);
		tlm.addTweet(tweet2);
		List<String> tweets = tlm.getTweets();
		assertNotNull(tweets);
		assertTrue(tweets.size() == 2);
		assertEquals(tweets.get(0), "test1");
		assertEquals(tweets.get(1), "test2");
	}

}
