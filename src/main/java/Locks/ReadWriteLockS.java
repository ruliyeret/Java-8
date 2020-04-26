package Locks;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class ReadWriteLockS {

    private HashMap<String,Integer> synchronizedHashMap = new HashMap<>();
    private ReadWriteLock lock  = new ReentrantReadWriteLock();
    private  Lock writeLock = this.lock.writeLock();
    Lock readLock = this.lock.readLock();

    public ReadWriteLockS(){

    }
    public int getValue(String key){
        try {
            this.readLock.lock();
            return this.synchronizedHashMap.get(key);
        }finally {
            this.readLock.unlock();
        }

    }

    public void put(String key, int value){


        try {
             this.writeLock.lock();
             this.synchronizedHashMap.put(key,value);
        }finally {
            this.writeLock.unlock();
        }
    }

    public void remove(String key){
        try{
            this.writeLock.lock();
            this.synchronizedHashMap.remove(key);
        }finally {
            this.writeLock.unlock();
        }
    }

    public Boolean contains(String key){
        try{
            this.readLock.lock();
            return this.synchronizedHashMap.containsKey(key);
        }finally {
            this.readLock.unlock();
        }
    }




    public static void main(String[] args) {
        ReadWriteLockS readWriteLocksOnHashMap = new ReadWriteLockS();
        readWriteLocksOnHashMap.put("Ruli",23);
        boolean contains = readWriteLocksOnHashMap.contains("Ruli");
        int age = readWriteLocksOnHashMap.getValue("Ruli");
        System.out.println("This is Ruli  age " + age);
        System.out.println(String.format("%s%s","Is ruli contains in the map? ", String.valueOf(contains)));

        Thread t  =new Thread(new Runnable() {
            @Override
            public void run() {
               String name;
                while (true){
                    System.out.println("In thread number 1");
                     name  = "ruli" + IntStream.range(0,1000);
                    readWriteLocksOnHashMap.put(name, 2);

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("In thread number 2");
                    boolean isExist = readWriteLocksOnHashMap.contains("Ruli");
                    System.out.println(String.format("is ruli contains in the map? ",String.valueOf(isExist)));

                }
            }
        });

        t.start();
        t2.start();


    }
}
