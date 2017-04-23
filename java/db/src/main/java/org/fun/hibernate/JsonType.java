package org.fun.hibernate;

import org.hibernate.usertype.UserType;

/**
 * Created by tim on 4/22/17.
 */
public class JsonType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[0];
    }

    @Override
    public Class returnedClass() {
        return null;
    }
}
