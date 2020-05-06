package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import retriveCache.RetriveCacheInfo;

public class ApplicationContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		

		try {
			System.out.println("loading user data");
			RetriveCacheInfo.getInfo();
		} catch (Exception e) {
			System.out.println("Error in loading user info");
		}

	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}
}