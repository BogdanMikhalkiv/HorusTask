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
        return 0;
    }
}
