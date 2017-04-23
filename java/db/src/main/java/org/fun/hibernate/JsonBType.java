package org.fun.hibernate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.SerializationException;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

/**
 * Created by tim on 4/22/17.
 */
public class JsonBType implements UserType {
    public static final String JSONB_TYPE = "jsonb";
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public Class returnedClass() {
        return HashMap.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        }
        if ((x == null) || (y == null)) {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        assert (x != null);
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        String json = rs.getString(names[0]);

        try {
            return (json == null) ? null : JSON_MAPPER.readValue(json, returnedClass());
        } catch (IOException ioe) {
            throw new HibernateException(ioe);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        String json;
        try {
            json = (value == null) ? null : JSON_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException ioe) {
            throw new HibernateException(ioe);
        }
        PGobject pgObject = new PGobject();
        pgObject.setType(JSONB_TYPE);
        pgObject.setValue(json);
        st.setObject(index, pgObject);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        // also safe for mutable objects
        Object deepCopy = deepCopy(value);

        if (!(deepCopy instanceof Serializable)) {
            throw new SerializationException(
                    String.format("deepCopy of %s is not serializable", value), null);
        }

        return (Serializable) deepCopy;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        // also safe for mutable objects
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        // also safe for mutable objects
        return deepCopy(original);
    }
}
