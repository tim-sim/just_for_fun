package org.fun.hibernate;

import org.hibernate.dialect.PostgreSQL94Dialect;

import java.sql.Types;

/**
 * Created by tim on 23.04.2017.
 */
public class JsonBPostgreSQLDialect extends PostgreSQL94Dialect {
    public JsonBPostgreSQLDialect() {
        super();
        registerColumnType(Types.JAVA_OBJECT, JsonBType.JSONB_TYPE);
    }
}
