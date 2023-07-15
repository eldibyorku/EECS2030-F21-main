/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class Subscriber extends Follower {

	private String[] recommendedVideos; 
	private int norv; //Number of Recommended Videos.

	public Subscriber(String name, int maxChannels, int maxRecommendedVideos) {
		super(name, maxChannels);
		this.maxRecommendedVideos = maxRecommendedVideos;

		this.recommendedVideos = new String [maxRecommendedVideos];
		this.norv = 0;
	}

	public void recommendedVideos(String video) {
		this.recommendedVideos[this.norv] = video;
		this.norv++;
	}

	/*
	 * Note: Check the getFollowers() and getReleasedVideos() method from Channel class. 
	 * 		 It provides the List of Strings of Followers and Released Videos respectively. 
	 * 
	 * Step-1. Find the channels being followed by the current subscriber.
	 * Step-2. Get the released videos list associated with each channel array.(Here I used channel.getReleasedVideos() to get released videos).
	 * Step-3. Match the "video" with the released videos of each Channel.
	 * Step-4. call 'ch.addWatchTime(watchTime)' method and pass watchTime data
	 * 
	 * (For Manual Testing uncomment the line: 36,40,44,45,46)
	 */
	public void watch(String video, int watchTime) {
		//Step 1 to 3 from line number 43 to 47.
		for(int i = 0; i < this.noc; i++) {
			boolean foundVidoMatch = false;
//			int index = -1;
			String[] releasedVideosList = this.channels[i].getReleasedVideos();
			for(int j = 0; j < releasedVideosList.length && (! foundVidoMatch); j++) {
				if(releasedVideosList[j].equals(video)) {
//					index = j;
					foundVidoMatch = true;
				}
			}
			if(foundVidoMatch) {
//				System.out.print("Found channel connected to video '" + video + "'.");
//				System.out.println("The index of video '" + video + "' is " + index + ".");	
//				System.out.println("The Channel contains video '" + video + "' is '" + this.channels[i].getName() + "'.");
				// Step-4. call 'ch.addWatchTime(watchTime)' method and pass watchTime data
				this.channels[i].addWatchTime(watchTime);
			}
		}
	} 

	private String getChannelsList() {
		String channelsList = "";
		for(int i = 0; i < this.noc; i++) {
			channelsList += this.channels[i].getName();
			if(i < this.noc - 1) {
				channelsList += ", ";
			}
		}
		return channelsList;
	}

	private String getVideosList() {
		String videosList = "";
		for(int i = 0; i < this.norv; i++) {
			videosList += this.recommendedVideos[i];
			if(i < this.norv - 1) {
				videosList += ", ";
			}
		}
		return videosList;
	}

	public String toString() {
		String status = "";

		if(this.noc == 0 && this.norv == 0 ) {
			status = String.format("Subscriber %s follows no channels and has no recommended videos.",this.name);
		}
		else if (this.noc > 0 && this.norv == 0 ) {
			status = String.format("Subscriber %s follows [%s] and has no recommended videos.",this.name, this.getChannelsList());
		}
		else {
			status = String.format("Subscriber %s follows [%s] and is recommended <%s>.", this.name, this.getChannelsList(), this.getVideosList());
		}
		return status;
	}
}