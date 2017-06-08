package org.fun.data.model;

import com.google.common.collect.Maps;
import lombok.Builder;
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
@Builder
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
    private boolean active = true;
}
