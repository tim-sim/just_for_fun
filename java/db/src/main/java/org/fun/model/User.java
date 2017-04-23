package org.fun.model;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.fun.hibernate.JsonBType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;
import java.util.UUID;

@TypeDef(name = "jsonb", typeClass = JsonBType.class)
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
    @Type(type = "jsonb")
    private Map<String, String> name;
    @Type(type = "jsonb")
    private Map<String, String> address;
    private String email;
    private boolean active = true;

    public User() {
    }

    public User(String login, String password, Map<String, String> name, Map<String, String> address, String email) {
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
        private Map<String, String> name = Maps.newHashMap();
        private Map<String, String> address = Maps.newHashMap();
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

        public User.UserBuilder nameItem(String key, String value) {
            this.name.put(key, value);
            return this;
        }

        public User.UserBuilder addressItem(String key, String value) {
            this.address.put(key, value);
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
