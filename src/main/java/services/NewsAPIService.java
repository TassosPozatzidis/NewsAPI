package services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

import NewsAPI.Article;
import NewsAPI.Source;
import NewsAPI.NewsException;
import NewsAPI.NewsResult;
import exception.NewsAPIException;
import model.NewsInfo;

public class NewsAPIService {					
	private final String API_URL;						//private final variables - cannot be changed inside class
	private final String API_KEY;
	
//	
	public NewsAPIService(String aPI_URL, String aPI_KEY) {		//constructor of NewsAPIService
		super();
		API_URL = aPI_URL;
		API_KEY = aPI_KEY;
	}
	//	All methods					
	//	every function return a list after a specific search based on the parameters given
	
	
	public List<NewsInfo> getTopHeadlines(String country) throws NewsAPIException { 						
		NewsResult result = getAPIData("top-headlines", country,null,null,null,null, API_URL, API_KEY); 
		List<NewsInfo> newsInfoList = new ArrayList<>(result.getArticles().size());
		for (Article theResult : result.getArticles()) {
			newsInfoList.add(new NewsInfo(theResult));
		}
		return newsInfoList;
	}

	/* https://newsapi.org/v2/top-headlines?country={country}&category={category} */
	
	// get Top Headlines by category
	public List<NewsInfo> getTopHeadlinesInaCountryByCategory(String country, String category) throws NewsAPIException {  
		NewsResult result = getAPIData("top-headlines", country,category,null,null,null, API_URL, API_KEY); 					//get the result of the request
		List<NewsInfo> newsInfoList = new ArrayList<>(result.getArticles().size());												//create a NewsInfo list
		for (Article theResult : result.getArticles()) {																		//each time you find an article object get the article 
			newsInfoList.add(new NewsInfo(theResult));																			//add the article to the list
		}
		return newsInfoList;																									//return the list of Articles
	}
	// get Top Headlines by category
	public String getSourceByCategory(String country, String category) throws NewsAPIException {  
		NewsResult result = getAPIData("top-headlines",country,category,null,null,null, API_URL, API_KEY); 					//get the result of the request
		List<String> newsInfoList = new ArrayList<>(result.getArticles().size());													//create a NewsInfo list
		for (Article theResult : result.getArticles()) {
			if (theResult.getSource().getId()==null) {
				newsInfoList.add("");
			}else {
			newsInfoList.add(new String(theResult.getSource().getId()));	
			}//each time you find an article object get the article 

		}
		String string = String.join(",", newsInfoList);
		return string;																									//return the list of Articles
	}
	
	//search with everything end point with all criteria available
	public List<NewsInfo> searchAllCriteriaCategory(String country,String category,String q,String language,String sources, String from,String to) throws NewsAPIException {
		if (category != null && !category.equals("") ) {
			sources=getSourceByCategory(country,category) ; //to get the category we call getSourceByCategory wich returns the ID of the sources in a category
		}
		List<NewsInfo> newsInfoList=null;
			NewsResult result = getAPIData("everything",q,language,sources,from,to ,API_URL, API_KEY);
			newsInfoList = new ArrayList<>(result.getArticles().size());
			for (Article theResult : result.getArticles()) {
				newsInfoList.add(new NewsInfo(theResult));
			}
		
		return newsInfoList; //returns the list
	}
	
	// get API Data
	
	private NewsResult getAPIData(String apiFunction, String parameter, String parameter2,String parameter3,String parameter4,String parameter5, String API_URL, String API_KEY)
			throws NewsAPIException {
		try {
			
			// https://newsapi.org/v2/top-headlines?country=gr&apiKey= a1e64a0e859643e8ad486aff6a948c3f
			// https://newsapi.org/v2/everything?q=bitcoin
			// https://newsapi.org/v2/top-headlines?country=gr&category=business
			
			final URIBuilder uriBuilder = new URIBuilder(API_URL)		//call a new URIBuilder function
					.setPathSegments("v2", apiFunction)					//add path parameters to the construction o URL
					.addParameter("apiKey", API_KEY);					//add apIkey to the construction o URL
			if (parameter != null && !parameter.isBlank()) {			//check if parameters empty 
				switch (apiFunction) {
				case "top-headlines":									
					if( parameter !=null && !parameter.equals("")) {	//if choice is top headlines 1st parameter is country
					uriBuilder.addParameter("country", parameter);		
					}
					if(parameter2!=null && !parameter2.equals("")) {	//if choice is top headlines 2nd parameter is category
						uriBuilder.addParameter("category", parameter2);
					}				
					break;
				case "everything":
					if( parameter != null && !parameter.equals("") ) {	//if choice is everything , 1st parameter is q(search base to a word)
						uriBuilder.addParameter("q", parameter);
					}
					if(parameter2 != null && !parameter2.equals("")) {
						uriBuilder.addParameter("language", parameter2);	//if choice is everything , 2nd parameter is language
					}
					if(parameter3 != null && !parameter3.equals("")) {
						uriBuilder.addParameter("sources", parameter3);		//if choice is everything , 3rd parameter is source of the article
					}
					if(parameter4 != null && !parameter4.equals("")) {
						uriBuilder.addParameter("from", parameter4);		//if choice is everything , 4th parameter is date from
					}
					if(parameter5 != null && !parameter5.equals("")) {
						uriBuilder.addParameter("to", parameter5);			//if choice is everything , 5th parameter is date to
					}
					break;
					
				}
			}
			final URI uri = uriBuilder.build();												//build URI 
			
			final HttpGet getRequest = new HttpGet(uri);									//Create a GET request
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			try (CloseableHttpResponse response = httpclient.execute(getRequest)) {			//GET the response
				final HttpEntity entity = response.getEntity();
				final ObjectMapper mapper = new ObjectMapper();

				if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {				//Check if the response is in status OK, else generate an error message
					NewsException errorResponse = mapper.readValue(entity.getContent(), NewsException.class);
					if (errorResponse.getMessage() != null)
						throw new NewsAPIException("Error occurred on API call: " + errorResponse.getMessage());
				}

				return mapper.readValue(entity.getContent(), NewsResult.class);
			} catch (IOException e) {
				throw new NewsAPIException("Error requesting data from the NewsAPI.", e);
			}
		} catch (URISyntaxException e) {
			throw new NewsAPIException("Unable to create request URI.", e);
		}
	}
}
