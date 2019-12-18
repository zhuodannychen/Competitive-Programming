import java.util.*;
import java.io.*;

public class mountains {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new File("mountains.in"));
        BufferedReader bf = new BufferedReader(new FileReader("mountains.in"));
        int num_mountains = Integer.parseInt(bf.readLine());
        int[][] arr = new int[num_mountains][2];
        StringTokenizer st;
        for (int i = 0; i < num_mountains; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x - y; arr[i][1] = x + y;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0])
                    return 1;
                else if (o1[0] < o2[0])
                    return -1;
                else if (o1[1] > o2[1])
                    return -1;
                else
                    return 1;
            }
        });
        System.out.println(Arrays.deepToString(arr));
        int max = arr[0][1];
        int count = 1;
        for (int i = 1; i < num_mountains; i++) {
            if (arr[i][1] <= max) {
                continue;
            } else {
                max = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
        PrintWriter pw = new PrintWriter(new File("mountains.out"));
        pw.println(count);
        pw.close();
    }
}
