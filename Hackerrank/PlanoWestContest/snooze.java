//basic maze checker with bfs

import java.util.*;
import java.io.*;

class Main {
    static final int[] di = { 0, 0, 1, -1 };
    static final int[] dj = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("guess.in"));
        String[] ar = new String[10];
        for (int i = 0; i < 10; i++)
            ar[i] = sc.next();

        int[][] dist = new int[10][10];
        Queue<int[]> q = new ArrayDeque<>();
        int ei = -1, ej = -1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                dist[i][j] = -1;
                if (ar[i].charAt(j) == 'S') {
                    dist[i][j] = 0;
                    q.add(new int[] { i, j });
                }
                else if (ar[i].charAt(j) == 'K') {
                    ei = i;
                    ej = j;
                }
            }
        }

		//for(int[] arr : q)
		//System.out.println(Arrays.toString(arr));


        // Breadth-first search
        while (!q.isEmpty()) {
            int[] pos = q.remove();
			//System.out.println(Arrays.toString(pos));
            for (int k = 0; k < 4; k++) {
                int i = pos[0] + di[k], j = pos[1] + dj[k];
                if (i < 0 || i >= 10 || j < 0 || j >= 10 || ar[i].charAt(j) == '#' || dist[i][j] != -1)
                    continue;
                dist[i][j] = dist[pos[0]][pos[1]] + 1;
                q.add(new int[] { i, j });
            }
        }

        int d = dist[ei][ej];

		if(d > -1)
			System.out.println("Number of Steps: " + d);
		else
			System.out.println("Invalid Maze");
		/*
        if (d <= 15)
            System.out.println("On time: " + d + " minutes");
        else
            System.out.println("Late: " + (d - 15) + " minutes");
		*/
	}
}
