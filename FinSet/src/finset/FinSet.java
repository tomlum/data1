
package finset;
import java.util.Arrays;

public class FinSet {

    int[] set;
    
    public FinSet(){
        set = new int[] {};
    }
    
    public FinSet(int[] t){
        set = t;
    }
    
    public FinSet empty(){
        return new FinSet();
    }
    
    
    public int cardinality(){
        return this.set.length;
    }
    
    
    public boolean isEmptyHuh(){
        if(this.cardinality() == 0) {return true;}
        return false;
    }
    
    public boolean member(int elt){
        for(int j = 0; j < this.cardinality(); j++){
        if(this.set[j]==elt){
            return true;
        }
               
    }
        return false;
    }
    
    public FinSet add(int elt){
        int[] newSet = new int[this.cardinality()+1];
              newSet[this.cardinality()] = elt;  
        for(int i = 0;i<this.cardinality();i++){
            newSet[i] = this.set[i];
        }
        
        return new FinSet(newSet);
    }
    
    //working! forgot that add returns a new FinSet! duh!
    public FinSet remove(int elt){
        
        if (this.member(elt)){
            FinSet newSet = new FinSet();
            for(int i = 0;i<this.cardinality();i++){
             if(this.set[i] != elt){
             newSet = newSet.add(this.set[i]);
             }
             
            }
            return newSet;
    
        }
      
        else{return this;}
    }
    
    //I hope this isn't too contrived
        
    public FinSet union(FinSet u){
        FinSet newSet = new FinSet();
        //note to self, have case for if numbers are equal
        for(int i = 0; i < this.cardinality(); i++){
            while(! u.isEmptyHuh())
                {
                //if u[0] is smaller, add it and remove it
                if(u.set[0] < this.set[i]){
                    newSet = newSet.add(u.set[0]);
                    u = u.remove(u.set[0]);
                }
                //otherwise break
                else{break;}
            }
            //if the two numbers are equal, remove it from this and decrement
            //to balance out the next increment
            if(!u.isEmptyHuh() && u.set[0] == this.set[i]){
                this.set = this.remove(this.set[i]).set;
                i--;
            }
            //else add the item of this set 
            else{newSet = newSet.add(this.set[i]);}
        }
       //adds the rest of u, which should be greater than anything in this
       for(int i = 0; i < u.cardinality(); i++){
            newSet = newSet.add(u.set[i]);
        }
        return newSet;
    }
        
    
    
    //dummy method
    public FinSet inter(FinSet u){
        return this;
    }
    
    //dummy method
    public FinSet diff(FinSet u){
        return this;
    }
    
    //dummy method
    public boolean equal(FinSet u){
        return true;
    }
    
    //dummy method
    public boolean subset(FinSet u){
        return true;
    }
    
    
  
    public static void main(String[] args) {
    //Arbitrary Sets for empty check
        FinSet emptyFinSet = new FinSet(new int[] {});
        FinSet arbitrarySet1 = new FinSet(new int[] {3,24,1,15,66});
    //Arbitrary Sets for cardinality check
        FinSet arbitrarySet2 = new FinSet(new int[] {55,2,18,35,89});
        FinSet arbitrarySet3 = new FinSet(new int[] {0,1});
        FinSet arbitrarySet4 = new FinSet(new int[] {1});
    //Arbitrary Sets for isEmptyHuh check
        FinSet arbitrarySet8 = new FinSet(new int[] {});
        FinSet arbitrarySet9 = new FinSet(new int[] {1,2,3,4,5});
    //Arbitrary Sets for member check
        FinSet arbitrarySet10 = new FinSet(new int[] {11,22,33});
        FinSet arbitrarySet11 = new FinSet(new int[] {74,8,2});
    //Arbitrary Sets for add check
        FinSet arbitrarySet6 = new FinSet(new int[] {1,2,3,4});
    //Arbitrary Sets for remove check
        FinSet arbitrarySet12 = new FinSet(new int[] {11,22,33});
        FinSet arbitrarySet13 = new FinSet(new int[] {74});
        FinSet arbitrarySet14 = new FinSet(new int[] {2,74});
    //Arbitrary Sets for union, inter, diff, equal, and subset check
        FinSet arbitrarySet16 = new FinSet(new int[] {11,22,33});
        FinSet arbitrarySet18 = new FinSet(new int[] {2,74});
        FinSet arbitrarySet19 = new FinSet(new int[] {1,3,5,7,9});
        FinSet arbitrarySet20 = new FinSet(new int[] {1,3,5,7,9,11});
        FinSet arbitrarySet21 = new FinSet(new int[] {1,3,5,7,9,11});

        
        
//check empty
    System.out.println("Check empty");
    System.out.println("  "+(arbitrarySet1.empty().cardinality()== emptyFinSet.set.length) + " should be " + true);
//check cardinality
    System.out.println("Check cardinality");
    System.out.println("  "+arbitrarySet2.cardinality() + " should be " + 5);
    System.out.println("  "+arbitrarySet3.cardinality() + " should be " + 2);
    System.out.println("  "+arbitrarySet4.cardinality() + " should be " + 1);
    System.out.println("  "+emptyFinSet.cardinality() + " should be " + 0);
//check emptyHuh
    System.out.println("Check emptyHuh");
    System.out.println("  "+arbitrarySet8.isEmptyHuh() + " should be " + true);
    System.out.println("  "+arbitrarySet9.isEmptyHuh() + " should be " + false);
//check member
    System.out.println("Check member");
    System.out.println("  "+arbitrarySet10.member(11) + " should be " + true);
    System.out.println("  "+arbitrarySet11.member(11) + " should be " + false);
//check add
    System.out.println("Check add");
    System.out.println("  "+Arrays.toString(arbitrarySet6.add(5).set) + " should be " + Arrays.toString(new int[] {1,2,3,4,5}));
    System.out.println("  "+Arrays.toString(emptyFinSet.add(16).set) + " should be " + Arrays.toString(new int[]{16}));
//check remove
    System.out.println("Check remove");
    System.out.println("  "+Arrays.toString(arbitrarySet12.remove(33).set) + " should be " + Arrays.toString(new int[]{11,22}));
    System.out.println("  "+Arrays.toString(arbitrarySet13.remove(74).set) + " should be " + Arrays.toString(new int[]{}));
    System.out.println("  "+Arrays.toString(arbitrarySet14.remove(90000).set) + " should be " + Arrays.toString(new int[]{2,74}));
//check union
    System.out.println("Check union");
    System.out.println("  "+Arrays.toString(arbitrarySet16.union(arbitrarySet18).set) + " should be " + Arrays.toString(new int[]{2,11,22,33,74}));
    System.out.println("  "+Arrays.toString(arbitrarySet16.union(emptyFinSet).set) + " should be " + Arrays.toString(new int[]{11,22,33}));
    System.out.println("  "+Arrays.toString(arbitrarySet19.union(arbitrarySet20).set) + " should be " + Arrays.toString(new int[]{1,3,5,7,9,11}));
    System.out.println("  "+Arrays.toString(arbitrarySet20.union(arbitrarySet19).set) + " should be " + Arrays.toString(new int[]{1,3,5,7,9,11}));
//check inter
    System.out.println("Check inter");
    System.out.println("  "+Arrays.toString(arbitrarySet16.inter(arbitrarySet18).set) + " should be " + Arrays.toString(new int[]{}));
    System.out.println("  "+Arrays.toString(arbitrarySet16.inter(emptyFinSet).set) + " should be " + Arrays.toString(new int[]{}));
    System.out.println("  "+Arrays.toString(emptyFinSet.inter(arbitrarySet16).set) + " should be " + Arrays.toString(new int[]{}));
    System.out.println("  "+Arrays.toString(arbitrarySet19.inter(arbitrarySet20).set) + " should be " + Arrays.toString(new int[]{1,3,5,7,9}));
    System.out.println("  "+Arrays.toString(arbitrarySet20.inter(arbitrarySet19).set) + " should be " + Arrays.toString(new int[]{1,3,5,7,9}));
 //check diff
    System.out.println("Check diff");
    System.out.println("  "+Arrays.toString(arbitrarySet16.diff(arbitrarySet18).set) + " should be " + Arrays.toString(new int[]{11,22,33}));
    System.out.println("  "+Arrays.toString(arbitrarySet16.diff(emptyFinSet).set) + " should be " + Arrays.toString(new int[]{11,22,33}));
    System.out.println("  "+Arrays.toString(emptyFinSet.diff(arbitrarySet16).set) + " should be " + Arrays.toString(new int[]{}));
    System.out.println("  "+Arrays.toString(arbitrarySet19.diff(arbitrarySet20).set) + " should be " + Arrays.toString(new int[]{}));
    System.out.println("  "+Arrays.toString(arbitrarySet20.diff(arbitrarySet19).set) + " should be " + Arrays.toString(new int[]{11}));
  //check equal
    System.out.println("Check equal");
    System.out.println("  "+arbitrarySet16.equal(arbitrarySet18) + " should be " + false);
    System.out.println("  "+arbitrarySet16.equal(emptyFinSet) + " should be " + false);
    System.out.println("  "+emptyFinSet.equal(arbitrarySet16) + " should be " + false);
    System.out.println("  "+emptyFinSet.equal(emptyFinSet) + " should be " + true);
    System.out.println("  "+arbitrarySet20.equal(arbitrarySet21) + " should be " + true);
 //check subset
    System.out.println("Check subset");
    System.out.println("  "+arbitrarySet16.subset(arbitrarySet18) + " should be " + false);
    System.out.println("  "+arbitrarySet16.subset(emptyFinSet) + " should be " + false);
    System.out.println("  "+emptyFinSet.subset(arbitrarySet16) + " should be " + true);
    System.out.println("  "+emptyFinSet.subset(emptyFinSet) + " should be " + true);
    System.out.println("  "+arbitrarySet19.subset(arbitrarySet20) + " should be " + true);
 
    
    }
     
}
