import java.util.HashSet;
import java.util.Set;

public class SetMath {
    public static void main(String[] args) {
        // --- Set Creation & Basics ---

        // 1. Set එකක් හදාගන්න හැටි (Creating Sets)
        // HashSet is a common implementation of the Set interface
        Set<Integer> mathSetA = new HashSet<>();
        mathSetA.add(1);
        mathSetA.add(2);
        mathSetA.add(3);
        mathSetA.add(4);
        mathSetA.add(5);

        Set<Integer> mathSetB = new HashSet<>();
        mathSetB.add(4);
        mathSetB.add(5);
        mathSetB.add(6);
        mathSetB.add(7);
        mathSetB.add(8);

        Set<String> myStringSet = new HashSet<>();
        myStringSet.add("apple");
        myStringSet.add("banana");
        myStringSet.add("orange");

        System.out.println("Set A: " + mathSetA);
        System.out.println("Set B: " + mathSetB);
        System.out.println("String Set: " + myStringSet);

        // 2. Duplicate values add කරන්න උත්සාහ කිරීම (Attempting to add duplicates)
        // Sets වලට unique values විතරයි ගන්න පුළුවන්. Duplicate දාන්න හැදුවොත් ignore
        // වෙනවා.
        Set<Integer> setWithDuplicates = new HashSet<>();
        setWithDuplicates.add(1);
        setWithDuplicates.add(2);
        setWithDuplicates.add(2); // This will be ignored
        setWithDuplicates.add(3);
        setWithDuplicates.add(1); // This will be ignored
        System.out.println("Set after trying to add duplicates: " + setWithDuplicates); // Output: [1, 2, 3] (order may
                                                                                        // vary)

        // 3. Set එකක Size එක හොයන හැටි (Getting Set Size)
        System.out.println("Size of Set A: " + mathSetA.size()); // .size() method for size

        // --- Set Operations Implementation ---
        System.out.println("\n--- Set Operations ---");

        // Important: For operations like union/intersection/difference, you often
        // create a new Set
        // or modify one of the existing sets. We'll create new ones to keep originals
        // intact.

        // 1. Union (සංගමය - A හෝ B වල තියෙන හැම element එකක්ම)
        Set<Integer> unionResult = new HashSet<>(mathSetA); // Start with all elements from A
        unionResult.addAll(mathSetB); // Add all elements from B
        System.out.println("Union (A U B): " + unionResult); // Expected: [1, 2, 3, 4, 5, 6, 7, 8] (order may vary)

        // 2. Intersection (ඡේදනය - A සහ B දෙකේම තියෙන Common Elements)
        Set<Integer> intersectionResult = new HashSet<>(mathSetA); // Start with all elements from A
        intersectionResult.retainAll(mathSetB); // Retain only elements also in B
        System.out.println("Intersection (A ∩ B): " + intersectionResult); // Expected: [4, 5] (order may vary)

        // 3. Difference (අන්තරය - A වල විතරක් තියෙන Elements)
        Set<Integer> differenceAMinusB = new HashSet<>(mathSetA); // Start with all elements from A
        differenceAMinusB.removeAll(mathSetB); // Remove all elements that are also in B
        System.out.println("Difference (A - B): " + differenceAMinusB); // Expected: [1, 2, 3] (order may vary)

        Set<Integer> differenceBMinusA = new HashSet<>(mathSetB);
        differenceBMinusA.removeAll(mathSetA);
        System.out.println("Difference (B - A): " + differenceBMinusA); // Expected: [6, 7, 8] (order may vary)

        // --- Membership Test ---
        System.out.println("\n--- Membership Test ---");
        // Element එකක් Set එකක තියෙනවද කියලා Check කරන හැටි (x ∈ A)
        boolean is3InA = mathSetA.contains(3);
        boolean is9InA = mathSetA.contains(9);

        System.out.println("Is 3 in Set A? " + is3InA); // Expected: true
        System.out.println("Is 9 in Set A? " + is9InA); // Expected: false

        // --- Challenge: Implement Union Manually (Optional) ---
        System.out.println("\n--- Manual Union (Challenge) ---");
        Set<Integer> manualUnionResult = manualUnion(mathSetA, mathSetB);
        System.out.println("Manual Union Result: " + manualUnionResult);
    }

    // Manual Union method
    public static <T> Set<T> manualUnion(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>();
        for (T item : set1) {
            result.add(item);
        }
        for (T item : set2) {
            result.add(item); // HashSet handles duplicates automatically
        }
        return result;
    }
}

// Symmetric Difference

class SymmetricDifferenceExample {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);

        Set<Integer> setB = new HashSet<>();
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);

        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);

        // 1. Union (A U B) සොයා ගැනීම
        Set<Integer> unionSet = new HashSet<>(setA);
        unionSet.addAll(setB);
        System.out.println("Union (A U B): " + unionSet); // Expected: [1, 2, 3, 4, 5, 6]

        // 2. Intersection (A ∩ B) සොයා ගැනීම
        Set<Integer> intersectionSet = new HashSet<>(setA);
        intersectionSet.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersectionSet); // Expected: [3, 4]

        // 3. Symmetric Difference = Union - Intersection
        Set<Integer> symmetricDifference = new HashSet<>(unionSet);
        symmetricDifference.removeAll(intersectionSet);
        System.out.println("Symmetric Difference (A Δ B): " + symmetricDifference); // Expected: [1, 2, 5, 6]
    }
}

//

class SymmetricDifferenceExampleShorten {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);

        Set<Integer> setB = new HashSet<>();
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);

        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);

        Set<Integer> symmetricDifference = new HashSet<Integer>() { // Anonymous inner class
            { // Instance initialization block (runs when the HashSet is created)
                addAll(setA); // Step 1: Add all elements from mathSetA
                addAll(setB); // Step 2: Add all elements from mathSetB (now contains union A ∪ B)
                removeIf(e -> setA.contains(e) && setB.contains(e)); // Step 3: Remove intersection (A ∩ B)
            }
        };
    }
}
