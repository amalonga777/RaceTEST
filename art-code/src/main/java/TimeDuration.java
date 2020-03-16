
public class TimeDuration {

	private int seconds;

	TimeDuration(int seconds) {
		if (seconds < 0) {
			try {
				throw new BadBadValueException();
			} catch (BadBadValueException e) {
				e.printStackTrace();
			}
		} else {
			this.seconds = seconds;
		}
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getSeconds() {
		return seconds;
	}

	public String toString() {
		int hours = seconds / 3600;
		int minutes = (seconds - hours * 3600) / 60;
		int oSeconds = seconds - hours * 3600 - minutes * 60;
		String fHours = hours == 0 ? "" : hours + "h ";
		String fMinutes = minutes == 0 ? hours == 0 ? "" : "0m " : minutes + "m ";
		String fSeconds = oSeconds == 0 ? "0s" : oSeconds + "s";
		return fHours + "" + fMinutes + "" + fSeconds;
	}


}
