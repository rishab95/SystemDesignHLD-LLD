package Coding.Atlassian;

/**
 * Imagine you are given a stream of content ids along with an associated action to be performed on them.
 * Example of contents are video, pages, posts etc. There can be two actions associated with a content id:
 * • increasePopularity → increases the popularity of the content by 1. The popularity increases when someone comments on the content or likes the content
 * • decreasePopularity → decreases the popularity of the content by 1. The popularity decreases when a spam bot's/users comments are deleted from the content or its likes are removed from the content
 * • content ids are positive integers
 * Implement a class that can return the mostPopular content id at any time while consuming the stream of content ids and its associated action if there are no contentids with popularity greater than 0, return -1
 * Share the below snippet with the candidate
 * interface MostPopular {
 * void increasePopularity (Integer contentId);
 * Integer mostPopular ):
 * void decreasePopularity(Integer contentId);
 * }
 * Sample execution:
 * popularityTracker. increasePopularity(7);
 * popularityTracker. increasePopularity(7);
 * popularityTracker. increasePopularity(8);
 * popularityTracker.mostPopular():// returns 7
 * popularityTracker. increasePopularity(8);
 * popularityTracker. increasePopularity(8);
 * popularityTracker.mostPopular();// returns 8
 * popularityTracker.decreasePopularity(8);
 * ponylanityTracker desseasoPonnlanity/80a
 *
 * Judgement
 *
 *
 */
public class DataStructurePopularity {
}
