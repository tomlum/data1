
package finset2;
import java.util.Random;

public class FinSet2 {

    static Random rand = new Random();
    public static int randomInt( int min, int max ) {
        return rand.nextInt((max - min) + 1) + min; }


    
    //Tests that for any integer that is in set1 or set2 should be in the union
    //of the two sets
    public static void checkUnion(int reps){
        for(int i = 0; i < reps; i++){
            
        BiTr RandomTree1 = new Leaf();
        BiTr RandomTree2 = new Leaf();
        
        for(int j = 0; j < 40; j++){
            RandomTree1.add(randomInt(0,100));
         }
        
        for(int j = 0; j < 40; j++){
            RandomTree2.add(randomInt(0,100));
         }
        
        BiTr UnionTree = RandomTree1.union(RandomTree2);
        
        for(int j = 0; j < 100; j++){
        if((RandomTree1.member(j)!= UnionTree.member(i))||(RandomTree2.member(i)!= UnionTree.member(i))){
            System.out.println("Back to the Drawing Board Tom");
        }
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
        BiTr Arbortrary1v2 = new Branch(3,
                (new Branch(1,new Leaf(),new Leaf())), 
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
        
        checkUnion(10);
    }
    
}
