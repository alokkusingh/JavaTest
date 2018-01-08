/******************************************************************************
#
#	%name: AnonymousInnerClass.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 10:01:32 AM %
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
package alok.test.innerclass;

class MyClass {
	protected void doSomething() {
		System.out.println("Doing something - not applicable if you need something special!");
	}
}

interface MyInterface {
	public void doSomething();
}

public class AnonymousInnerClass {

	public static void main(String[] args) {
		//this is one example of annonymous inner clss
		// this will genarate class file with name AnonymousInnerClass$1.class
		MyClass myClass = new MyClass() {
			public void doSomething() {
				System.out.println("Doing something special!");
			}
		};
		
		myClass.doSomething();
		
		//this is another example of annonymous inner clss
		// this will genarate class file with name AnonymousInnerClass$2.class
		MyInterface myInterface = new MyInterface() {

			@Override
			public void doSomething() {
				System.out.println("Actually doing something!");
			}			
		};
		
		myInterface.doSomething();
		
	}

}
