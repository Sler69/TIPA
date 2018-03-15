package Util.Database;

import com.tipa.Util.DatabaseUtil.PreparedStatementWrapper;

import java.sql.SQLException;

@FunctionalInterface
public interface Preparable {
    void prepare(PreparedStatementWrapper statement) throws SQLException;
}
