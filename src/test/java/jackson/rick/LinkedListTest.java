package jackson.rick;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rickjackson on 2/24/17.
 */
public class LinkedListTest {
    private LinkedList<Object> list;
    
    @Before
    public void setup() {
        list = new LinkedList<>();
        list.add(0);
        list.add('a');
        list.add(true);
        list.add("HERE");
        list.add("NOT THERE ANYMORE!");
    }
    
    @Test
    public void testAdd() {
        assertEquals(true, list.add(true));
        assertEquals(true, list.get(list.size() - 1));
    }
    
    @Test
    public void testAdd_index() {
        assertEquals(0, list.get(0));
        list.add(0, true);
        assertEquals(true, list.add(true));
    }
    
    @Test
    public void testRemove_first() {
        assertEquals(0, list.get(0));
        assertEquals(0, list.remove());
        assertEquals('a', list.get(0));
        assertEquals('a', list.remove());
        assertEquals(true, list.get(0));
    }
    
    @Test
    public void testRemove_index() {
        assertEquals("HERE", list.get(3));
        assertEquals("HERE", list.remove(3));
        assertEquals("NOT THERE ANYMORE!", list.get(3));
    }
    
    @Test
    public void testRemove_object() {
        assertEquals("HERE", list.get(3));
        assertEquals(true, list.remove("HERE"));
        assertEquals("NOT THERE ANYMORE!", list.get(3));
        assertEquals(true, list.remove("NOT THERE ANYMORE!"));
        assertEquals(false, list.remove("TRY AGAIN"));
    }
    
    @Test
    public void testContains() {
        assertEquals(list.contains(null), false);
    }
    
    @Test
    public void testFind() {
        assertEquals(list.find(null), 0);
    }
    
    @Test
    public void testSize() {
        assertEquals(list.size(), 0);
    }
    
    @Test
    public void testClone() {
        assertEquals(list.clone(), null);
    }
    
    @Test
    public void testSort() {
        list.sort();
    }
    
    @Test
    public void testReverse() {
        list.reverse();
    }
    
    @Test
    public void testSlice() {
        assertEquals(list.slice(0,0), null);
    }
}
