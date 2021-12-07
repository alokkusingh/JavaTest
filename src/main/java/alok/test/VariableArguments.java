/******************************************************************************
#
#	%name: VariableArguments.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 2:24:03 PM %
#
#	Description: Cassandra DB PA. %
#  Change History: None. %
#
#  Date        By                        Description
#  ----        -----------------------   -----------
#  24/07/2017  alok.ku.singh@gmail.com   Cassnadra DB
#

package alok.test;

public class VariableArguments {

	static void myVarArgMethod(String... strArgs) {
		System.out.println("Number of args: " + strArgs.length);

		for (String str : strArgs) {
			System.out.println(str);
		}
	}

	static void myVarArgMethod(int mand, String... strArgs) {
		System.out.println("Number of args (1 mand): " + (strArgs.length + 1));

		System.out.println(mand);
		for (String str : strArgs) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		myVarArgMethod();

		myVarArgMethod("1", "2", "3", "4");

		myVarArgMethod(1);

		myVarArgMethod(4, "1", "2", "3", "4");
	}

}