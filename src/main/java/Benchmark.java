package org.example;

public class Benchmark {

    // Helper: create a list with n elements
    private static DoublyLinkedList<Integer> buildList(int n) {
        DoublyLinkedList<Integer> list = new DoublyList<>();
        for (int i = 0; i < n; i++) {
            list.addLast(i);
        }
        return list;
    }

    // Benchmark insertion at the tail
    private static long benchmarkInsert(int n) {
        DoublyLinkedList<Integer> list = new DoublyList<>();

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.addLast(i);
        }
        long end = System.nanoTime();

        return end - start;
    }

    // Benchmark searching for all items
    private static long benchmarkSearch(int n) {
        DoublyLinkedList<Integer> list = buildList(n);

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.contains(i);
        }
        long end = System.nanoTime();

        return end - start;
    }

    // Benchmark accessing every element
    private static long benchmarkAccess(int n) {
        DoublyLinkedList<Integer> list = buildList(n);

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.getAt(i);
        }
        long end = System.nanoTime();

        return end - start;
    }

    // Benchmark removing all items from the front
    private static long benchmarkRemove(int n) {
        DoublyLinkedList<Integer> list = buildList(n);

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.removeFirst();
        }
        long end = System.nanoTime();

        return end - start;
    }

    public static void main(String[] args) {

        int[] sizes = {1_000, 5_000, 10_000, 50_000, 100_000};

        System.out.printf("%-10s %-15s %-15s %-15s %-15s\n",
                "N", "Insert(ns)", "Search(ns)", "Access(ns)", "Remove(ns)");

        for (int n : sizes) {
            long insert = benchmarkInsert(n);
            long search = benchmarkSearch(n);
            long access = benchmarkAccess(n);
            long remove = benchmarkRemove(n);

            System.out.printf("%-10d %-15d %-15d %-15d %-15d\n",
                    n, insert, search, access, remove);
        }
    }
}
