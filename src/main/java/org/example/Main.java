package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       Folder file1 = new FolderImpl("1","small");
       Folder file2 = new FolderImpl("2","medium");
       Folder file3 = new FolderImpl("3","small");
       Folder file4 = new FolderImpl("4","big");

        MultiFolder multiFolder1 = new MultiFolderImpl("multifolder1","small", List.of(file1));
        MultiFolder multiFolder2 = new MultiFolderImpl("multifolder2","medium", List.of(multiFolder1));
        MultiFolder multiFolder3 = new MultiFolderImpl("multifolder3","big", List.of(file2,file3));
        MultiFolder multiFolder4 = new MultiFolderImpl("multifolder4","big", List.of(multiFolder3));




        FileCabinet fileCabinet = new FileCabinet(List.of(multiFolder2,multiFolder4, file4));


        System.out.println(fileCabinet.count());

        System.out.println(fileCabinet.findFolderByName("multifolder1"));


    }
}