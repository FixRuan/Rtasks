package br.edu.ifpr.rtasks.controllers.entities;

public class Task {
    private String name;
    private byte[] image_content;
    private String image_type;

    public Task(String name, byte[] image_content, String image_type) {
        this.name = name;
        this.image_content = image_content;
        this.image_type = image_type;
    }
    
    public String getName() {
        return name;
    }

    public byte[] getImage_content() {
        return image_content;
    }

    public String getImage_type() {
        return image_type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage_content(byte[] image_content) {
        this.image_content = image_content;
    }

    public void setImage_type(String image_type) {
        this.image_type = image_type;
    }  
}
