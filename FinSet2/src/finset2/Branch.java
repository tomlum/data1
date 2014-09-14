

package finset2;

public class Branch implements BiTr{
    
    int node;
    BiTr le;
    BiTr ri;
    
    
    
    public Branch(int node){
        this.node = node;
        this.le = new Leaf();
        this.ri = new Leaf();
    }
    
    public Branch(int node, BiTr le, BiTr ri){
        this.node = node;
        this.le = le;
        this.ri = ri;
    }
    
    public BiTr empty(){
         return new Leaf();
     }
    public int cardinality(){
        return 1 + this.ri.cardinality() + this.le.cardinality();
    }
    
    public boolean isEmptyHuh(){
        return false;
    }
    
    public boolean member(int elt){
            if(this.node == elt){
                return true;}
            if(!this.le.member(elt)&&!this.ri.member(elt)){
                    return false;}
            return true;
    }
    
    public BiTr add(int elt){
        Branch newTree = new Branch(this.node,this.le,this.ri);
        if(elt < newTree.node){
            newTree.le = newTree.le.add(elt);} 
        if(elt > newTree.node){
            newTree.ri = newTree.ri.add(elt);}
        return newTree;       
    }
    
    //still requires union
    public BiTr remove(int elt){
        Branch newTree = new Branch(this.node,this.le,this.ri);
        if(newTree.node == elt){
            return (newTree.le.union(newTree.ri));
            }
        else{if(this.le.member(elt)){
                this.le = this.le.remove(elt);}
            else{if(this.ri.member(elt)){
                this.ri = this.le.remove(elt);}
                }
            }    
        return newTree;
        }
    
    
    
    public BiTr union(BiTr u){
        Branch newTree = new Branch(this.node,this.le,this.ri);
        return newTree;
    }
    
}
