package org.example;

public class FolderImpl implements Folder{
    private String name;
    private String size;

    public FolderImpl(String name,String size){
        this.name = name;
        this.size = size;
    }

    public FolderImpl(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "FolderImpl{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                '}' + "\n";
    }
}
