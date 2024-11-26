package alarmtimer;

class CurrentClock {

	long getSeconds() {
		return System.currentTimeMillis() / 1000L;
	}
}

public class Alarm {
	CurrentClock timer;
	public long seconds_expired;

	public Alarm(long seconds_to_expire) {
		this( seconds_to_expire, new CurrentClock());
	}

	Alarm(long seconds_to_expire, CurrentClock t) {
		timer = t;
		seconds_expired = timer.getSeconds() + seconds_to_expire;
	}

	public boolean isExpired() {
		return timer.getSeconds() >= seconds_expired;
	}
}
