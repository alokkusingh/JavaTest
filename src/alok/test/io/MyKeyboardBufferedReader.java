/******************************************************************************
#
#	%name: MyKeyboardBufferedReader.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 7:07:39 PM %
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
package alok.test.io;

import java.io.*;
class MyKeyboardBufferedReader
{
    public static void main(String args[])
                  throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter an integer");
        int a = Integer.parseInt(br.readLine());
        System.out.println("Enter a String");
        String b = br.readLine();
        System.out.printf("You have entered:- " + a +
                          " and name as " + b);
        
    }
}
