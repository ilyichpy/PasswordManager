package org.manager.models;

public class PasswordInfo {
    private Long id;
    private String email;
    private String password;
    private String site;

    public PasswordInfo() {
    }

    public PasswordInfo(Long id, String email, String password, String site) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.site = site;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSite() {
        return this.site;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PasswordInfo)) return false;
        final PasswordInfo other = (PasswordInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$site = this.getSite();
        final Object other$site = other.getSite();
        if (this$site == null ? other$site != null : !this$site.equals(other$site)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PasswordInfo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $site = this.getSite();
        result = result * PRIME + ($site == null ? 43 : $site.hashCode());
        return result;
    }

    public String toString() {
        return "id=" + this.getId() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", site=" + this.getSite();
    }
}
