package model;

import NewsAPI.Article;
import NewsAPI.Source;

public class NewsInfo {
	private String title;
	private String description;
	private String upload_date;
	private String url;
	private String author;
	private String source;
	public NewsInfo(String title, String description, String upload_date, String url, String source, String author) {
		super();
		this.title = title;
		this.description = description;
		this.upload_date = upload_date;
		this.url = url;
		this.source=source;
		this.author=author;
	}
	
	public NewsInfo(Article theResult) {
		// TODO Auto-generated constructor stub
		this.title = theResult.getTitle();
		this.description = theResult.getDescription();
		this.upload_date = theResult.getPublishedAt();
		this.url = theResult.getUrl();
		this.source=theResult.getSource().getName();
		this.author=(String) theResult.getAuthor();
		}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString() {
		return "NewsInfo{"+
				"title='"+ title +"'\n"+
				",description='" + description + "'\n"+
				",url='" + url + "'\n"+
				",upload_date='" + upload_date + "'\n"+
				",source='" + source + "'\n"+
				",author='" + author + "'\n"+
		'}';
	}


}
