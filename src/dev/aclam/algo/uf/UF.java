package dev.aclam.algo.uf;

/**
 * Base class for all {@link UF} implementations that uses
 * integer as objects
 */
public abstract class UF {
    private int mSize;

    /**
     * Initialize UF data structure with N objects indexed from (0 to N-1)
     * @param size
     */
    public UF(int size){
        mSize = size;
    }

    /**
     * Adds connection between object p and q
     * @param p an object
     * @param q another object
     */
    public abstract void union(int p, int q);

    /**
     * Checks if p and q are connected by being in the same component
     * @param p an object
     * @param q another object
     */
    public abstract void connected(int p, int q);

    /**
     * Finds the component identifier for P(0 to N-1)
     * @param p the object
     * @return the component identifier for P(0 to N-1)
     */
    public abstract int find(int p);

    /**
     * @return number of connected components
     */
    public abstract int count();
}
