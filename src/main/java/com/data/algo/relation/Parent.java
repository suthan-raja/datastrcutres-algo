package com.data.algo.relation;

class ParentC {
    ParentC() {
        System.out.println("Parent constructor");
    }
}

class ChildC extends Parent {
    ChildC() {
        System.out.println("Before super"); // ❌ compile error
//        super();  // must be first statementpublic class TestError {
//    public static void main(String[] args) {
//        try {
//            int[] arr = new int[Integer.MAX_VALUE]; // huge allocation
//        } catch (OutOfMemoryError e) {  // ✅ catches Error
//            System.out.println("Caught: " + e);
//        }
//    }
//}
        System.out.println("After super");
    }

    public static void main(String[] args) {
        ChildC c = new ChildC();
    }
}


