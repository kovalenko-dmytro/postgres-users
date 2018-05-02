package study.apach.model.entities;

import java.util.Objects;

public class User {

    private long id;
    private String name;
    private int age;
    private long roleId;
    private String roleDescription;

    public User() {
    }

    public User(String name, int age, long roleId) {
        this.name = name;
        this.age = age;
        this.roleId = roleId;
    }

    public User(String name, int age, long roleId, String roleDescription) {
        this.name = name;
        this.age = age;
        this.roleId = roleId;
        this.roleDescription = roleDescription;
    }

    public User(long id, String name, int age, String roleDescription) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.roleDescription = roleDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                roleId == user.roleId &&
                Objects.equals(name, user.name) &&
                Objects.equals(roleDescription, user.roleDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, roleId, roleDescription);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", roleId=" + roleId +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
