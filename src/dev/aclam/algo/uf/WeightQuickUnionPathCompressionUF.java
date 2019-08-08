package dev.aclam.algo.uf;

public class WeightQuickUnionPathCompressionUF extends UF {

    /**
     * Array to store the root component of each element
     * each element is an index of this array
     */
    private int[] id;

    /**
     * Array to keep track of size of each component
     */
    private int[] size;

    public WeightQuickUnionPathCompressionUF(int num) {
        super(num);
        id = new int[num];
        size = new int[num];

        for (int i = 0; i < num; i++){
            id[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Weighted method
     * Only attaches a smaller tree to larger tree, this minimizes
     * root() operation.
     *
     * @param p an object
     * @param q another object
     */
    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        // When they have the same root, no need to union
        if (pRoot == qRoot) return;

        if (size[p] > size[q]){
            // if size of p is larger
            // attach the smaller q's root to p, this grows the p tree's leaves
            id[q] = pRoot;
            size[p] += size[q];
        } else {
            // else q is larger
            // attach the smaller p's root to q, this grows the q tree's leaves
            id[p] = qRoot;
            size[q] += size[p];
        }
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
            i = id[i]; // here i will then point to the grandparent
        }
        return i;
    }
}
