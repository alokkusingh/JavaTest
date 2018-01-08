/******************************************************************************
#
#	%name: TestHugeOrderedData.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 7:19:24 PM %
#
#	Description: Cassandra DB PA. %
#  Change History: None. %
#
#  Date        By                        Description
#  ----        -----------------------   -----------
#  24/07/2017  alok.singh@evolving.com   Cassnadra DB PA
#
#*****************************************************************************
# Copyright (c) 2017 Evolving Systems Ltd
# All Rights Reserved.
#
# The copyright to this program herein is the property of
# Evolving Systems Ltd. The program may be used and/or copied only with
# written permission of Evolving Systems Ltd or in accordance with the
# terms and conditions stipulated in the agreement/contract under
# which the program has been supplied.
#*****************************************************************************/
package alok.test.container;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class FacebookComments implements Comparable<FacebookComments> {

	private static Integer nextCommentID = 0;
	private Integer getNextCommentID() {
		return ++nextCommentID;
	}
	
	private Integer ID;
	private Integer likeCount;
	private String comment;
	
	public FacebookComments(String comment) {
		ID = getNextCommentID();
		this.comment = comment;
		likeCount = 0;		
	}
	
	public FacebookComments(String comment, Integer likes) {
		ID = getNextCommentID();
		this.comment = comment;
		likeCount = likes;		
	}
	
	public void incrLikes() {
		++likeCount;
	}
	
	public Integer geCommentID() {
		return ID;
	}
	
	public Integer getLikes() {
		return likeCount;
	}
	
	public String getComment() {
		return comment;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	
	@Override
	public int compareTo(FacebookComments o) {
		
		//this is to make sure we sort based on like counts
		if (likeCount < o.getLikes()) {
			return 1;
		}
		
		if (likeCount > o.getLikes()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "FacebookComments [ID=" + ID + ", likeCount=" + likeCount + ", comment=" + comment + "]";
	}
}

public class TestHugeOrderedData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<FacebookComments> facebookComments = new LinkedList<>();
		facebookComments.add(new FacebookComments("Alok", 2));
		facebookComments.add(new FacebookComments("Singh", 1));
		facebookComments.add(new FacebookComments("India", 3));
		facebookComments.add(new FacebookComments("Bangalore", 9));
		facebookComments.add(new FacebookComments("Karnataka", 212));
		facebookComments.add(new FacebookComments("Jyothi GT", 5));
		facebookComments.add(new FacebookComments("Sarjapur Road", 23));
		
		System.out.println("Printing original comments");
		printComments(facebookComments);
		
		System.out.println("\nPrinting sorted comments");
		Collections.sort(facebookComments);
		printComments(facebookComments);
	}
	
	private static void printComments(List<FacebookComments> comments) {
		for (FacebookComments comment : comments) {
			System.out.println(comment);
		}
	}

}
