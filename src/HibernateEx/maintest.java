
package HibernateEx;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;

public class maintest {
private static Logger logger = Logger.getLogger(maintest.class);
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = null;
logger.info("This is info message start.");
		try {
			session = sf.openSession();
			session.beginTransaction();
			Demo demo = new Demo();
			//demo.setId("3");
			demo.setTitle("liao");
			session.save(demo);

logger.debug("This is debug message.");
			session.getTransaction().commit();
logger.info("This is info message."); 
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
	}

}
