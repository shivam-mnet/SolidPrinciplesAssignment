package net.media.training.designpattern.builder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class XMLElementBuilder {
    private boolean isSpecialElement = false;
    private String root;
    private final LinkedHashMap<String, String> attributes = new LinkedHashMap<>();
    private final List<String> children = new ArrayList<>();

    public XMLElementBuilder setIsSpecialTag(boolean isSpecialElement) {
        this.isSpecialElement = isSpecialElement;
        if (isSpecialElement) {
            root = "";
        }
        return this;
    }

    public XMLElementBuilder setRoot(String root) {
        this.root = root;
        return this;
    }

    public XMLElementBuilder setAttribute(String key, String value) {
        assert root != null : "Root must be set before attributes can be set";
        attributes.put(key, value);
        return this;
    }

    public XMLElementBuilder setChild(String child) {
        assert root != null : "Root must be set before children can be set";
        assert !isSpecialElement : "Special element cannot have children";
        children.add(child);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(root);
        if (isSpecialElement) {
            builder.append("?xml");
        }
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            builder
                .append(" ")
                .append(entry.getKey())
                .append("=\"")
                .append(entry.getValue())
                .append("\"");
        }
        if (isSpecialElement) {
            builder.append("?>");
            return builder.toString();
        }
        builder.append(">");
        children.forEach(builder::append);
        builder.append("</").append(root).append(">");
        return builder.toString();
    }

    public void reset() {
        root = null;
        attributes.clear();
        children.clear();
        isSpecialElement = false;
    }
}
