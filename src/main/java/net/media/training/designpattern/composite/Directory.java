package net.media.training.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 19, 2011
 * Time: 9:18:51 PM
 * To change this template use pre_refactoring.File | Settings | pre_refactoring.File Templates.
 */
public class Directory implements FileSystemEntity {
    private final String name;
    private final List<FileSystemEntity> children;
    private Directory parent;

    public String getName() {
        return name;
    }

    public Directory(String name, List<FileSystemEntity> children) {
        this.name = name;
        this.children = children;
        children.forEach(entity -> entity.setParent(this));
    }

    public int getSize() {
        int sum = 0;
        for (FileSystemEntity entity : children) {
            sum += entity.getSize();
        }
        return sum;
    }

    @Override
    public void delete() {
        while (!children.isEmpty()) {
            FileSystemEntity child = children.get(0);
            child.delete();
        }
        if (parent != null) {
            parent.removeEntry(this);
        }
    }

    @Override
    public boolean exists(String name) {
        if (name.equals(getName())) {
            return true;
        }

        for (FileSystemEntity entity : children) {
            if (entity.exists(name)) {
                return true;
            }
        }

        return false;
    }

    public void removeEntry(FileSystemEntity fileSystemEntity) {
        children.remove(fileSystemEntity);
    }

    public void add(FileSystemEntity fileSystemEntity) {
        children.add(fileSystemEntity);
    }

    @Override
    public Directory getParent() {
        return parent;
    }

    @Override
    public void setParent(Directory parent) {
        this.parent = parent;
    }
}
