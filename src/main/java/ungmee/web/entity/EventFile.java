package ungmee.web.entity;

public class EventFile {
	private int id;
	private String fileName;
	private int eventId;
	
	public EventFile() {
	}

	public EventFile(String fileName, int eventId) {
		this.fileName = fileName;
		this.eventId = eventId;
	}

	public EventFile(int id, String fileName, int eventId) {
		this.id = id;
		this.fileName = fileName;
		this.eventId = eventId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "EventFile [id=" + id + ", fileName=" + fileName + ", eventId=" + eventId + "]";
	}
	
	
}
