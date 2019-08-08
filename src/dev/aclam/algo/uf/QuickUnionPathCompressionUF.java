package dev.aclam.algo.uf;

/**
 * Implementation of {@link UF} that modifies {@link QuickUnionUF}
 * to include path compression
 */
public class QuickUnionPathCompressionUF extends UF {

    private int[] id;

    public QuickUnionPathCompressionUF(int size) {
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
     * (depth of i array accesses) with path compression
     *
     * @param i element
     * @return the root of the connected element
     */
    private int root(int i){
        while(i != id[i]){
            id[i] = id[id[i]]; // path compression, assign parent root to now point to grandparent
            i = id[i]; // here i retrieves the pointer to grandparent
        }
        return i;
    }
}
