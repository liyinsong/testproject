package lys.threads.javathreads.examples.ch11;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

public class URLPingTask extends TimerTask {

	public interface URLUpdate {
		public void isAlive(boolean b);
	}

	URL url;
	URLUpdate updater;

	public URLPingTask(URL url) {
		this(url, null);
	}

	public URLPingTask(URL url, URLUpdate uu) {
		this.url = url;
		updater = uu;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (System.currentTimeMillis() - scheduledExecutionTime() > 5000) {

			// Let the next task do it
			return;
		}
		try {
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			huc.setConnectTimeout(1000);
			huc.setReadTimeout(1000);
			int code = huc.getResponseCode();
			if (updater != null)
				updater.isAlive(true);
		} catch (Exception e) {
			if (updater != null)
				updater.isAlive(false);
		}

	}

}
