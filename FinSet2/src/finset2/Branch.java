

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
        if(this.node == elt){
            return this.le.union(this.ri);
            }
        return new Branch(this.node,this.le.remove(elt),this.ri.remove(elt));
        }
    
    
    public BiTr union(BiTr u){
        return this.le.union(this.ri.union(u)).add(node);
    }
    
    public BiTr inter(BiTr u){
        if(u.member(this.node)){
        return new Branch(this.node, this.le.inter(u), this.ri.inter(u));}
        else{
    return this.le.inter(u).union(this.ri.inter(u));}
    
    }
    
    public BiTr diff(BiTr u){
        if(!u.member(this.node)){
        return new Branch(this.node, this.le.diff(u), this.ri.diff(u));}
        else{
    return this.le.diff(u).union(this.ri.diff(u));}
    }
    
    public boolean equal(BiTr u){
         if(this.subset(u)&&u.subset(this)){
             return true;
         }
         return false;
    }
    
    
    public boolean subset(BiTr u){
         if(u.member(this.node)){
             return(this.le.subset(u)&&this.ri.subset(u));
         }
         else{return false;}
    }
}
