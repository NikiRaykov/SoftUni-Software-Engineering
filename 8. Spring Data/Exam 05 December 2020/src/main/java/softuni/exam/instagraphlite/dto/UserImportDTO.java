package softuni.exam.instagraphlite.dto;

public class UserImportDTO {
    private String username;
    private String password;
    private String profilePicture;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String picture) {
        this.profilePicture = picture;
    }

    public boolean isValid() {
        if (this.username == null || this.username.length() < 2 || this.username.length() > 18) {
            return false;
        }
        if (this.password == null || this.password.length() < 4) {
            return false;
        }

        if (this.profilePicture == null) {
            return false;
        }
        return true;
    }
}
