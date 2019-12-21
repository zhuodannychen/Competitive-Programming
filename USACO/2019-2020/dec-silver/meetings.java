import java.util.*;
import java.io.*;

public class meetings {
    public static int L;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("meetings.in"));
        int num_of_cows = sc.nextInt();
        L = sc.nextInt();
        int[][] arr = new int[num_of_cows][2];
        int[] cowPositions = new int[num_of_cows];
        int[] cowWeight = new int[num_of_cows];
        boolean[] cowDirection = new boolean[num_of_cows];
        int totalWeight = 0;
        for (int i = 0; i < num_of_cows; i++) {
            int w = sc.nextInt();
            int x = sc.nextInt();
            int d = sc.nextInt();
            cowWeight[i] = w;
            cowPositions[i] = x;
            cowDirection[i] = (d>0);
            arr[i][0] = i; arr[i][1] = x;
            totalWeight += w;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1])
                    return 1;
                return -1;
            }
        });

        //System.out.println(Arrays.deepToString(arr));
        int weights = 0;
        ArrayList<Integer> goingLeft = new ArrayList<>();
        ArrayList<Integer> goingRight = new ArrayList<>();
        for (int i = 0; i < num_of_cows; i++) {
            if (cowDirection[arr[i][0]])
                goingRight.add(arr[i][0]);
            else
                goingLeft.add(arr[i][0]);
        }
        //System.out.println(goingLeft);
        //System.out.println(Arrays.toString(cowDirection));
        int time = 0;
        int currentLeft = 0;
        int currentRight = goingRight.size() - 1;
        int left_id = 0;
        int right_id = num_of_cows - 1;
        int going = 0;
        while (weights * 2 < totalWeight) {
            going++;
            if (currentLeft < goingLeft.size() && currentRight >= 0) {
                if (getLength(goingLeft.get(currentLeft), true, cowPositions) < getLength(goingRight.get(currentRight), false, cowPositions)) {
                    weights += cowWeight[arr[left_id][0]];
                    left_id++;
                    time = getLength(goingLeft.get(currentLeft), true, cowPositions);
                    currentLeft++;
                } else {
                    weights += cowWeight[arr[right_id][0]];
                    right_id--;
                    time = getLength(goingRight.get(currentRight), false, cowPositions);
                    currentRight--;
                }
            } else if (currentLeft < goingLeft.size()) {
                weights += cowWeight[arr[left_id][0]];
                left_id++;
                time = getLength(goingLeft.get(currentLeft), true, cowPositions);
                currentLeft++;
            } else if (currentRight >= 0) {
                weights += cowWeight[arr[right_id][0]];
                right_id--;
                time = getLength(goingRight.get(currentRight), false, cowPositions);
                currentRight--;
            }
        }

        //System.out.println(time + " " + going);
        int count = 0;
        int start_id = 0;
        int middleCount = 0;
        boolean flag = true;
        while (start_id < arr.length && !cowDirection[arr[start_id][0]]) {
            start_id += 1;
        }
        int end_id = start_id + 1;
        while (start_id < arr.length) {
            int pos = cowPositions[arr[start_id][0]];
            while (end_id < arr.length && cowPositions[arr[end_id][0]] - pos <= 2 * time) {
                if (!cowDirection[arr[end_id][0]]) {
                    middleCount++;
                }
                end_id++;
            }
            count += middleCount;
            start_id++;
            while (start_id < arr.length && !cowDirection[arr[start_id][0]]) {
                middleCount--;
                start_id++;
            }
        }
        //System.out.println(count);
        PrintWriter pw = new PrintWriter(new File("meetings.out"));
        pw.println(count);
        pw.close();
    }

    public static int getLength(int id, boolean whichSide, int[] cowPositions) {
        if (whichSide)
            return cowPositions[id];
        return L-cowPositions[id];
    }
}
