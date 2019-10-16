package com.javaxpert.apas;

import java.util.List;

import com.javaxpert.apas.Solution56.Interval;

public class Solution57 {
	
/*
 * Given a set of non-overlapping intervals, insert a new interval
 * into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according 
 * to their start times.
 * 
 * Example : intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Answer : [[1,5],[6,9]]
 */

	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		
		while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
			i++;
		}
		
		while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			Interval inter = intervals.remove(i);
			newInterval.start = Math.min(inter.start, newInterval.start);
			newInterval.end = Math.max(inter.end, newInterval.end);
		}
		intervals.add(i,newInterval);
		return intervals;
		
	}
	
}
