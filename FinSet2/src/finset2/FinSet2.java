
package finset2;
import java.util.Random;

public class FinSet2 {
    
//  Is here where this belongs?
    public static BiSeTr empty(){
        return new Leaf();
    };

    static Random rand = new Random();
    public static int randomInt( int min, int max ) {
        return rand.nextInt((max - min) + 1) + min; }
    
    
    
    
  
    public static BiSeTr randomTree(int min, int max, int maxlen) {
        if(maxlen > 0){
            return randomTree(min,max,(maxlen-1)).add(randomInt(min,max));
        }
        else return new Leaf();
        }


    //Tests that for any integer that is in set1 or set2 should be in the union
    //of the two sets
    public static void checkUnion(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,15);
        BiSeTr RandomTree2 = randomTree(0,range,15);
        
        BiSeTr UnionTree = RandomTree1.union(RandomTree2);
        
        for(int j = 0; j <= range; j++){
        if(UnionTree.member(j) != (RandomTree1.member(j)||RandomTree2.member(j))){
            System.out.println("Back to the Drawing Board Tom, fix Union");
        }
        }
        }
    }
    
    public static void checkRandom(){
        for(int i = 0; i < 100; i++){
            
        BiSeTr RandomTree1 = randomTree(0,30,20);
        
        
        for(int j = 0; j <= 30; j++){
        if(RandomTree1.remove(j).member(j)){
            System.out.println("Back to the Drawing Board Tom, these aren't BSTs");
        }
        }
        }
    }
    
    
    
    //Checks that if A is a subset of B, B is a Subset of C
    //A is a subset of C
    public static void checkSubsetTransitivity(int reps){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,10,100);
        BiSeTr RandomTree2 = randomTree(0,20,100);
        BiSeTr RandomTree3 = randomTree(0,50,150);
        
        for(int j = 0; j <= 100; j++){
          
        if((RandomTree1.subset(RandomTree2) && RandomTree2.subset(RandomTree3))&&!(RandomTree1.subset(RandomTree3))){
            System.out.println("Back to the Drawing Board Tom");
        }
        }
        }
    }
    
   
    
    //If the Set is the same after removing and adding j
    //then j was a member of the original Set
    public static void checkProperty2(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,40);
        
        
        for(int j = 0; j <= range; j++){
        if(RandomTree1.equal(RandomTree1.remove(j).add(j)) != RandomTree1.member(j)){
            System.out.println("Back to the Drawing Board Tom, fix checkPropert2");
        }
        }
        
        }
    }
    
    //If a value is a member of the difference of the first and second Set
    //or the difference of the second and first Set, it should not be
    //a value of the intersection of the Sets
    public static void checkProperty3(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,40);
        BiSeTr RandomTree2 = randomTree(0,range,40);
        BiSeTr InterTree = RandomTree1.inter(RandomTree2);
        BiSeTr UnionTree = RandomTree1.union(RandomTree2);
        BiSeTr DiffTree = RandomTree1.diff(RandomTree2);
        BiSeTr DiffTree2 = RandomTree2.diff(RandomTree1);
        
        
        for(int j = 0; j <= range; j++){
        if((DiffTree.member(j)||DiffTree2.member(j))&&InterTree.member(j)){
            System.out.println("Back to the Drawing Board Tom, fix checkProperty3");
        }
        }
        
        }
    }
    
    //Union of the Intersection of Sets and the Difference of both 
    //should be equal to the Union of both Sets.
    //As well, all members of the the Union of the Intersection and Differences
    //should be a member of the Union of both Sets
    public static void checkProperty4(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,40);
        BiSeTr RandomTree2 = randomTree(0,range,40);
        BiSeTr InterTree = RandomTree1.inter(RandomTree2);
        BiSeTr UnionTree = RandomTree1.union(RandomTree2);
        BiSeTr DiffTree = RandomTree1.diff(RandomTree2);
        BiSeTr DiffTree2 = RandomTree2.diff(RandomTree1);
        
        
        for(int j = 0; j <= range; j++){
        if(!DiffTree.union(DiffTree2).union(InterTree).equal(UnionTree)){
            System.out.println("Back to the Drawing Board Tom, fix checkProperty4");
        }
        if(!DiffTree.union(DiffTree2).union(InterTree).member(j) == UnionTree.member(j)){
            System.out.println("Back to the Drawing Board Tom, fix checkProperty4");
        }
        }
        
        }
    }
    
    
    //If x is a member of the Union of the intersecions of three random Sets,
    //it must be a member of at least two of the Sets
    public static void checkProperty5(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,40);
        BiSeTr RandomTree2 = randomTree(0,range,40);
        BiSeTr RandomTree3 = randomTree(0,range,40);
        BiSeTr InterTree12 = RandomTree1.inter(RandomTree2);
        BiSeTr InterTree23 = RandomTree2.inter(RandomTree3);
        BiSeTr InterTree13 = RandomTree1.inter(RandomTree3);
        BiSeTr InterUnionTree123 = InterTree12.union(InterTree13.union(InterTree23));
        BiSeTr InterTree123 = InterTree12.inter(InterTree13.inter(InterTree23));
        
        
        for(int j = 0; j <= range; j++){
        if(InterUnionTree123.member(j) && !(
                (RandomTree1.member(j)&&RandomTree2.member(j))||
                (RandomTree1.member(j)&&RandomTree3.member(j))||
                (RandomTree2.member(j)&&RandomTree3.member(j))
                )){
            System.out.println("Back to the Drawing Board Tom, fix checkProperty3");
        }
        }
        
        
        }
    }
    
      //If x is a member of the intersection of all three sets, then it
      //must also be in any intersection of any two intersecions of Sets
      public static void checkProperty6(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,40);
        BiSeTr RandomTree2 = randomTree(0,range,40);
        BiSeTr RandomTree3 = randomTree(0,range,40);
        BiSeTr InterTree12 = RandomTree1.inter(RandomTree2);
        BiSeTr InterTree23 = RandomTree2.inter(RandomTree3);
        BiSeTr InterTree13 = RandomTree1.inter(RandomTree3);
        BiSeTr InterUnionTree123 = InterTree12.union(InterTree13.union(InterTree23));
        BiSeTr InterTree123 = InterTree12.inter(InterTree13.inter(InterTree23));
        
        
        for(int j = 0; j <= range; j++){
        if(InterTree123.member(j) && !(
                InterTree12.inter(InterTree13).member(j)
                && InterTree12.inter(InterTree23).member(j)
                && InterTree13.inter(InterTree23).member(j)
                
                )){
            System.out.println("Back to the Drawing Board Tom, fix checkProperty3");
        }
        }
        
        
        }
    }
    
    public static void checkInter(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,40);
        BiSeTr RandomTree2 = randomTree(0,range,40);
        
        
        BiSeTr InterTree = RandomTree1.inter(RandomTree2);
        
        for(int j = 0; j <= range; j++){
        if((RandomTree1.member(j) && RandomTree2.member(j)) != InterTree.member(j)){
            System.out.println("Back to the Drawing Board Tom, fix Inter");
        }
        }
        
        }
    }
    
    public static void checkDiff(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,40);
        BiSeTr RandomTree2 = randomTree(0,range,40);
        
        BiSeTr DiffTree = RandomTree1.diff(RandomTree2);
        
        
        for(int j = 0; j <= range; j++){
        if(RandomTree1.member(j) && RandomTree2.member(j) && DiffTree.member(j)){
            System.out.println("Back to the Drawing Board Tom, fix Diff");
        }
        }
        
        }
    }
    
     public static void checkSubset(int reps, int range){
        for(int i = 0; i < reps; i++){
            
        BiSeTr RandomTree1 = randomTree(0,range,5);
        BiSeTr RandomTree2 = randomTree(0,range,100);
        
        BiSeTr InterTree = RandomTree1.inter(RandomTree2);
        boolean deFactoSubsetOfTrees = RandomTree1.subset(RandomTree2);
        boolean deJureSubsetOfTrees = true;
        for(int j = 0; j <= range; j++){
            if(RandomTree1.member(j) != InterTree.member(j)){
                deJureSubsetOfTrees = false;
            }
        }
        
        
        ////uncomment for to show that the function is creating SubSets
        //System.out.println(InterTree.cardinality()+" "+RandomTree1.cardinality()+" "+deJureSubsetOfTrees + " " + deFactoSubsetOfTrees);
        
        if(deJureSubsetOfTrees != deFactoSubsetOfTrees){
            System.out.println("Back to the Drawing Board Tom, fix Subset");
            System.out.println(RandomTree1.cardinality()+" "+InterTree.cardinality()+deJureSubsetOfTrees+deFactoSubsetOfTrees);
            
            
        }
        
        }
    }
    
    
  
    public static void main(String[] args) {
        //Get it?  Because arbor... arbitrary... tree...
        BiSeTr Arbortrary1 = new Branch(3,
                (new Branch(1)), 
                (new Branch(5,
                        (new Branch(4)),
                        (new Branch(7)))));
        BiSeTr Arbortrary1v3 = new Branch(3,
                (new Branch(100)), 
                (new Branch(5,
                        (new Branch(400)),
                        (new Branch(7)))));
        BiSeTr Arbortrary1v2 = new Branch(3,
                (new Branch(1)), 
                (new Branch(5,
                        (new Branch(4)),
                        (new Branch(7,new Branch(6), new Leaf())))));
        BiSeTr EmpTree = new Leaf();
        
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
        //Test Equal
        System.out.println("    equal Test");
        System.out.println(EmpTree.equal(EmpTree) + " should be " + true);
        System.out.println(EmpTree.equal(Arbortrary1v2) + " should be " + false);
        System.out.println(Arbortrary1.add(6).equal(Arbortrary1v2) + " should be " + true);
        System.out.println(Arbortrary1v2.equal(Arbortrary1) + " should be " + false);
        //Test Subset
        System.out.println("    subset Test");
        System.out.println(EmpTree.subset(EmpTree) + " should be " + true);
        System.out.println(EmpTree.subset(Arbortrary1v2) + " should be " + true);
        System.out.println(Arbortrary1.subset(Arbortrary1v2) + " should be " + true);
        System.out.println(Arbortrary1v2.subset(Arbortrary1) + " should be " + false);
       
        checkUnion(100,10);
        checkInter(100,100);
        checkDiff(100,100);
        checkSubset(100,30);
        checkSubsetTransitivity(100);
        checkProperty2(10,100);
        checkProperty3(10,100);
        checkProperty4(10,100);
        checkProperty5(10,100);
        checkProperty6(10,100);
        checkRandom();
        
    }
    
}