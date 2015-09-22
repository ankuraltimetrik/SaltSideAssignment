package saltside.com.saltsidecode.app.model;

import java.io.Serializable;

/**
 * Created by Agoel on 22-09-2015.
 */
public class ListModel implements Serializable {

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String title;
    private String description;
}
