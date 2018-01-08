/******************************************************************************
#
#	%name: CloneTest.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 3:34:09 PM %
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
package alok.test.clone;

class Base implements Cloneable {
	public String str;
	Base() {
		str = "Alok";
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Derive extends Base  {
	public int x;
	public String str2;
	
	Derive() {
		super();
		x = 10;
		str2 = "Singh";
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setStr2(int x) {
		this.x = x;
	}
	
	public Derive clone() throws CloneNotSupportedException {
		return (Derive) super.clone();
	}

	@Override
	public String toString() {
		return "Derive [x=" + x + ", str=" + str + ", str2=" + str2 +"]";
	}
}

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Derive d = new Derive();
		
		Derive cloned = d.clone();
		cloned.setX(20);
		System.out.println(cloned);
		System.out.println(d);
	}
	
}
