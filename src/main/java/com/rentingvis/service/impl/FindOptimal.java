package com.rentingvis.service.impl;

import java.util.*;
import java.io.*;


/*
//demo

FindOptimal opt = new FindOptimal();
opt.readMap(number of houses, houseList);
ArrayList<Integer> recomendList = opt.solve..(k);
opt.solveFirstK(k) //indexed from 0
opt.solveDistLessThan(dist);
*/

public class FindOptimal {
	private int numRoadPoints, numHouses;
	private double houseDist[], dist[][];
	private static int map_readed;
	private ArrayList<Integer> E[];
	private Point[] houses, roadKeyPoint;

	public int findClosestRoadIntersections(Point S) {
		int closestPoint = 1;
		for (int i = 2; i <= numRoadPoints; ++i){
			if ( S.distToPoint(roadKeyPoint[i]) < S.distToPoint(roadKeyPoint[closestPoint]) ) {
				closestPoint = i;
			}
		}
		return closestPoint;
	}

	public void calcDist(double dist[], Point S) {
		int n = numRoadPoints;
		int q[] = new int[n + 1];
		int vis[] = new int[n + 1];
		for (int i = 1; i <= n; ++i)
			dist[i] = 1e8;
		int f = 0, r = 0, x, closestPoint = findClosestRoadIntersections(S);
		dist[closestPoint] = S.distToPoint(roadKeyPoint[closestPoint]);
		q[++r] = closestPoint;
		
		while (f != r) {
			f = f + 1;
			if (f == n + 1) f = 1;
			x = q[f];
			vis[x] = 0;
			for (int y: E[x]) {
				double w = roadKeyPoint[x].distToPoint(roadKeyPoint[y]);
				if (dist[y] > dist[x] + w){
					dist[y] = dist[x] + w;
					if (vis[y] == 0) {
						vis[y] = 1;
						r = r + 1;
						if (r == n + 1) r = 1;
						q[r] = y;
					}
				}
			}
		}
	}

	public void readMap(int _numHouses, ArrayList<Point> houseList) {

		//if (map_readed == 1) return;
		//map_readed = 1;
		numHouses = _numHouses;

		houses = new Point[numHouses + 1];
		for (int i = 0; i < numHouses; ++i)
			houses[i] = houseList.get(i);

	
		try {
			File file = new File("F:\\formal\\llsw\\src\\main\\java\\com\\rentingvis\\service\\impl\\road2.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<Integer> list = new ArrayList<Integer>();
			String tmp;
			
			numRoadPoints = Integer.parseInt(tmp = br.readLine());
	
			E = (ArrayList<Integer>[])new ArrayList[numRoadPoints + 1];
			for (int i = 0; i <= numRoadPoints; ++i)
				E[i] = new ArrayList<Integer>();
			roadKeyPoint = new Point[numRoadPoints + 1];
			for (int i = 1; i <= numRoadPoints; ++i){
				tmp = br.readLine();
				String ss[] = tmp.split(" ");
				roadKeyPoint[i] = new Point(Double.parseDouble(ss[0]), Double.parseDouble(ss[1]));
			}
			
			
			int m = Integer.parseInt(tmp = br.readLine());
			for (int i = 1; i <= m; ++i){
				tmp = br.readLine();
				String ss[] = tmp.split(" ");
				int a = Integer.parseInt(ss[0]);
				int b = Integer.parseInt(ss[1]);
				E[a].add(b);
				E[b].add(a);
			}
			
			br.close();
		}
		catch (Exception e) {
			System.out.println("can not read files");
		}
		
	}
	
	public ArrayList<Integer> solveFirstK(int k, ArrayList<Point> choosed){
		
		dist = new double[choosed.size()][numRoadPoints + 1];
		for (int i = 0; i < choosed.size(); ++i){
			calcDist(dist[i], choosed.get(i));
		}
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < numHouses; ++i)
			ret.add(i);
		houseDist = new double[numHouses];

		for (int i = 0; i < numHouses; ++i) {
			int t = findClosestRoadIntersections(houses[i]);
			houseDist[i] = roadKeyPoint[t].distToPoint(houses[i]);
			for (int j = 0; j < choosed.size(); ++j)
				houseDist[i] += dist[j][t];
		}

		Collections.sort(ret, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (houseDist[a] < houseDist[b]) return -1;
				else return 1;
			}
		});
		
		ArrayList<Integer> recomendList = new ArrayList<Integer>();
		for (int i = 0; i < k && i < ret.size(); ++i)
			recomendList.add(ret.get(i));
	    return recomendList;
	}

	public ArrayList<Integer> solveDistLessThan(double distLimit, ArrayList<Point> choosed) {
		dist = new double[choosed.size()][numRoadPoints + 1];
		for (int i = 0; i < choosed.size(); ++i){
			calcDist(dist[i], choosed.get(i));
		}
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < numHouses; ++i)
			ret.add(i);
		houseDist = new double[numHouses];

		for ( int i = 0; i < numHouses; ++i ) {
			int t = findClosestRoadIntersections(houses[i]);
			houseDist[i] = roadKeyPoint[t].distToPoint(houses[i]);
			for (int j = 0; j < choosed.size(); ++j)
				houseDist[i] += dist[j][t];
		}
		
		ArrayList<Integer> recomendList = new ArrayList<Integer>();
		for (int i = 0; i < ret.size(); ++i)
			if (houseDist[i] < distLimit)
				recomendList.add(ret.get(i));
	    return recomendList;
	}
	
	public void test() {
		ArrayList<Point> hs = new ArrayList<Point>();
		for (int i = 1; i <= 6000; ++i)
			hs.add(new Point(1, 1));
		readMap(6000, hs);
		
		ArrayList<Point> choosed = new ArrayList<Point>();
		choosed.add(new Point(4, 4));
		choosed.add(new Point(3, 5));
		choosed.add(new Point(2, 6));
		for (int x: solveFirstK(100, choosed)) System.out.println(x);

		//for (int x: solveDistLessThan(100000000, choosed)) System.out.println(x);
	}

	/*
	public static void main(String[] args) throws Exception {
		try {
			new FindOptimal().test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */

}