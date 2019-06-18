package es.upm.miw.documents;

import org.springframework.data.annotation.Id;

public class Category {

    @Id
    private String id;
    private String description;

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((Category) obj).id));
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
