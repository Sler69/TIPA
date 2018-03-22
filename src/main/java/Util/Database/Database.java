package Util.Database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.tipa.Util.DatabaseUtil.PreparedStatementWrapper;
import com.tipa.Util.DatabaseUtil.ResultSetWrapper;


import java.sql.*;
import java.util.*;
import java.util.function.Consumer;

public class Database {

    private static final String DB_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_CONNECTION = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";

    private static final Preparable EMPTY_PREPARABLE = statement -> {
    };

    private static final Consumer<? super Throwable> EMPTY_ERROR_HANDLER = throwable -> {
    };
    public static QueryBuilder Builder() {
        return new QueryBuilder();
    }

    public static class QueryBuilder{
        private String statement = "SELECT 1";
        private Preparable preparable = EMPTY_PREPARABLE;
        private Consumer<? super Throwable> errorHandler = EMPTY_ERROR_HANDLER;

        private QueryBuilder() {
        }

        private QueryBuilder(String statement, Preparable preparable) {
            this.statement = statement;
            this.preparable = preparable;
        }
        public QueryBuilder newBuilder() {
            return new QueryBuilder(statement, preparable);
        }

        /**
         * Set the statement that will be run by a terminating operation.
         *
         * @param statement sql statement to be run
         * @return the builder
         */
        public QueryBuilder statement(String statement) {
            this.statement = statement;
            return this;
        }

        /**
         * Set the {@link Preparable} that will format the {@link PreparedStatement} appropriately.
         *
         * @param preparable logic to prepare a sql statement
         * @return the builder
         */
        public QueryBuilder preparable( Preparable preparable) {
            this.preparable = preparable;
            return this;
        }

        /**
         * Set the {@link Consumer} that will handle errors during query preparation and execution.
         *
         * @param errorHandler logic to handle errors
         * @return the builder
         */
        public QueryBuilder onError( Consumer<? super Throwable> errorHandler) {
            this.errorHandler = errorHandler;
            return this;
        }

        /**
         * Updates the datastore using the provided query.
         * <p>
         * Use this whenever you're going to perform an UPDATE, INSERT, DELETE, UPSERT, et cetera.
         * <p>
         * Terminating function.
         *
         * @return number of rows affected by the query
         */
        public int execute() {
            return perform(0, PreparedStatement::executeUpdate);
        }


        /**
         * Updates the datastore using the provided query, returning the set of generated keys.
         * <p>
         * Use this whenever you're going to perform an UPDATE, INSERT, DELETE, UPSERT, et cetera.
         * <p>
         * Terminating function.
         *
         * @return number of rows affected by the query
         */
        /**
         * Obtains the first column of the first row (a scalar) of a query result.
         * <p>
         * Use this wherever you need a scalar value (ex from COUNT).
         * <p>
         * Terminating function.
         *
         * @param <T> the scalar
         * @return scalar value
         */
        public <T> Optional<T> scalar() {
            return perform(Optional.empty(), statement -> {
                final ResultSet row = statement.executeQuery();

                if (row.next()) {
                    final T scalar = (T) row.getObject(1);
                    return Optional.ofNullable(scalar);
                }

                row.close();

                return Optional.empty();
            });
        }

        /**
         * Obtains all the domain objects returned by a query.
         * <p>
         * Using hydration logic via a {@link Hydratable}, we create a list of domain objects
         * from each row in the result set.
         * <p>
         * Use this whenever you're going to perform a SELECT.
         * <p>
         * Terminating function.
         *
         * @param hydration logic for packing the resultset into a domain object
         * @param <T>       the domain object
         * @return a list of domain objects
         */
        public <T> List<T> query(final Hydratable<T> hydration) {
            return perform(Collections.emptyList(), statement -> {
                final ResultSetWrapper row = new ResultSetWrapper(statement.executeQuery());

                final List<T> models = new ArrayList<>();
                while (row.next()) {
                    final T model = hydration.from(row);

                    if (model != null) {
                        models.add(model);
                    }
                }

                row.close();

                return models;
            });
        }

        /**
         * Helper function to keep the terminating functions DRY.
         *
         * @param defaultValue return value when an exception is hit
         * @param executor     logic for returning a value given a {@link PreparedStatement}
         * @param <T>          return type
         * @return the result of the executable
         */
        private <T> T perform( T defaultValue,ThrowableFunction<PreparedStatement, T, SQLException> executor) {
            try (final Connection connection = getDBConnection();
                 final PreparedStatementWrapper statement =
                         new PreparedStatementWrapper(connection.prepareStatement(this.statement))
            ) {
                preparable.prepare(statement);
                return executor.apply(statement);
            } catch (Exception e) {
                final String message = String.format("Failed to execute query: %s", statement);
                errorHandler.accept(e);
            }

            return defaultValue;
        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {


            dbConnection = DriverManager.getConnection("jdbc:sqlserver://estimator-k.database.windows.net:1433;database={database here!!};" +
                    "user={user here !!!};password={password here!};" +
                    "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            /*
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("UserName");
            ds.setPassword("*****");
            ds.setServerName("localhost");
            ds.setPortNumber(1433);
            ds.setDatabaseName("AdventureWorks");
            return dbConnection;
            */
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
