package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileCabinet implements Cabinet {
    private List<Folder> folders;


    public FileCabinet(List<Folder> folders) {
        this.folders = folders;

    }

    public FileCabinet() {

    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        List<Folder> recursiveList = outerLoop(folders);
        Optional<Folder> folderOptional = Optional.ofNullable(
                recursiveList.stream()
                        .filter(f -> f.getName().equals(name)).findFirst().orElse(null));
        return folderOptional;
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        List<Folder> recursiveList = outerLoop(folders);
        List<Folder> folderOptional =
                recursiveList.stream()
                        .filter(f -> f.getSize().equals(size)).toList();
        return folderOptional;
    }

    @Override
    public int count() {
        int count = 0;
        System.out.println(count);
        for (int i = 0; i < folders.size(); i++) {
            count += recursionCount(folders.get(i));
        }
        return count;
    }

    public List<Folder> outerLoop(List<Folder> folders) {
        List<Folder> recursiveList = new ArrayList<>();
        for (int i = 0; i < folders.size(); i++) {
            innerRecursiveLoop(recursiveList, folders.get(i));
        }
        return recursiveList;
    }

    public void innerRecursiveLoop(List<Folder> recursiveList, Folder folder) {
        recursiveList.add(folder);
        if (folder instanceof MultiFolder multiFolder) {
            for (int i = 0; i < multiFolder.getFolders().size(); i++) {
                innerRecursiveLoop(recursiveList, multiFolder.getFolders().get(i));
            }
        }
    }

    public int recursionCount(Folder folder) {
        int count2 = 1;
        if (!(folder instanceof MultiFolder multiFolder)) {
            return count2;
        } else {
            for (int i = 0; i < multiFolder.getFolders().size(); i++) {
                count2 += recursionCount(multiFolder.getFolders().get(i));
            }
            return count2;
        }

    }
}
