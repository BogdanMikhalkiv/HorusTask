package org.example;

import java.util.List;
import java.util.Optional;

public class FileCabinet  implements Cabinet{
    private List<Folder> folders;
    @Override
    public Optional<Folder> findFolderByName(String name) {
        return null;
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
