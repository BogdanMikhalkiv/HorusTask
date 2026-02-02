package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       Folder file1 = new FolderImpl("asd","20");
       Folder file2 = new FolderImpl("qwerty","10");

        MultiFolder multiFolder1 = new MultiFolderImpl("multifolder1","40", List.of(file1));



        FileCabinet fileCabinet = new FileCabinet(List.of(file2,multiFolder1));


        System.out.println(fileCabinet.count());


    }
}