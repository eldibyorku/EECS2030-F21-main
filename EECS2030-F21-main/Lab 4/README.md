## Lab 4 is The Video Channel Platform Problem (e.g., YouTube)
**Lab design by Professor Chen-Wei(Jackie) Wang**

This object-oriented program is solving aspects of a video channel platform (e.g., YouTube), where each video channel has a number of followers, each of which being either one subscribed to the channel and watching videos as new ones are released, or one monitoring the channel's statistis (e.g., average watch time).

#### **The relevant entities involved in this problem:**
- Each video ***channel*** is characterized by its name (e.g., **Cafe Music BGM channel**), its list of followers, and its list of released videos. New followers may be added, and existing followers may be removed. When a channel is first created, it is specified with both the **maximum number of followers allowed** and the **maximum number of released videos allowed**. Periodically, a channel may update itself by releasing a video (e.g.,MONDAY MORNING JAZZ: Sweet November Jazz Music).

###### (a)Example Statistics of a Video Channel
- shows some example statistics of a video channel (e.g., views, watch time).
![4 1](https://user-images.githubusercontent.com/90284881/148714798-07e9fe5c-f1f4-4d36-b805-19bc6636ed1d.png)
###### (b) Multiple Channels Followed by Multiple Followers
  - shows that a channel may be linked to multiple followers (e.g., channel ch2 followed by f1 and f2), whereas each follower may be linked to multiple channels (e.g., f2 follows ch1 and ch2).
![4 2](https://user-images.githubusercontent.com/90284881/148714802-2d8a9d7b-3ffd-4485-9768-1d230c8ef5c3.png)

- Each video channel ***follower*** is characterized by its name and can be linked to a list of channels. Each follower should be kept in synch with each of the channel it follows, whenever a channel update occurs. Specifically, there are two kinds of channel followers:
  - A channel monitor follows a **list of channels**. When a monitor is first created, it is specified with the maximum number of channels allowed to follow. For each of the channel it follows, the channel maintains a list of statistical data (updated as soon as a subscriber of the same channel watched one of its released videos): number of views, maximum watch time, and average watch time.
  - A channel ***subscriber*** follows a list of channels and is recommended videos by these channels (whenever there is a new release). When a subscriber is first created, it is specified with both the maximum number of channels allowed to follow and the maximum number of recommended videos allowed. A subscriber may watch each of the recommended videos for as many times as they like: each time after they watch a video of a channel, all monitors following that channel will be updated for their statistics (e.g., number of views, average watch time) accordingly.

