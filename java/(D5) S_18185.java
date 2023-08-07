import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int cycle = 0; cycle < 3; cycle++) {
            for (int cur = 0; cur < N; cur++) {
                if (arr[cur] == 0) continue;
                else if (arr[cur + 2] > 0 && arr[cur + 1] > arr[cur + 2]) {
                    int x = Math.min(arr[cur], arr[cur + 1] - arr[cur + 2]);
                    result += 5 * x;

                    arr[cur] -= x;
                    arr[cur + 1] -= x;

                    cur--;
                } else if (arr[cur + 1] != 0 && arr[cur + 2] != 0) {
                    int x = Math.min(Math.min(arr[cur], arr[cur + 1]), arr[cur + 2]);
                    result += 7 * x;

                    arr[cur] -= x;
                    arr[cur + 1] -= x;
                    arr[cur + 2] -= x;
                } else if (arr[cur + 1] != 0) {
                    int x = Math.min(arr[cur], arr[cur + 1]);
                    result += 5 * x;

                    arr[cur] -= x;
                    arr[cur + 1] -= x;
                } else {
                    int x = arr[cur];
                    arr[cur] -= x;
                    result += 3 * x;
                }

                //System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(result);
    }
}
