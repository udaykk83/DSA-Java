package heaps;

import java.util.*;

public class B_Closest_Points_To_Origin {

	static class pair {
		int dist;
		int idx;

		pair(int dist, int idx) {
			this.dist = dist;
			this.idx = idx;
		}
	}

	public static void main(String[] args) {
		int pts[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };

		int k = 2;

		PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.dist > b.dist ? -1 : a.dist < b.dist ? 1 : 0);

		int i = 0;
		while (i < pts.length) {
			int d = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
			if (pq.size() < k) {
				pq.add(new pair(d, i));
			} else {
				if (pq.peek().dist > d) {
					pq.poll();
					pq.add(new pair(d, i));
				}
			}
			i++;
		}

		while (pq.size() > 0) {
			pair p = pq.poll();
			System.out.println(p.dist + "  " + pts[p.idx][0] + " " + pts[p.idx][1]);
		}

	}

}
