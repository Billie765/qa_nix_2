package org.example.config;

public enum FileType {

    JSON_TYPE("users.json");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
