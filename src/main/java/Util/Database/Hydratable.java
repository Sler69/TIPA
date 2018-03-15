package Util.Database;

import com.tipa.Util.DatabaseUtil.ResultSetWrapper;

import java.sql.SQLException;

@FunctionalInterface
public interface Hydratable<T> {
    T from(ResultSetWrapper row) throws SQLException;
}
