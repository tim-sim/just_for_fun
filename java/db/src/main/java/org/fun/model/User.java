package org.fun.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @Type(type = "pg-uuid")
    private UUID id = UUID.randomUUID();
    private String login;
    private String password;
    private String name;
    private String address;
    private String email;
    private boolean active = true;

    public User() {
    }

    public User(String login, String password, String name, String address, String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String userName;
        private String password;
        private String name;
        private String address;
        private String email;

        UserBuilder() {
        }

        public User.UserBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public User.UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User.UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public User.UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User.UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(userName, password, name, address, email);
        }
    }
}
