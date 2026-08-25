import java.util.*;

public class ContactManager {

  public static void main(String[] args) {

    HashMap<String, Contact> contacts = new HashMap<>();

    // Step 4: add contacts here
    contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
    contacts.put("Walt Disney", new Contact("Walt Disney", "+1 631 456 7891"));
    contacts.put("Tim Bernie", new Contact("Tim Bernie", "+1 517 654 9871"));
    contacts.put("Steve Jobs", new Contact("Steve Jobs", "+1 456 395 2902"));
    contacts.put("Tom Rogue", new Contact("Tom Rogue", "+1 435 136 4589"));

    // Step 5: look up a contact
    Contact ada = contacts.get("Ada Lovelace");
    if (ada == null) {
      System.out.println("Contact not found");
    } else {
      System.out.println(ada);
    }

    Contact notFound = contacts.get("Casey");
    if (notFound == null) {
      System.out.println("Contact not found");
    } else {
      System.out.println(notFound);
    }

    // Step 6: print sorted list
    ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
    sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
    System.out.println("=== All Contacts ===");
    for (Contact contact : sorted) {
      System.out.println(contact);
    }
  }
}
