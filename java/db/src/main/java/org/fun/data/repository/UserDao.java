package org.fun.data.repository;

import org.fun.rest.model.UserDto;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

/**
 * Created by tim on 03.06.2017.
 */
@Repository
public class UserDao {
    private static final Table<Record> ORDERS = table("orders");
    private static final Field<UUID> ORDER_ID = ORDERS.field("id", UUID.class);
    private static final Field<String> ORDER_CODE = ORDERS.field("code", String.class);

    private static final Table<Record> ORDER_PRODUCT_LINKS = table("order_product_links");
    private static final Field<UUID> ORDER_ID_LINK = ORDER_PRODUCT_LINKS.field("order_id", UUID.class);
    private static final Field<UUID> PRODUCT_ID_LINK = ORDER_PRODUCT_LINKS.field("product_id", UUID.class);

    private static final Table<Record> PRODUCTS = table("products");
    private static final Field<UUID> PRODUCT_ID = PRODUCTS.field("id", UUID.class);
    private static final Field<String> PRODUCT_TITLE = PRODUCTS.field("title", String.class);
    private static final Field<BigDecimal> PRODUCT_PRICE = PRODUCTS.field("price", BigDecimal.class);

    private static final Table<Record> USERS = table("users");
    private static final Field<UUID> USER_ID = USERS.field("id", UUID.class);
    private static final Field<String> USER_PERSON = USERS.field("person", String.class);

    @Autowired
    private DSLContext jooq;

    public List<UserDto> findAll() {
        return jooq.select(
                field("users.id", UUID.class),
                field("users.login", String.class),
                field("users.person->>'first_name'", String.class),
                field("users.person->>'last_name1'", String.class),
                field("users.active", Boolean.class))
                .from(table("users"))
                .where(field("users.active").eq(true))
                .orderBy(field("users.person->>'first_name'").desc())
                .fetch(record -> UserDto.builder()
                        .id(record.value1())
                        .login(record.value2())
                        .firstName(record.value3())
                        .lastName(record.value4())
                        .active(record.value5())
                        .build());
/*
        return jdbcTemplate.query(sql, (rs, rowNum) -> UserDto.builder()
                .id((UUID) rs.getObject(1))
                .login(rs.getString(2))
                .firstName(rs.getString(3))
                .active(rs.getBoolean(4))
                .build());
*/
    }
}
