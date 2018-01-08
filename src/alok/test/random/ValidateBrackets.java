package alok.test.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidateBrackets {

	static class Bracket {
		Character ch;
		Character matching;
		boolean isOpeing;
		
		public Bracket(Character ch, Character matching, boolean isOpeing) {
			super();
			this.ch = ch;
			this.matching = matching;
			this.isOpeing = isOpeing;
		}
		
		public Character getMatching() {
			return matching;
		}

		public boolean isOpeing() {
			return isOpeing;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((ch == null) ? 0 : ch.hashCode());
			return result;
		}
		
		
		@Override
		public String toString() {
			return "[ch=" + ch + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Bracket other = (Bracket) obj;
			if (ch == null) {
				if (other.ch != null)
					return false;
			} else if (!ch.equals(other.ch))
				return false;
			return true;
		}
		
		static Bracket createBracketObject(Character ch) {
			switch (ch) {
				case '[': return new Bracket('[', ']', true);
				case ']': return new Bracket(']', '[', false);
				case '{': return new Bracket('{', '}', true);
				case '}': return new Bracket('}', '{', false);
				case '(': return new Bracket('(', ')', true);
				case ')': return new Bracket(')', '(', false);
			}
			return null;
			
		}
	} // closing of Barcket
	
	static private Set<Bracket> bracetMap;// = new HashSet<Bracket>();
	
	static {
		bracetMap = new HashSet<Bracket>();
		for (Character ch: "[]{}()".toCharArray()) {
			bracetMap.add(Bracket.createBracketObject(ch));
		}
	}
	
	static boolean isValidFormat (String str) {
		System.out.println("isValidFormat called");

		Stack<Bracket> stack = new Stack<Bracket>();
		for (Character ch : str.toCharArray()) {
			Bracket br = Bracket.createBracketObject(ch);
			if (bracetMap.contains(br)) {
				if (br.isOpeing()) {
					stack.push(br);
				} else {
					if (stack.isEmpty())
						return false;

					Bracket poppedBr = stack.pop();
					if (!poppedBr.getMatching().equals(ch)) {
						return false;
					}
				}
			}
		}
		
		if (!stack.isEmpty())
			return false;
			
		return true;
	}
}
