package Uebung6.first;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Ort<E> {
    private final int ortsId;
    private E smth;

    public Ort(int ortsId){
        this.ortsId =  ortsId;
        //this.smth = obg;
    }

    public E entnehmen(){
        E temp = smth;
        smth = null;
        return temp;
    }

    public void hinzufuegen(E e){
        if(smth == null){
            smth = e;
        }
    }

    public E getEingelagertesElement(){
        return smth;
    }

    public boolean istBelegt(){
        return smth != null;
    }

    public int getOrtsId(){
        return ortsId;
    }

    @Override
    public String toString() {
        return String.format("OrtId:%d %s", ortsId, smth);
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Ort<String> ort = new Ort<>(111);
        ort.hinzufuegen("string1");

        System.out.println(ort.getEingelagertesElement());
        System.out.println(ort.istBelegt());  // true
        System.out.println(ort.entnehmen());   // deleted
        System.out.println(ort.getEingelagertesElement());   // false
        System.out.println(ort.istBelegt());
        ort.hinzufuegen("string2");
        System.out.println(ort);

        Ort<File> ort2 = new Ort<>(222);
        ort2.hinzufuegen(new File("file1.txt"));
        System.out.println(ort2);

        List<?> list = List.of("str1", 123);

        System.out.println(list);
    }
}