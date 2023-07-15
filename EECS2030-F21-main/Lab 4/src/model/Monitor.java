/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class Monitor extends Follower {

	//{#views: 1, max watch time: 20, avg watch time: 20.00}
	private int[] views; //views[i] will indicate how many times channels[i] has been watched.
	private int[] totalWatchedTime; //totalWatchedTime[i] will indicate total watch time of channels[i].
	private int[] maxWatchTime; //maxWatchedTime[i] will indicate maximum watch time of channels[i].
	private double[] avgWatchedTime; //avgWatchedTime[i] will indicate average watch time of channels[i].

	public Monitor(String name, int maxChannels) {
		super(name, maxChannels);
		this.views = new int[maxChannels];
		this.totalWatchedTime = new int[maxChannels];;
		this.maxWatchTime = new int[maxChannels];;
		this.avgWatchedTime = new double[maxChannels];
	}

	/*
	 * Note: Check the getFollowers() and getReleasedVideos() method from Channel class. 
	 * 		 It provides the List of Strings of Followers and Released Videos respectively. 
	 * 
	 * Step-10. Find the index of the Channel name from channelName parameter.
	 * Step-11. After finding the index of the channel. Save all watch time to particular index of the array.
	 * 		Note: {#views: 1, max watch time: 20, avg watch time: 20.00}
	 * 				Length arrays we are using to save 'number of views', 'max watch time', and 'avg. watch time' is same as the 'Maximum Channels Size array'.
	 * Step-12. Find 'max watch time' by comparing with the 'watchTime' parameter and save it particular index of the maxWatchedTime array.
	 * Step-13. Find 'avg. watched time' and save it particular index of the avgWatchedTime array.
	 * Step-14. To print the data check this.getChannelsList() method.
	 * 
	 * (For Manual Testing uncomment the line: 35,45,47,52,54)
	 */
	public void updateStat(String channelName, int watchTime) {
//		System.out.println("Channel name is '" + channelName + "' and watch time is: " + watchTime);
		boolean foundChannelMatch = false;
		int index = -1;
		for(int i = 0; i < this.noc && (!foundChannelMatch); i++) {
			if(this.channels[i].getName().equals(channelName)) {
				index = i;
				foundChannelMatch = true;
			}
		}
		if(foundChannelMatch) {
//			System.out.println("Found the index of '" + channelName + "'" + "and the index of this channel is: " + index);
			this.views[index] += 1;
//			System.out.print("#views:" + this.views[index]);
			if(this.maxWatchTime[index] < watchTime) {
				this.maxWatchTime[index] = watchTime;
			}
			this.totalWatchedTime[index] += watchTime;
//			System.out.print(", max watch time: " + this.totalWatchedTime[index]);
			this.avgWatchedTime[index] = ((double) this.totalWatchedTime[index])/((double)this.views[index]);
//			System.out.println(", avg watch time:" + this.avgWatchedTime[index]);
		}
	}

	private String getChannelsList() {
		String channelsList = "";
		for(int i = 0; i < this.noc; i++) {
			channelsList += this.channels[i].getName();
			// if views at index 'i' is not zero i.e. 'this.views[i] > 0' then print the line
			// Line to print with particular channel {#views: 1, max watch time: 20, avg watch time: 20.00}
			if (this.views[i] > 0) {
				channelsList += String.format(" {#views: %d, max watch time: %d, avg watch time: %.2f}", 
						this.views[i], this.maxWatchTime[i], this.avgWatchedTime[i]);
			}
			if(i < this.noc - 1) {
				channelsList += ", ";
			}
		}
		return channelsList;
	}

	public String toString() {
		String status = "";
		if(noc ==0) {
			status = String.format("Monitor %s follows no channels.", this.name);
		}
		else {
			status = String.format("Monitor %s follows [%s].",this.name, this.getChannelsList());
		} 
		return status;
	}
}