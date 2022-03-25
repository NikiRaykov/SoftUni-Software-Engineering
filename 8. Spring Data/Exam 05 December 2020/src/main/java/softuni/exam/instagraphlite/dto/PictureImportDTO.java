package softuni.exam.instagraphlite.dto;

public class PictureImportDTO {
    private String path;
    private Double size;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isValid() {
        if (this.path == null) {
            return false;
        }
        if (this.size == null || this.size < 500 || this.size > 60000) {
            return false;
        }
        return true;
    }
}
