/******************************************************************************
#
#	%name: Bees.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 9:43:18 PM %
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
package alok.test.thread;

public class Bees {
	public static void main(String[] args) {
		try {
			new Bees().go();
		} catch (Exception e) {
			System.out.println("thrown to main: " + e.getStackTrace());
			e.printStackTrace();
		}
	}

	synchronized void go() throws InterruptedException {
		Thread t1 = new Thread();
		t1.start();
		System.out.print("1 ");
		// since the main thread is the owner of the resource (not t1) - IllegalMonitorStateException - if the current thread is not the owner of the object's monitor.
		t1.wait(5000);
		
		//but the below will work
		//wait(5000);
		
		System.out.print("2 ");
	}
}