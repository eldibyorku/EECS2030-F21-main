/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class Channel {
	private String name;
	private int maxFollowers;
	private int maxReleasedVideos;

	private String[] releasedVideos; 
	private int norv; //Number of released videos. 

	private Follower[] followers;
	private int nof; //Number of Followers. 

	public Channel(String name, int maxFollowers, int maxReleasedVideos){
		this.name = name;
		this.maxFollowers = maxFollowers;
		this.maxReleasedVideos = maxReleasedVideos;

		this.releasedVideos = new String [maxReleasedVideos];
		this.norv = 0;

		this.followers = new Follower[maxFollowers];
		this.nof = 0;
	}

	public void releaseANewVideo(String video) {
		//update the context object `Channel`.
		this.releasedVideos[this.norv] = video;
		this.norv++;

		//updates the argument object `Subscriber`.
		for(int i = 0; i < this.nof; i++) {
			Follower follower = this.followers[i];
			if(follower instanceof Subscriber) {
				((Subscriber) follower).recommendedVideos(video); 
			}
		}
	}

	public void follow(Follower f) {
		//update the context object `Channel`.
		this.followers[this.nof] = f;
		this.nof++;		

		//updates the argument object `follower`.
		f.follow(this);
	}

	public void unfollow(Follower f) {
		//update the context object `Channel`.
		int index = -1;
		boolean foundFollower = false;
		for(int i = 0; i < this.nof && (!foundFollower); i++) {
			Follower follower = this.followers[i];
			if((follower.name.equals(f.name)) 
					&& (follower.maxChannels == f.maxChannels)
					&& (follower.maxRecommendedVideos == f.maxRecommendedVideos)) {
				index = i;
				foundFollower = true;
			}
		}
		if (foundFollower) {
			for(int i = index; i < this.nof; i++)	{
				this.followers[i] = this.followers[i+1];
			}
			this.nof--;
		}

		//updates the argument object `follower`.
		f.unfollow(this);
	}

	/* 
	 * Note: Check the getFollowers() and getReleasedVideos() method from this Channel class. 
	 * 		 It provides the List of Strings of Followers and Released Videos respectively. 
	 * 
	 * Step-5. From Subscriber.watch(video, watchTime) method we got the channel which contains particular video from the channel array.
	 * Step-6. From the particular channel find the list of followers. 
	 * Step-7. After finding list of followers check which follower is type of 'Monitor'.(Hint: Use "instanceof")  
	 * Step-8. After finding the follower of type 'Monitor', call mutator method Monitor.updateStat(channelName, watchTime).
	 * Step-9. Mutator method Monitor.updateStat(channelName, watchTime), supply the Channel name and watchtime.
	 * 
	 *  (For Manual Testing uncomment the line: 86,90)
	 */
	public void addWatchTime(int watchTime) {
		//		System.out.println("Watch time: " + watchTime + ".");
		Follower[] followersList = this.getFollowers();
		for(int i = 0; i < followersList.length; i++) {
			if(followersList[i] instanceof Monitor) {
				//				System.out.println("'"+this.name + "' channel contains monitor '" + followersList[i].name + "'.");
				((Monitor) followersList[i]).updateStat(this.name, watchTime);
			}
		}
	}

	public String getName() {
		return name;
	}

	public int getMaxFollowers() {
		return maxFollowers;
	}

	public int getMaxReleasedVideos() {
		return maxReleasedVideos;
	}

	// Get list Follower for watch history.
	public Follower[] getFollowers() {
		Follower[] followers = new Follower[this.nof];
		for(int i = 0; i < this.nof; i++) {
			followers[i] = this.followers[i];
		}
		return followers;
	}

	// Get list Released Videos for watch history. 
	public String[] getReleasedVideos() {
		String[] releasedVideos = new String[this.norv];
		for(int i = 0; i < this.norv; i++) {
			releasedVideos[i] = this.releasedVideos[i];
		}
		return releasedVideos;

	}

	private String getVideosList() {
		String videosList = "";
		for(int i = 0; i < this.norv; i++) {
			videosList += this.releasedVideos[i];
			if(i < this.norv - 1) {
				videosList += ", ";
			}
		}
		return videosList;
	}

	private String getFollowersList() {
		String followersList = "";
		for(int i = 0; i < this.nof; i++) {
			String type = null;
			if(this.followers[i] instanceof Subscriber) {
				type = "Subscriber";
			}
			if(this.followers[i] instanceof Monitor) {
				type = "Monitor";
			}
			followersList += String.format("%s %s",type ,this.followers[i].getName());
			if(i < this.nof - 1) {
				followersList += ", ";
			}
		}	
		return followersList;
	}

	public String toString() {
		String status = "";
		if (this.norv == 0 && this.nof == 0) {
			status = String.format("%s released no videos and has no followers.", this.name);
		}
		else if(this.norv > 0 && this.nof == 0) {	
			status = String.format("%s released <%s> and has no followers.", this.name, this.getVideosList());
		}
		else if (this.norv == 0 && this.nof > 0) {
			status = String.format("%s released no videos and is followed by [%s].", this.name, this.getFollowersList());
		}
		else {
			status = String.format("%s released <%s> and is followed by [%s].", this.name, this.getVideosList(), this.getFollowersList());
		}
		return status;
	}
}