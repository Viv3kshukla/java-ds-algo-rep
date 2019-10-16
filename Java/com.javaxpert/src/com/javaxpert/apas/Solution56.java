package com.javaxpert.apas;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution56 {
	
	/*
	 * Given a collection of intervals, merge all overlapping intervals
	 * Example : [[1,3],[2,6],[8,10]]
	 * Output : [[1,6],[8,10],[15,18]]
	 */
	
	static class Interval {
		public int start;
		public int end;
	}
	
	private class IntervalComparator implements Comparator<Interval> {
		
		@Override
		public int compare(Interval a,Interval b) {
			return a.start < b.start ? -1: a.start == b.start ? 0:1;
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
		
		LinkedList<Interval> merged = new LinkedList<Interval>();
		for(Interval interval: intervals) {
			
			if(merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			}
			else {
				merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			}
		}
		
		return merged;
	}
}
	
