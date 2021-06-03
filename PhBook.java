import java.util.*;

public class PhBook {

  private Person[] phonebook;
  private int capacity;

  private class Person implements Comparable<Person> {

    private String name;
    private long ph_number;

    public Person(String name, long num) {
      this.name = name;
      ph_number = num;
    }

    /**
    Constant time O(1) getter method
    **/
    public String getName() {
      return name;
    }

    /**
    Constant time O(1) getter method
    **/
    public long getNum() {
      return ph_number;
    }

    /**
    Constant time O(1) compareTo method that campares person based on name first
    or in the case of identical names, their number.
    **/
    public int compareTo(Person other) {
      if (this.name.compareTo(other.getName()) == 0) {
        if (this.ph_number > other.getNum()) {
          return 1;
        } else if (this.ph_number < other.getNum()) {
          return -1;
        } else if (this.ph_number == other.getNum()) {
          return 0;
        }
      }
      return this.name.compareTo(other.getName());
    }

    /**
    Constant time O(1) toString method to print out this person's information in a readable form
    **/
    public String toString() {
      return name + ": " + ph_number + " ";
    }
  }

  public PhBook(int size) {
    phonebook = new Person[size];
    capacity = 0;
  }

  /**
  Constant time O(1) insert method that inserts a new person to the end of the phonebook
  **/
  public boolean PhBookInsert(String name, long num) {
    if (capacity == phonebook.length) {
      return false;
    }
    Person toAdd = new Person(name, num);
    phonebook[capacity] = toAdd;
    capacity++;
    return true;
  }

  /**
  Linear time O(n) method to delete an element from the phonebook. Will always make a full traversal of the array as I am shifting
  elements up after deleting a previous element.
  **/
  public boolean PhBookDelete(String name, long num) {
    for (int i = 0; i < phonebook.length; i++) {
      if (phonebook[i].getName().equals(name) && phonebook[i].getNum() == num) {
        phonebook[i] = null;
        capacity--;
        while (i + 1 < phonebook.length && phonebook[i + 1] != null) { // shifts the remaining array up one unit
          phonebook[i] = phonebook[i + 1];
          i++;
        }
        return true;
      }
    }
    return false;
  }

  /**
  Constant time O(1) getter method
  **/
  public Person[] getPhonebook() {
    return phonebook;
  }

  /**
  Constant time O(1) setter method
  **/
  private void setPhonebook(Person[] newPhbook) {
    phonebook = newPhbook;
  }

  /**
  Constant time O(1) toString method to print out this phonebook's information in a readable form
  **/
  public String toString() {
    String ans = "";
    for (int i = 0; i < capacity; i++) {
      ans += phonebook[i];
    }
    return ans;
  }

  /**
  heapsort runtime analysis will be done in a separate pdf document along with heapify and siftdown.
  **/
  public void heapSort(Person[] phbook, int startIndex, int endIndex) {
    phbook = heapify(phbook, startIndex, endIndex);
    for (int i = startIndex; i <= endIndex;) {
      phbook = swap(phbook, i, endIndex);
      phbook = siftDown(phbook, i, endIndex - 1);
      endIndex--;
    }
    setPhonebook(phbook);
  }

  private Person[] heapify(Person[] phbook, int startIndex, int endIndex) {
    for (int i = (int)Math.ceil((endIndex - 1) / 2); i >= startIndex; i--) {
      phbook = siftDown(phbook, i, endIndex);
    }
    // for (int i = endIndex; i >= startIndex; i--) {
    //   phbook = siftDown(phbook, i, endIndex);
    // }
    return phbook;
  }

  /**
  Constant time function to swap the position of two elements in an array.
  **/
  private Person[] swap(Person[] phbook, int index1, int index2) {
    Person temp = phbook[index1];
    phbook[index1] = phbook[index2];
    phbook[index2] = temp;
    return phbook;
  }

  private Person[] siftDown(Person[] phbook, int index, int endIndex) {
    if (index * 2 + 2 <= endIndex) { // this checks if phbook[index] has 2 children
      if (phbook[index].compareTo(phbook[index * 2 + 1]) <= 0 && phbook[index * 2 + 1].compareTo(phbook[index * 2 + 2]) > 0) {
        phbook = swap(phbook, index, index * 2 + 1);
        siftDown(phbook, index * 2 + 1, endIndex);
      } else if (phbook[index].compareTo(phbook[index * 2 + 2]) <= 0 && phbook[index * 2 + 1].compareTo(phbook[index * 2 + 2]) <= 0) {
        phbook = swap(phbook, index, index * 2 + 2);
        siftDown(phbook, index * 2 + 2, endIndex);
      }
    } else if (index * 2 + 1 <= endIndex && phbook[index].compareTo(phbook[index * 2 + 1]) <= 0) { // this block runs if phbook[index] only has one children
      phbook = swap(phbook, index, index * 2 + 1);
      siftDown(phbook, index * 2 + 1, endIndex);
    }
    return phbook;
  }

  /**
  Credits to baeldung.com for this generate random string function
  Constant time function to generate a random string
  **/
  private String generateName(int length) {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    Random random = new Random();
    String generatedString = random.ints(leftLimit, rightLimit + 1).limit(length+1).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    return generatedString;
  }

  /**
  Constant time function to generate a random long
  **/
  private long generateNum() {
    Random random = new Random();
    return random.nextLong() & 9999999999L;
  }

  /**
  Linear time O(n) function to fill the phonebook with a specified number of elements.
  **/
  public void fillPhonebook(int numberOfElements) {
    Random random = new Random();
    for (int i = 0; i < numberOfElements; i++) {
      PhBookInsert(generateName(random.nextInt(10)), generateNum());
    }
  }

  /**
  Linear time O(n) function to check if the phonebook is sorted.
  This is used to test if my heapsort actually works.
  **/
  public boolean isSorted(Person[] array) {
    for (int i = 0; i < capacity - 1; i++) {
      if (array[i].compareTo(array[i + 1]) > 0) {
        return false;
      }
    }
    return true;
  }
}
