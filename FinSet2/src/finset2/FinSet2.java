
package finset2;
import java.util.Random;

public class FinSet2 {

    static Random rand = new Random();
    public static int randomInt( int min, int max ) {
        return rand.nextInt((max - min) + 1) + min; }
    
    public static BiTr randomTree( int min, int max, int len) {
        BiTr RandTree = new Leaf();
        for(int j = 0; j < len; j++){
            RandTree = RandTree.add(randomInt(min,max));
         }
        return RandTree;
        }


    
    //Tests that for any integer that is in set1 or set2 should be in the union
    //of the two sets
    public static void checkUnion(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiTr RandomTree1 = randomTree(0,range,15);
        BiTr RandomTree2 = randomTree(0,range,15);
        
        BiTr UnionTree = RandomTree1.union(RandomTree2);
        
        for(int j = 0; j < range; j++){
        if(UnionTree.member(j) != (RandomTree1.member(j)||RandomTree2.member(j))){
            System.out.println("Back to the Drawing Board Tom");
        }
        }
        }
    }
    
    public static void checkInter(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiTr RandomTree1 = randomTree(0,range,40);
        BiTr RandomTree2 = randomTree(0,range,40);
        
        
        BiTr InterTree = RandomTree1.inter(RandomTree2);
        
        for(int j = 0; j < range; j++){
        if((RandomTree1.member(j) == RandomTree2.member(j)) != InterTree.member(j)){
            System.out.println("Back to the Drawing Board Tom");
        }
        }
        
        }
    }
    
    
    public static void checkDiff(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiTr RandomTree1 = randomTree(0,range,40);
        BiTr RandomTree2 = randomTree(0,range,40);
        
        BiTr InterTree = RandomTree1.inter(RandomTree2);
        BiTr DiffTree = RandomTree1.diff(RandomTree2);
        
        for(int j = 0; j < range; j++){
        if((RandomTree1.member(j) == !RandomTree2.member(j)) && InterTree.member(j)){
            System.out.println("Back to the Drawing Board Tom");
        }
        }
        
        }
    }
    
     public static void checkSubset(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiTr RandomTree1 = randomTree(0,range,50);
        BiTr RandomTree2 = randomTree(0,range,50);
        
        BiTr InterTree = RandomTree1.inter(RandomTree2);
        boolean deFactoSubsetOfTrees = RandomTree1.subset(RandomTree2);
        boolean deJureSubsetOfTrees = true;
        for(int j = 0; j < range; j++){
            if(RandomTree1.member(j) != InterTree.member(j)){
                deJureSubsetOfTrees = false;
            }
        }
        
        if(!deJureSubsetOfTrees){
            System.out.println("was not a subset");
        }
        
        System.out.println(InterTree.cardinality()+" "+deJureSubsetOfTrees + " " + deFactoSubsetOfTrees);
        
        if(deJureSubsetOfTrees != deFactoSubsetOfTrees){
            System.out.println("Back to the Drawing Board Tom");
        }
        
        }
    }
    
    
  
    public static void main(String[] args) {
        //Get it?  Because arbor... arbitrary... tree...
        BiTr Arbortrary1 = new Branch(3,
                (new Branch(1)), 
                (new Branch(5,
                        (new Branch(4)),
                        (new Branch(7)))));
        BiTr Arbortrary1v3 = new Branch(3,
                (new Branch(100)), 
                (new Branch(5,
                        (new Branch(400)),
                        (new Branch(7)))));
        BiTr Arbortrary1v2 = new Branch(3,
                (new Branch(1)), 
                (new Branch(5,
                        (new Branch(4)),
                        (new Branch(7,new Branch(6), new Leaf())))));
        BiTr EmpTree = new Leaf();
        
        //Test Cardinality
        System.out.println("    Cardinality Test");
        System.out.println(Arbortrary1.cardinality() + " should be " + 5);
        System.out.println(EmpTree.cardinality() + " should be " + 0);
        //Test isEmptyHuh
        System.out.println("    isEmptyHuh Test");
        System.out.println(Arbortrary1.isEmptyHuh() + " should be " + false);
        System.out.println(EmpTree.isEmptyHuh() + " should be " + true);
        //Test member
        System.out.println("    Member Test");
        System.out.println(Arbortrary1.member(4) + " should be " + true);
        System.out.println(Arbortrary1.member(7) + " should be " + true);
        System.out.println(EmpTree.member(4) + " should be " + false);
        System.out.println(Arbortrary1.member(17) + " should be " + false);
        //Test add
        System.out.println("    add Test");
        System.out.println(Arbortrary1.add(6).cardinality() + " should be " + Arbortrary1v2.cardinality());
        System.out.println(Arbortrary1.add(6).member(6) + " should be " + Arbortrary1v2.member(6));
        System.out.println(Arbortrary1.add(12).cardinality() + " should be " + (Arbortrary1.cardinality()+1));
        System.out.println(Arbortrary1.add(3).cardinality() + " should be " + Arbortrary1.cardinality());
        
        
        
        //Test remove
        System.out.println("    remove Test");
        System.out.println(Arbortrary1.remove(7).member(7) + " should be " + !Arbortrary1.member(7));
        //checks that remove doesn't affect Arbortrary1
        System.out.println(Arbortrary1.member(7) + " should be " + true);
         //Test union
        System.out.println("     union Test");
        System.out.println(Arbortrary1.union(Arbortrary1v2).cardinality() + " should be " + 6);
        //checks that remove doesn't affect Arbortrary1

        //Test Inter
        System.out.println("    inter Test");
        System.out.println(Arbortrary1.inter(Arbortrary1v2).cardinality() + " should be " + Arbortrary1.cardinality());
        System.out.println(Arbortrary1.inter(Arbortrary1v3).member(3) + " should be " + true);
        System.out.println(Arbortrary1.inter(Arbortrary1v3).member(5) + " should be " + true);
        System.out.println(Arbortrary1.inter(Arbortrary1v3).member(7) + " should be " + true);
        System.out.println(Arbortrary1.inter(Arbortrary1v3).member(100) + " should be " + false);
        System.out.println(Arbortrary1.inter(Arbortrary1v3).member(4) + " should be " + false);
        //Test Subset
        System.out.println("    subset Test");
        System.out.println(EmpTree.subset(Arbortrary1v2) + " should be " + true);
        System.out.println(Arbortrary1.subset(Arbortrary1v2) + " should be " + true);
        System.out.println(Arbortrary1v2.subset(Arbortrary1) + " should be " + false);
       
        checkUnion(10,10);
        checkInter(10,100);
        //checkDiff(10,100);
        //checkSubset(10,100);
       
        
    }
    
}
