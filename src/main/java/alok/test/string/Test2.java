/******************************************************************************
#
#	%name: Test2.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 3:12:39 PM %
#
#	Description: Cassandra DB PA. %
#  Change History: None. %
#
#  Date        By                        Description
#  ----        -----------------------   -----------
#  24/07/2017  alok.ku.singh@gmail.com
Cassnadra DB PA
#
#*****************************************************************************
# Copyright (c) 2017 dummy
# All Rights Reserved.
#
# The copyright to this program herein is the property of
# dummy. The program may be used and/or copied only with
# written permission of dummy or in accordance with the
# terms and conditions stipulated in the agreement/contract under
# which the program has been supplied.
#*****************************************************************************/
package alok.test.string;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// A   l   o   k     S   i   n   g   h
		//65 108 111 107 32 83 105 110 103 104
		String decRevorder = "401301011501382370111180156";
		decRevorder = new StringBuilder(decRevorder).reverse().toString();
		int value = 0;
		StringBuilder finalString = new StringBuilder();
		
		for (char ch: decRevorder.toCharArray()) {
			value = value * 10 + ch - 48;
			if (value == 32 || (value >= 65 && value <= 90) || (value >= 97 && value <= 122) ) {
				finalString.append((char)value);
				
				//below will append the Deciaml instead of ASCII
				//finalString.append(value);
				value = 0;
			}
		}
		
		System.out.println(finalString);
	}
}
