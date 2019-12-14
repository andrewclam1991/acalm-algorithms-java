package dev.aclam.algo.w1;

/**
 * Implementation of {@link UF} that is slightly
 * quicker to merge two connected components
 */
public class QuickUnionUF extends UF {

    private int[] id;

    public QuickUnionUF(int size) {
        super(size);
        id = new int[size];
        for(int i = 0; i < size; i++){
            id[i] = i;
        }
    }

    /**
     * Attaches the p's root to the q's root, resulting in
     * p's root is now one level under the q's root.
     *
     * Changes root of p to point to root of q
     * (depth of p and q array accesses)
     * @param p an object
     * @param q another object
     */
    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return 0;
    }

    /**
     * Finds the root of an element by chasing parent pointer
     * (depth of i array accesses)
     * @param i element
     * @return the root of the connected element
     */
    private int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }
}
