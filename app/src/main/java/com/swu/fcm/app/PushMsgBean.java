package com.swu.fcm.app;

public class PushMsgBean {

	private String time_to_live;
	private String to;
	private Data data;
	
	public static class Data {
		
		private String title;
		private String imgUrl;
		private String message;
		private String name;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getImgUrl() {
			return imgUrl;
		}
		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
				
	}//end data

	
	public String getTime_to_live() {
		return time_to_live;
	}

	public void setTime_to_live(String time_to_live) {
		this.time_to_live = time_to_live;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
}
