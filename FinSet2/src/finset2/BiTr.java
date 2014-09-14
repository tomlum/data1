
package finset2;


public interface BiTr {
    
    int node;
    public BiTr empty();
    public int cardinality();
    public boolean isEmptyHuh();
    public boolean member(int elt);
    public BiTr add(int elt);
    public BiTr remove(int elt);
    public BiTr union(BiTr u);
//    public BiTr inter(BiTr u);
//    public BiTr diff(BiTr u);
//    public boolean equal(BiTr u);
//    public BiTr subset(BiTr u);
//    
   
    
    
    
}
