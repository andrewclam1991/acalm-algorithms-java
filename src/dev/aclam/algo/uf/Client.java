package dev.aclam.algo.uf;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Test client for {@link UF} implementations
 */
public class Client {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new QuickFindUF(N);
        while(! StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p,q)){
                uf.union(p,q);
                StdOut.println(String.format("%s %s", p, q));
            }
        }
    }
}