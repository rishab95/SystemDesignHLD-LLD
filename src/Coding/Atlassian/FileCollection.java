package Coding.Atlassian;

/**
 * BANK ATLASSIAN
 *
 * Problem Description
 * Imagine we have a system that stores files, and these files can be grouped into collections.
 * We are interested in knowing where our resources are being taken up.
 * For this system we would like to generate a report that lists:
 * • The total size of all files stored; and An example input into your report generator might lock like:
 * • The top N collections (by file size) where N can be a user-defined value
 * filel.txt (size: 100)
 * file2.txt (size: 200)
 * in collection "collection"
 * file3.txt (size: 200)
 * in collection "collection1"
 * file4. txt (size: 300) in collection "collection2" file5.txt (size: 10)
 *
 * You should encourage candidates to transform the above into an in-memory representation of their choice
 * (e.g. listof(File("file1.txt", 100, null), -) ). We are not expecting candidates to parse the above input,
 * so guide them away from that.
 * Some candidates equate "collection" with "folder" which is not quite the right mental model.
 * It can sometimes be helpful to clarify by saying something along the lines of "you can think of
 * collections as being like tags for files".
 * Files may not be in a collection. How does the candidate deal with that? Do they pick up on it?
 * A basic solution can be arrived at by using a map to store the size of each collection and accumulate
 * into that map through a single pass over the input files. The ordered list of collections can be
 * obtained by sorting the map on the value.
 * An example (basic) solution might look like:
 *
 * LEETCODE
 * Each file has a collectionId attached to it Generate a report to show total size of the files
 * and top N collections by size Scale up to include multiple collections per file How would you handle
 * this in a multithreaded env
 * For DSA Interviewer asked about the file tagging problem.
 * I am given files, file size and the tag e.g.
 * <f1, 100>, <f2, 200> <f3, 10>
 *
 * <tag1, <f1, f2>> , <tag2, f3>
 *
 * As output result top N tags where to files size is highest.
 *
 * I shared the optimised approach, could code 1 approach as well.
 */
public class FileCollection {
}
