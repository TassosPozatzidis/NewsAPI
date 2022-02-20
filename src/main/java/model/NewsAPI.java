package model;

import services.NewsAPIService;

public class NewsAPI {
	public static NewsAPIService getNewsAPIService() {
		return new NewsAPIService ("https://newsapi.org/","a1e64a0e859643e8ad486aff6a948c3f");
	}

	
}
