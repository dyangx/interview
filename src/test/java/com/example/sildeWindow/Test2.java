package com.example.sildeWindow;

public class Test2 {

    public static void main(String[] args) {

    }
}

class Entry{
    long time = 0;
    int num = 0;
}
class Queue{
    Entry[] arr;
    int p = 0;
    public Queue() {
        this.arr = new Entry[]{new Entry(), new Entry(), new Entry(), new Entry(), new Entry(), new Entry(), new Entry(), new Entry(), new Entry(), new Entry()};
    }
    public Entry get(){
        Entry entry = arr[p];
        if(entry.num >= 10){
            if(arr[addP()].num <10){
                p = (++p)/10;
            }
        }
        return arr[p];
    }

    public int addP(){
        return (p+1)%10;
    }

    public boolean limit(){
        Entry entry = arr[p];
        if((entry.time + 100) > getTime()){
            if(entry.num < 10){
                entry.num++;
                return false;
            }else {
                return true;
            }
        }else {

        }

        return false;
    }

    public long getTime(){
        return System.currentTimeMillis()/1000;
    }
}
