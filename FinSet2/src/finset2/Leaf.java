
package finset2;

public class Leaf implements BiSeTr{
   
   
    public Leaf() {}
    
    
    public int cardinality(){
        return 0;
    };
    
    public boolean isEmptyHuh(){
        return true;
    }
    
    public boolean member(int elt){
        return false;
    }
    
    public BiSeTr add(int elt){
        return new Branch(elt);
    }
    
    public BiSeTr remove(int elt){
        return this;
    }
    
    public BiSeTr union(BiSeTr u){
        return u;
    }
    
    public BiSeTr inter(BiSeTr u){
        return new Leaf();
    }
    
    public BiSeTr diff(BiSeTr u){
        return new Leaf();
    }
    
    public boolean equal(BiSeTr u){
        if(u.isEmptyHuh()){
            return true;
        }
        return false;
    }
   
    public boolean subset(BiSeTr u){
        return true;
    }
    
    
}
