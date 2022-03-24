package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ImportPictureDto {

    public ImportPictureDto(){}

    @NotNull
    private String path;

    @Min(value = 500)
    @Max(value = 60000)
    private float size;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
