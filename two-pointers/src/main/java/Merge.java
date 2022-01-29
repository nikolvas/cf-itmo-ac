import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Merge implements Runnable {
    public static void main(String[] args) throws IOException {
        new Thread(null, new Merge(), "Main", 1 << 26).start();
    }

    @Override
    public void run() {
        FastScanner scanner = new FastScanner();
        int n = 0, m = 0;
        try {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[] ns = new int[n];
            for (int i = 0; i < n; i++) {
                ns[i] = scanner.nextInt();
            }
            int[] ms = new int[m];
            for (int i = 0; i < m; i++) {
                ms[i] = scanner.nextInt();
            }
            System.out.println(Arrays.stream(merge(ns, ms)).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] merge(int[]n, int[]m){
        int nL = n.length;
        int mL = m.length;
        int[] res = new int[nL + mL];
        int i = 0, j = 0;
        while(i < nL && j < mL){
            if(n[i] <= m[j]){
                res[i+j] = n[i];
                i++;
            }else{
                res[i+j] = m[j];
                j++;
            }
        }
        while(i < nL){
                res[i+j] = n[i];
                i++;
        }
        while(j < mL){
            res[i+j] = m[j];
            j++;
        }

        return res;
    }


    public static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        public FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}
