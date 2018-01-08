/******************************************************************************
#
#	%name: TriangleTest.java %
#	%derived_by: alok %
#
#	%release: Development/1.1.0 %
#	%version: 1 %
#	%date_modified: 9:20:22 PM %
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

class Coordinate {
	private int x, y;
	
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
}

class Triangle {
	private Coordinate A, B, C;
	
	Triangle(final Coordinate A, final Coordinate B, final Coordinate C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public boolean isValidTriangle() {
		if (A.getX() < 0 || B.getX() < 0 || C.getX() < 0 || A.getY() < 0 || B.getY() < 0 || C.getY() < 0) {
			return false;
		}
		
		if (A.getX() > 2000 || B.getX() > 2000 || C.getX() > 2000 || A.getY() > 2000 || B.getY() > 2000 || C.getY() > 2000) {
			return false;
		}
		
		if ((A.getX() == B.getX()) && (A.getX() == C.getX())) {
			return false;
		}
		
		if ((A.getY() == B.getY()) && (A.getY() == C.getY())) {
			return false;
		}
		
		return true;
	}
	
	public int calculateArea() {
		return (A.getX() * (B.getY() - C.getY()) + B.getX() * (C.getY() - A.getY()) + C.getX() * (A.getY() - B.getY()))/2;
	}

	
	public boolean coordinateWithinTriangle(Coordinate X) {
			
		return true;
	}
}

public class TriangleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Coordinate A = new Coordinate(2,2);
		Coordinate B = new Coordinate(6,4);
		Coordinate C = new Coordinate(4,8);
		
		Coordinate P = new Coordinate(4,6);
		
		Triangle triangle = new Triangle(A, B, C);
		
		if (!triangle.isValidTriangle()) {
			System.out.println("Triangle is not valid");
			return;
		}
			
		// Vliadate P
		Triangle PBC = new Triangle(P, B, C);
		if (!PBC.isValidTriangle()) {
			System.out.println("PBC Triangle is not valid");
			return;
		}
		
		Triangle APC = new Triangle(A, P, C);
		if (!APC.isValidTriangle()) {
			System.out.println("APC Triangle is not valid");
			return;
		}
		
		Triangle ABP = new Triangle(A, B, P);
		if (!ABP.isValidTriangle()) {
			System.out.println("ABP Triangle is not valid");
			return;
		}
		
		System.out.println("Triangle Area: " + triangle.calculateArea());
		System.out.println("ABP Area: " + PBC.calculateArea());
		System.out.println("ACP Area: " + APC.calculateArea());
		System.out.println("BCP Area: " + ABP.calculateArea());
		
		if (triangle.calculateArea() == (PBC.calculateArea() + APC.calculateArea() + ABP.calculateArea())) {
			System.out.println("P coordinate falls within ABC triangle!");
		} else {
			System.out.println("P coordinate doesnt fall within ABC triangle!");
		}
		
	}

}
