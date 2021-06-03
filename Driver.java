import java.util.*;

public class Driver {
  public static void main(String[] args) {
    PhBook phbook = new PhBook(1000000);
    System.out.println("Testing sorts for array of size 100: ");
    phbook.fillPhonebook(100);
    long prevTime = System.nanoTime();
    phbook.heapSort(phbook.getPhonebook(), 0, 99);
    long postTime = System.nanoTime();
    System.out.println("Total time taken for heap sort in nanoseconds: " + (postTime - prevTime));
    System.out.println("Is the phonebook sorted: " + phbook.isSorted(phbook.getPhonebook()));
    phbook = new PhBook(1000000);
    phbook.fillPhonebook(100);
    prevTime = System.nanoTime();
    Arrays.sort(phbook.getPhonebook(), 0, 100);
    postTime = System.nanoTime();
    System.out.println("Total time taken for built-in sort in nanoseconds: " + (postTime - prevTime));

    System.out.println("--------------------------------------------------------------------");

    phbook = new PhBook(1000000);
    System.out.println("Testing sorts for array of size 1000: ");
    phbook.fillPhonebook(1000);
    prevTime = System.nanoTime();
    phbook.heapSort(phbook.getPhonebook(), 0, 999);
    postTime = System.nanoTime();
    System.out.println("Total time taken for heap sort in nanoseconds: " + (postTime - prevTime));
    System.out.println("Is the phonebook sorted: " + phbook.isSorted(phbook.getPhonebook()));
    phbook = new PhBook(1000000);
    phbook.fillPhonebook(1000);
    prevTime = System.nanoTime();
    Arrays.sort(phbook.getPhonebook(), 0, 1000);
    postTime = System.nanoTime();
    System.out.println("Total time taken for built-in sort in nanoseconds: " + (postTime - prevTime));

    System.out.println("--------------------------------------------------------------------");

    phbook = new PhBook(1000000);
    System.out.println("Testing sorts for array of size 10000: ");
    phbook.fillPhonebook(10000);
    prevTime = System.nanoTime();
    phbook.heapSort(phbook.getPhonebook(), 0, 9999);
    postTime = System.nanoTime();
    System.out.println("Total time taken for heap sort in nanoseconds: " + (postTime - prevTime));
    System.out.println("Is the phonebook sorted: " + phbook.isSorted(phbook.getPhonebook()));
    phbook = new PhBook(1000000);
    phbook.fillPhonebook(10000);
    prevTime = System.nanoTime();
    Arrays.sort(phbook.getPhonebook(), 0, 10000);
    postTime = System.nanoTime();
    System.out.println("Total time taken for built-in sort in nanoseconds: " + (postTime - prevTime));

    System.out.println("--------------------------------------------------------------------");

    phbook = new PhBook(1000000);
    System.out.println("Testing sorts for array of size 100000: ");
    phbook.fillPhonebook(100000);
    prevTime = System.nanoTime();
    phbook.heapSort(phbook.getPhonebook(), 0, 99999);
    postTime = System.nanoTime();
    System.out.println("Total time taken for heap sort in nanoseconds: " + (postTime - prevTime));
    System.out.println("Is the phonebook sorted: " + phbook.isSorted(phbook.getPhonebook()));
    phbook = new PhBook(1000000);
    phbook.fillPhonebook(100000);
    prevTime = System.nanoTime();
    Arrays.sort(phbook.getPhonebook(), 0, 100000);
    postTime = System.nanoTime();
    System.out.println("Total time taken for built-in sort in nanoseconds: " + (postTime - prevTime));

    System.out.println("--------------------------------------------------------------------");

    phbook = new PhBook(1000000);
    System.out.println("Testing sorts for array of size 100000: ");
    phbook.fillPhonebook(1000000);
    prevTime = System.nanoTime();
    phbook.heapSort(phbook.getPhonebook(), 0, 999999);
    postTime = System.nanoTime();
    System.out.println("Total time taken for heap sort in nanoseconds: " + (postTime - prevTime));
    System.out.println("Is the phonebook sorted: " + phbook.isSorted(phbook.getPhonebook()));
    phbook = new PhBook(1000000);
    phbook.fillPhonebook(1000000);
    prevTime = System.nanoTime();
    Arrays.sort(phbook.getPhonebook(), 0, 1000000);
    postTime = System.nanoTime();
    System.out.println("Total time taken for built-in sort in nanoseconds: " + (postTime - prevTime));
  }
}
