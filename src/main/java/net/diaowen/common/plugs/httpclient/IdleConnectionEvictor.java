package net.diaowen.common.plugs.httpclient;

import org.apache.http.conn.HttpClientConnectionManager;

public class IdleConnectionEvictor extends Thread {

	private final HttpClientConnectionManager connMgr;

	private volatile boolean shutdown;

	public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
		this.connMgr = connMgr;
		// start current thread
		this.start();
	}

	@Override
	public void run() {
		try {
			while (!shutdown) {
				synchronized (this) {
					wait(5000);
					// close the ideal connection
					connMgr.closeExpiredConnections();
				}
			}
		} catch (InterruptedException ex) {

		}
	}

	public void shutdown() {
		shutdown = true;
		synchronized (this) {
			notifyAll();
		}
	}
}