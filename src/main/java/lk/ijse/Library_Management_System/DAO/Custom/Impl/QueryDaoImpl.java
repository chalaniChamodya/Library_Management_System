package lk.ijse.Library_Management_System.DAO.Custom.Impl;

import lk.ijse.Library_Management_System.Configuration.SessionFactoryConfig;
import lk.ijse.Library_Management_System.DAO.Custom.QueryDao;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.time.LocalDate;
import java.util.List;

public class QueryDaoImpl implements QueryDao {
    @Override
    public int getAllOverdueBookCount() {
        Session session = SessionFactoryConfig.getInstance().getSession();

        String sql = "COUNT b.book_id\n" +
                "FROM book b\n" +
                "JOIN b.transactions t\n" +
                "WHERE t.handover_date IS NULL AND t.due_date <:CURRENTDATE";
        NativeQuery query = session.createSQLQuery(sql);

       LocalDate date = LocalDate.now();
        query.setParameter("CURRENTDATE",date);

        List list = query.list();

        int book = (int) list.get(0);

        /*String bookCounts = String.valueOf(book);
        int bookCount = Integer.parseInt(bookCounts);
*/
        session.close();
        return book;
    }
}
