package dev.aclam.algo.w1;

/**
 * Implementation of {@link UF} that is quick to
 * find root component
 */
public class QuickFindUF extends UF {

    /**
     * Array to store the root component
     */
    private int[] mIds;

    /**
     * Performance: N array accesses, O(n)
     * @param size
     */
    public QuickFindUF(int size) {
        super(size);
        mIds = new int[size];
        for (int i = 0; i < size; i++){
            mIds[i] = i;
        }
    }

    /**
     * Implementation note:
     * Performance: 2N + 2 array accesses O(2n+2)
     * @param p an object
     * @param q another object
     * @return
     */
    @Override
    public void union(int p, int q) {
        int pId = mIds[p];
        int qId = mIds[q];
        for(int i = 0; i < mSize; i++){
            if (mIds[i] == pId){
                mIds[i] = qId;
            }
        }
    }

    /**
     * Implementation note:
     * Performance: constant 2 array accesses, O(2)
     * @param p an object
     * @param q another object
     * @return
     */
    @Override
    public boolean connected(int p, int q) {
        return mIds[p] == mIds[q];
    }

    @Override
    public int find(int p) {
        return mIds[p];
    }

    @Override
    public int count() {
        return 0;
    }
}
