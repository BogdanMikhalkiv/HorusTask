package org.example;

import java.util.List;
import java.util.Optional;

public class FileCabinet implements Cabinet {
    private List<Folder> folders;



    public FileCabinet(List<Folder> folders) {
        this.folders = folders;

    }

    public FileCabinet(){

    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        Optional<Folder> folderOptional = Optional.ofNullable(
                folders.stream()
                        .filter(f -> f.getName().equals(name)).findFirst().orElse(null));
        return folderOptional;
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        List<Folder> folderOptional =
                folders.stream()
                        .filter(f -> f.getSize().equals(size)).toList();
        return folderOptional;
    }

    @Override
    public int count() {
        int count = 0;
        System.out.println(count);
        for (int i = 0; i < folders.size(); i++) {
           count+= recursionCount(folders.get(i));
        }
        return count;
    }

    public int recursionCount(Folder folder) {
        int count2 = 1;
        if (!(folder instanceof MultiFolder multiFolder)) {
            return count2;
        } else {
//            for(Folder folder1 : multiFolder.getFolders()) {
//                count2 += recursionCount(folder1);
//            }

            for (int i = 0; i < multiFolder.getFolders().size(); i++) {
               count2+=  recursionCount( multiFolder.getFolders().get(i));

            }
            return count2;
        }

    }
}
