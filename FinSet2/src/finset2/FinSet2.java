/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finset2;

public class FinSet2 {

    
    public static void testUnion(BiTr u1, BiTr u2){
        //for two random sets, run through member from 1 to 100,
        //u1 and union should all be true
        //u2 and union should all be true
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
        System.out.println(Arbortrary1.add(6).cardinality() + " should be " + Arbortrary1v2.cardinality());
        
    }
    
}
