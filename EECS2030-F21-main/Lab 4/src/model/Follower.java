/*
 * Lab design by : Professor Chen-Wei(Jackie) Wang.
 */

package model;

public class Follower {

	protected String name;
	protected int maxChannels;
	protected int maxRecommendedVideos;
	
	protected Channel[] channels;
	protected int noc; // Number of channels

	public Follower(String name, int maxChannels) {
		this.name = name;
		this.maxChannels = maxChannels;
		
		this.channels = new Channel[maxChannels];
		this.noc = 0;
	}

	public void follow(Channel c) {
		this.channels[this.noc] = c;
		this.noc++;		
	}
	
	public void unfollow(Channel c) {
		int index = -1;
		boolean foundChannel = false;
		for(int i = 0; i < this.noc && (!foundChannel); i++) {
			Channel channel = this.channels[i];
			if(channel.getName().equals(c.getName())
					&& (channel.getMaxFollowers() == c.getMaxFollowers())
					&& (channel.getMaxReleasedVideos() == c.getMaxReleasedVideos())) {
				index = i;
				foundChannel = true;
			}
		}
		if (foundChannel) {
			for(int i = index; i < this.noc; i++){
				this.channels[i] = this.channels[i+1];
			}
			this.noc--;
		}
	}
	
	public String getName() {
		return name;
	}
}