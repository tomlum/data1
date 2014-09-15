
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
    
    public BiTr inter(BiTr u){
        return new Leaf();
    }
    
    public BiTr diff(BiTr u){
        return new Leaf();
    }
    
    public boolean equal(BiTr u){
        if(u.isEmptyHuh()){
            return true;
        }
        return false;
    }
   
    public boolean subset(BiTr u){
        return true;
    }
    
    
}
