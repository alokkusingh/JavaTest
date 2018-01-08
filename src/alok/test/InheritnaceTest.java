/******************************************************************************
#
#	%name: InheritnaceTest.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 1:42:58 PM %
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
package alok.test;

class MyBase {
	private int privateIntVar;
	private static int privateStaticInt;
	
	void myTest() {
		System.out.println("MyBase test");
	}
}


class MyDerive extends MyBase {
	//below will be error - incompatible method 
	/*int myTest() {
		System.out.println("MyBase test");
		return 0;
	}*/
}

public class InheritnaceTest {
    public static void main(String[] args) {
    	MyBase base = new MyDerive();
    	
    	//compilation error
    	//base.privateIntVar = 10;
    	
    	//complilation error
    	//base.privateStaticInt;
    }
}
