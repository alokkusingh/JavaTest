/******************************************************************************
#
#	%name: ArgumentDefinedAnonumousInnerClass.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 10:12:18 AM %
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

interface AnInterface {
	void doSomething();
}

interface BnInterface {
	void doSomething(int x);
}

class AClass {
	void doSomething(AnInterface anInterface) {
		anInterface.doSomething();
	}
	
	void doSomething(BnInterface bnInterface) {
		bnInterface.doSomething(10);
	}
}

public class ArgumentDefinedAnonumousInnerClass {

	public static void main(String[] args) {

		AClass aClass = new AClass();
		
		// an example
		aClass.doSomething(new AnInterface() {
			@Override
			public void doSomething() {
				System.out.println("Actually doing something");

			}
		});
	
		/*
		//in java 8 this will be writen as below
		aClass.doSomething(() -> {
			System.out.println("Actually doing something");
		};
		
		// or
		aClass.doSomething(() -> System.out.println("Actually doing something");
		*/
		
		
		// another example
		aClass.doSomething(new BnInterface() {
			@Override
			public void doSomething(int i) {
				System.out.println("Actually doing diffrent " + i);

			}
		});
	
		/*
		//in java 8 this will be writen as below
		aClass.doSomething((int i) -> {
			System.out.println("Actually doing something " + i);
		};
		
		//or
		aClass.doSomething(i -> {
			System.out.println("Actually doing something " + i);
		};
		
		// or
		aClass.doSomething((i) -> System.out.println("Actually doing something " + i);
		
		//or
		aClass.doSomething(i -> System.out.println("Actually doing something " + i);
		
		*/

	}
}
