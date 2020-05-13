import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/** Starter code for LP3
 *  @author
 */

//rks160130

//package rbk;

// If you want to create additional classes, place them in this file as subclasses of MDS

public class MDS {
    
	int id;
	int price;
	int list;
	

    // Constructors
    public MDS() {
    }

    /* Public methods of MDS. Do not change their signatures.
       __________________________________________________________________
       a. Insert(id,price,list): insert a new item whose description is given
       in the list.  If an entry with the same id already exists, then its
       description and price are replaced by the new values, unless list
       is null or empty, in which case, just the price is updated. 
       Returns 1 if the item is new, and 0 otherwise.
    */
    
    TreeMap<Integer,Integer>tree=new TreeMap();//treemap containing id and price
    HashMap<Integer,TreeSet<Integer>>table=new HashMap();//hashmap containing id and description
    TreeSet<Integer>ts=new TreeSet();//treeset of description
    
    
    public int insert(int id, int price, java.util.List<Integer> list) {
    	if(tree.containsKey(id)) { // if Id is found
    		if(list!=null && !list.isEmpty()) {//list not null and empty
    			tree.put(id,price); //put the id and price into tree
    			ts = new TreeSet<Integer>(list); //new set of list
    			table.put(id, ts);
    		}
    		return 0;

    	}
    else {
    		tree.put(id, price); // add new id and price
    		ts=table.get(id);
    		if (ts==null) {
    			table.put(id, new TreeSet<Integer>(list));// add the id and description
    		}
    		else {
    			ts.add(id);
    			
    		}
    		return 0;
    	}
    }

    // b. Find(id): return price of item with given id (or 0, if not found).
    public int find(int id) {
    	if(tree.containsKey(id)) {//tree containing id
    		price=tree.get(id);//get the price of id
    		return price;
    	}
    	else
    		return 0;
    }

    /* 
       c. Delete(id): delete item from storage.  Returns the sum of the
       ints that are in the description of the item deleted,
       or 0, if such an id did not exist.
    */
    public int delete(int id) {
    int sum=0;
    	if(table.containsKey(id)) {
    		TreeSet<Integer> item = table.remove(id);//removing id
    		tree.remove(id);
    		for(Integer e: item) {// summing the description
    		sum = sum + e;
    		}
    	return sum;	
    	}
    	else
    		return 0;
    }

    /* 
       d. FindMinPrice(n): given an integer, find items whose description
       contains that number (exact match with one of the ints in the
       item's description), and return lowest price of those items.
       Return 0 if there is no such item.
    */
    public int findMinPrice(int n) {
     	TreeMap<Integer,Integer>temp=new TreeMap<>();//new treemap to store temporary values
    	for(Entry<Integer,TreeSet<Integer>>ent:table.entrySet()) {//iterate through table and get the list
    		TreeSet<Integer> list=ent.getValue();
    		int key=ent.getKey();//find the key
    		for(int input:list) {//if input in list
    			if(input==n) {
    				temp.put(key,tree.get(key));//put the new values in
    				int min=Collections.min(temp.values());//finding the minimum of those values
      	          return min;
    			}
    		
    		}
    	}
    	
    		return 0;
    }


    /* 
       e. FindMaxPrice(n): given an integer, find items whose description
       contains that number, and return highest price of those items.
       Return 0 if there is no such item.
    */
    public int findMaxPrice(int n) {
      	
    	TreeMap<Integer,Integer>temp=new TreeMap<>();//same steps as findMinPrice
    	for(Entry<Integer,TreeSet<Integer>>ent:table.entrySet()) {
    		TreeSet<Integer> list=ent.getValue();
    		int key=ent.getKey();
    		for(int input:list) {
    			if(input==n) {
    				temp.put(key,tree.get(key));
    				int max=Collections.max(temp.values());//finding the max price
      	          return max;
    			}
    		
    		}
    	}
    	
    		return 0;
    }

    /* 
       f. FindPriceRange(n,low,high): given int n, find the number
       of items whose description contains n, and in addition,
       their prices fall within the given range, [low, high].
    */
    public int findPriceRange(int n, int low, int high) {
    	int count=0;
    	TreeMap<Integer,Integer>temp=new TreeMap<>();//same steps used in FindMinPrice to find and match the user input
    	for(Entry<Integer,TreeSet<Integer>>ent:table.entrySet()) {
    		TreeSet<Integer> list=ent.getValue();
    		int key=ent.getKey();
    		
    		for(int input:list) {
    			if(input==n) {
    				
    				temp.put(key,tree.get(key));
    				if (temp.get(key) >= low && temp.get(key)<= high) {//if values equal to user low and high
    				  count++; //update
    				}
    				
    				
    			}
    		
    		}
    		
    		return count; //return count
    	}
    	
    	
    		return 0;
    }


    

    /*
      g. RemoveNames(id, list): Remove elements of list from the description of id.
      It is possible that some of the items in the list are not in the
      id's description.  Return the sum of the numbers that are actually
      deleted from the description of id.  Return 0 if there is no such id.
    */
    public int removeNames(int id, java.util.List<Integer> list) {
    
   
        return 0;
    }
}

