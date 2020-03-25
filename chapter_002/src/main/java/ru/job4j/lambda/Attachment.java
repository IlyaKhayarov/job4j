package ru.job4j.lambda;

import java.util.Objects;

public class Attachment {
    String image;
    int size;

    public Attachment(String image, int count) {
        this.image = image;
        this.size = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int count) {
        this.size = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return size == that.size &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, size);
    }
}
