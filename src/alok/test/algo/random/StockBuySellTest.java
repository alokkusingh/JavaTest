package alok.test.algo.random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntUnaryOperator;

class Interval {
	private Integer buyDay;
	private Integer sellDay;
	
	public Integer getBuyDay() {
		return buyDay;
	}
	public void setBuyDay(int buyDay) {
		this.buyDay = buyDay;
	}
	public Integer getSellDay() {
		return sellDay;
	}
	public void setSellDay(int sellDay) {
		this.sellDay = sellDay;
	}
	
	@Override
	public String toString() {
		return "Interval [buyDay=" + buyDay + ", sellDay=" + sellDay + "]";
	}
	
	
}

class StockBuySell {

	public static List<Interval> findIntervals(Integer[] prices) {
		
		List<Interval> intervals = new LinkedList<>();
		
		Interval interval = new Interval();
		interval.setBuyDay(0);
		interval.setSellDay(prices.length-1);
		for (int i = 1; i < prices.length; i++) {
			
			if (prices[interval.getBuyDay()] > prices[i]) {
				if ((interval.getBuyDay()+1) == i) {
					interval.setBuyDay(i);
				} else {
					interval.setSellDay(i-1);
					intervals.add(interval);
					
					interval = new Interval();
					interval.setBuyDay(i);
					interval.setSellDay(prices.length-1);
				}
			} else {
				if (i == prices.length-1) {
					intervals.add(interval);
				}
			}
			
		}
		
		return intervals;
	}

}


public class StockBuySellTest {

	public static void main(String[] args) {
		Integer prices[] = new Integer[] { 100, 180, 260, 310, 40, 535, 695 };
		
		//Arrays.sort(prices); test ok
		Arrays.sort(prices, (o1, o2)  -> {
				if (o1 < 02) {
					return 1;
				}
				
				if (o1 > o2) {
					return -1;
				}
				
				return 0;
			});
		
		List<Interval> intervals = StockBuySell.findIntervals(prices);
		
		System.out.println(intervals);
	}
}
