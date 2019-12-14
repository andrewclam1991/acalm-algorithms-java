import edu.princeton.cs.algs4.StdIn;

public class Percolation {

    // tracks the sites' values, 0 means blocked, 1 means open
    int[][] sites;

    // tracks the number of open sites;
    int numberOfOpenSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        sites = new int[n][n];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        int site = sites[row][col];
        if (site == 0){
            sites[row][col] = 1;
            numberOfOpenSites++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        int site = sites[row][col];
        return site == 1;
    }

    // is the site (row, col) full?
    // in another word, is the site connected to top sites?
    public boolean isFull(int row, int col){
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return numberOfOpenSites;
    }

    // does the system percolate?
    // in another word, is any of the bottom site connected to any of the top sites?
    public boolean percolates(){
        return false;
    }

    // test client (optional)
    public static void main(String[] args){
        System.out.println("Please enter the size of the grid: ");
        int n = StdIn.readInt();
        Percolation percolation = new Percolation(n);

        while(!StdIn.isEmpty()){
            String command = StdIn.readString();
            int row, col;
            switch (command){
                case "isOpen":
                    row = StdIn.readInt();
                    col = StdIn.readInt();
                    System.out.println(percolation.isOpen(row, col));
                    break;
                case "isFull":
                    row = StdIn.readInt();
                    col = StdIn.readInt();
                    System.out.println(percolation.isFull(row, col));
                    break;
                case "numOpenSites":
                    System.out.println(percolation.numberOfOpenSites());
                    break;
                case "percolates":
                    System.out.println(percolation.percolates());
                    break;
                default:
                    System.out.println("ERROR, unrecognized command");
                    break;
            }
        }
    }
}