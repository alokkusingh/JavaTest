/******************************************************************************
#
#	%name: NumberFormatTest.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 9:52:33 PM %
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

import java.text.*;
import java.util.Locale;

public class NumberFormatTest {
	public static void main(String[] args) throws ParseException {
		String[] sa = { "111.234", "222.5678" };
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		for (String s : sa) {
			System.out.println("Without Format: " + nf.parse(s));
			System.out.println("With Format: "+ nf.format(nf.parse(s)));
			
		}
	}
}
