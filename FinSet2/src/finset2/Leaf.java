
package finset2;

public class Leaf implements BiTr{
   
    
    
    public Leaf() {}
    
    public BiTr empty(){
         return this;
     };
    public int cardinality(){
        return 0;
    };
    
    public boolean isEmptyHuh(){
        return true;
    }
    
    public boolean member(int elt){
        return false;
    }
    
    public BiTr add(int elt){
        return new Branch(elt);
    }
    
    public BiTr remove(int elt){
        return new Leaf();
    }
    
    public BiTr union(BiTr u){
        return u;
    }
   
    
    
}
