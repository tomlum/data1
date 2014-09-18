
package finset2;

public class Branch implements BiSeTr{
    
    int node;
    BiSeTr le;
    BiSeTr ri;
    
    
    
    public Branch(int node){
        this.node = node;
        this.le = new Leaf();
        this.ri = new Leaf();
    }
    
    public Branch(int node, BiSeTr le, BiSeTr ri){
        this.node = node;
        this.le = le;
        this.ri = ri;
    }
    
    
    public int cardinality(){
        return 1 + this.ri.cardinality() + this.le.cardinality();
    }
    
    public boolean isEmptyHuh(){
        return false;
    }
    
    public boolean member(int elt){
            if(elt<this.node){
                return this.le.member(elt);
            }
            if(elt>this.node){
                return this.ri.member(elt);
            }
            return true;
            
    }
    
    public BiSeTr add(int elt){
        if(elt < this.node){
             return new Branch(this.node,this.le.add(elt),this.ri);}
        if(elt > this.node){
            return new Branch(this.node,this.le,this.ri.add(elt));}
        return this;       
    }
    
    //still requires union
    public BiSeTr remove(int elt){
        if(this.node == elt){
            return this.le.union(this.ri);
            }
        return new Branch(this.node,this.le.remove(elt),this.ri.remove(elt));
        }
    
    
    public BiSeTr union(BiSeTr u){
        return this.ri.union(this.le.union(u)).add(node);
    }
    
    public BiSeTr inter(BiSeTr u){
        if(u.member(this.node)){
        return new Branch(this.node, this.le.inter(u), this.ri.inter(u));}
        else{
    return this.le.inter(u).union(this.ri.inter(u));}
    
    }
    
    public BiSeTr diff(BiSeTr u){
        if(!u.member(this.node)){
        return new Branch(this.node, this.le.diff(u), this.ri.diff(u));}
        else{
    return this.le.diff(u).union(this.ri.diff(u));}
    }
    
    public boolean equal(BiSeTr u){
         if(this.subset(u)&&u.subset(this)){
             return true;
         }
         return false;
    }
    
    
    public boolean subset(BiSeTr u){
         if(u.member(this.node)){
             return(this.le.subset(u)&&this.ri.subset(u));
         }
         else{return false;}
    }
}