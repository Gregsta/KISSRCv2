package de.repat.kissrc.networkstuff;

public class Message {

	
	
	private String topic;
	private String typ;
	private String message;

//	Message(String topic, String typ, String message) {
//		this.topic = topic;
//		this.typ = typ;
//		this.message = message;		
//	}
	
	
	/**
	 * @return Name of topic
	 * */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic
	 *            Name of topic
	 * */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * @return Typ topic or queue
	 * */
	public String getTyp() {
		return typ;
	}

	/**
	 * @param typ
	 *            Typ topic or queue
	 * */
	public void setTyp(String typ) {
		this.typ = typ;
	}

	/**
	 * @return Message for ActiveMQ
	 * */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            Message for ActiveMQ
	 * */
	public void setMessage(String message) {
		this.message = message;
	}
}
