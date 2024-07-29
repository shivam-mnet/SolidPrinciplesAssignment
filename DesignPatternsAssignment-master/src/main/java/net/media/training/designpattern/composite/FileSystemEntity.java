package net.media.training.designpattern.composite;

public interface FileSystemEntity {
    String getName();
    int getSize();
    Directory getParent();
    void setParent(Directory parent);
    void delete();
    boolean exists(String name);
}
