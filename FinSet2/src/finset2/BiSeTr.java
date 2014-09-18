
package finset2;


public interface BiSeTr {
    
    
    
    public int cardinality();
    public boolean isEmptyHuh();
    public boolean member(int elt);
    public BiSeTr add(int elt);
    public BiSeTr remove(int elt);
    public BiSeTr union(BiSeTr u);
    public BiSeTr inter(BiSeTr u);
    public BiSeTr diff(BiSeTr u);
    public boolean equal(BiSeTr u);
    public boolean subset(BiSeTr u);
    
//    
   
    
    
    
}
