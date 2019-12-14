import edu.princeton.cs.algs4.StdIn;

public class PercolationStats {

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){

    }

    // sample mean of percolation threshold
    public double mean() {
        return 0;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return 0;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 0;
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int T = StdIn.readInt();
        PercolationStats stats = new PercolationStats(n, T);
        System.out.println(String.format("mean   =  %s", stats.mean()));
        System.out.println(String.format("stddev =  %s", stats.stddev()));
        System.out.println(String.format("95%% ci =  [%s,%s]", stats.confidenceLo(), stats.confidenceHi()));
    }

}
