package lk.ijse.Library_Management_System.DAO.Custom.Impl;

import lk.ijse.Library_Management_System.Configuration.SessionFactoryConfig;
import lk.ijse.Library_Management_System.DAO.Custom.QueryDao;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class QueryDaoImpl implements QueryDao {
    @Override
    public int getAllOverdueBookCount() {
        Session session = SessionFactoryConfig.getInstance().getSession();

        String sql = "COUNT b.book_id\n" +
                "FROM book b\n" +
                "JOIN b.transactions t\n" +
                "WHERE t.handover_date IS NULL AND t.due_date < CURRENT_DATE";
        NativeQuery query = session.createSQLQuery(sql);

       /*String available = "No";
        query.setParameter("1",available);*/

        List list = query.list();

        int book = (int) list.get(0);

        /*String bookCounts = String.valueOf(book);
        int bookCount = Integer.parseInt(bookCounts);
*/
        session.close();
        return book;
    }
}
