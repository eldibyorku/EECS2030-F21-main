## Lab 1 is The APPLE AppStore Problem
**Lab design by Professor Chen-Wei(Jackie) Wang**

This object-oriented program is solving a simplified AppStore (the Apple iOS counterpart of Google Play store) problem, where a list of apps is available for downloads by registered accounts, whose owners may submit rating scores to some downloaded apps:

#### **The relevant entities involved in this problem:**
- Each update ***log*** is characterized by their version (e.g.,**5.7.31**) and fixes from the earlier version (e.g.,**Addressed writing log issues**). A log's fixes are represented as a comma-separated list of string values enclosed within a pair of square brackets (e.g.,**[Fix 1, Fix 2]**). The maximum number of allowable fixes for an update log is **10**.
- Each ***app*** is characterized by their name (e.g.,**GoodNotes 5**), a list of update logs (for its various versions), and a list of user rating scores. When submitting a rating score, it is assumed that a value between 1 and 5 is given (and thus there is no need to perform any error handling). When creating an app object, an input integer is supplied to specify the maximum number of submitted ratings allowed. On the other hand, the maximum number of update logs allowed for an app is always **20**. It is expected that when a rating report is demanded for an app, details of its current version and an average of its submitted ratings are included.
- Each ***app store*** is characterized by their branch name (e.g.,**Canada, UK**) and a list of available apps. When creating an app store object, an input integer is supplied to specify the maximum number of available apps allowed. You can assume that names of all available apps are unique (without duplicates). Given the name of an app, if it exists, one may retrieve the corresponding app object. Given a user-specified number (assumed to be non-negative), we may retrieve the information of the list of available apps which are stable: each of such apps has its number of updates at least as many as (larger than or equal to) the specified input number.
- Each registered ***account*** is characterized by its account owner name, the store it is linked to, the list of downloaded apps, and its status. The maximum number of downloads allowed for an app account is always 50. An account's status (represented by the return value of the **toString** method) reports whether or not the last invoked mutator method (e.g.,download an app, uninstall an app, submit a rating score to some app) results in an error. Given an account object, we may either inquire the names (String[]) or the corresponding app objects (App[]) available in its linked app store.

###### List of Apps in the Canadian AppStore
![Lab 1 1](https://user-images.githubusercontent.com/90284881/148710452-f593f6d2-f0c5-4888-9366-2833d935cbec.png)
###### An App Available in the AppStore
![Lab 1 2](https://user-images.githubusercontent.com/90284881/148710455-4102891e-dfd2-438b-8e3c-4c5c2856ef04.png)
