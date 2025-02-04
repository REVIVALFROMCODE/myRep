/*
RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). 
Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
*/

/*
Because O(1) time complexity is required, we sacrifice space for time
ALGORITHM
Insert:

Check if the value is already in the set using a HashMap (Value:Location). If present, return false.

Otherwise, add the value to an ArrayList and store its index in the HashMap.

Return true to indicate the value was successfully inserted.

Remove:

Check if the value is in the set using the HashMap. If not present, return false.

To remove the value, swap it with the last element in the ArrayList and update the HashMap.

Remove the last element from both the ArrayList and the HashMap.

Return true to indicate the value was successfully removed.

GetRandom:

Use the Random class to get a random index from the ArrayList.

Return the element at the randomly selected index.

DATA STRUCTURE
ArrayList<Integer>: To store the elements of the set, providing O(1) time complexity for random access.

HashMap<Integer, Integer>: To store the mapping of each element to its index in the ArrayList, providing O(1) time complexity for insertions and deletions.

Random class: To generate random indices for the getRandom
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class RandomizedSet {
    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> locs;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) {
            return false;
        }
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) {
            return false;
        }
        int loc = locs.get(val);
        if (loc < nums.size() - 1) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1);
            nums.set(loc, lastone);
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1)); // true
        System.out.println(set.insert(2)); // true
        System.out.println(set.remove(1)); // true
        System.out.println(set.getRandom()); // should return 2
    }
}
