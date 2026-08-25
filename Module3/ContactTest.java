import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest { 
 
  @Test 
  void constructor_setsNameCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("Ada Lovelace", c.getName()); 
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    Contact c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    assertEquals("+1 617 555 0101", c.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Alan Turing", "555-0001"); 
    assertTrue(c.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }

  @Test 
  void constructor_ObjectsDifferent(){
    Contact a = new Contact("Tim Bernie", "556-907-3456");
    Contact b = new Contact("Tim Bernie", "345-564-2954");
    a = new Contact("lee wall", "345-235-8755");

    assertEquals("Tim Bernie | 345-564-2954", b.toString());
  }

  @Test 
  void getPhone_worksCorrectly(){
    Contact c = new Contact("ada lovelace", "123-456-7890");
    assertEquals("123-456-7890", c.getPhone());
  }
} 