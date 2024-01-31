package oop1;

import java.util.Scanner;

public class Pattern1 extends Thread {
    private static final Object lock = new Object();
    private String pattern;
    private int count;

    public Pattern1(String pattern, int count) {
        this.pattern = pattern;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < count; i++) {
                try {
                    System.out.print("Pattern 01 Thread = ");
                    for (int j = 0; j <= i; j++) {
                        System.out.print(pattern + " ");
                    }
                    System.out.println();
                    lock.notify();  // Notify the other thread to print its pattern
                    lock.wait(1000);  // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Pattern2 extends Thread {
    private static final Object lock = new Object();
    private String pattern;
    private int count;

    public Pattern2(String pattern, int count) {
        this.pattern = pattern;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < count; i++) {
                try {
                    lock.wait();  // Wait for the other thread to finish printing its pattern
                    System.out.print("Pattern 02 Thread = ");
                    for (int j = count - 1; j > i; j--) {
                        System.out.print(pattern + " ");
                    }
                    System.out.println();
                    lock.notify();  // Notify the other thread to print its pattern
                    lock.wait(1000);  // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Pattern 1 = ");
        String pattern1 = scanner.nextLine();

        System.out.print("Enter Pattern 2 = ");
        String pattern2 = scanner.nextLine();

        System.out.print("Enter count = ");
        int count = scanner.nextInt();

        System.out.println("======= Threads start printing patterns. =======");

        Pattern1 pattern01Thread = new Pattern1(pattern1, count);
        Pattern2 pattern02Thread = new Pattern2(pattern2, count);

        pattern01Thread.start();
        pattern02Thread.start();
    }
}

