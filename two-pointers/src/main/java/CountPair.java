import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CountPair implements Runnable {
    public static void main(String[] args) throws IOException {
        new Thread(null, new CountPair(), "Main", 1 << 26).start();
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
            System.out.println(countPair(ns, ms));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long countPair(int[]n, int[]m){
        int nL = n.length;
        int mL = m.length;
        long pairCounter = 0;
        int i = 0, j = 0;
        long iEq = 0, jEq = 0;
        while(i < nL && j < mL){
            if(n[i] == m[j]){
                iEq = 1; jEq = 1;
                i++;
                while(i < nL && n[i] == n[i-1]){
                    iEq++;
                    i++;
                }
                j++;
                while(j < mL && m[j] == m[j-1]){
                    jEq++;
                    j++;
                }
                pairCounter+=iEq*jEq;
            }else if(n[i] < m[j]){
                i++;
            }else {
                j++;
            }
        }
        return pairCounter;
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
