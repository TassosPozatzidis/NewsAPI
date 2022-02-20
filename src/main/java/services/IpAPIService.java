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
import NewsAPI.IpDetails;
import NewsAPI.Location;
import NewsAPI.NewsException;
import NewsAPI.NewsResult;
import exception.NewsAPIException;
import model.IpCountry;
import model.NewsInfo;

public class IpAPIService {
	
	private final String API_URL;
	private final String API_KEY;
	
//	
	public IpAPIService(String aPI_URL, String aPI_KEY) {
		super();
		API_URL = aPI_URL;
		API_KEY = aPI_KEY;
	}
	
	public String findCountry(String parameter) throws NewsAPIException {
		IpDetails result = getIpAPIData(API_URL, parameter, API_KEY);
		Location IpLocation = result.getLocation();
		String ipcountry = IpLocation.getCountry();
		
		return ipcountry;
		
	}
	private IpDetails getIpAPIData( String API_URL,String parameter, String API_KEY) throws NewsAPIException {
		try {
			final URIBuilder uriBuilder = new URIBuilder(API_URL)
					.setPathSegments("api/v2/country")
					.addParameter("apiKey", API_KEY)
					.addParameter("ipAddress", parameter);
			final URI uri = uriBuilder.build();
			final HttpGet getRequest = new HttpGet(uri);
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
				final HttpEntity entity = response.getEntity();
				final ObjectMapper mapper = new ObjectMapper();

				if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					NewsException errorResponse = mapper.readValue(entity.getContent(), NewsException.class);
					if (errorResponse.getMessage() != null)
						throw new NewsAPIException("Error occurred on API call: " + errorResponse.getMessage());
				}

				return mapper.readValue(entity.getContent(), IpDetails.class);
			} catch (IOException e) {
				throw new NewsAPIException("Error requesting data from the NewsAPI.", e);
			}
		} catch (URISyntaxException e) {
			throw new NewsAPIException("Unable to create request URI.", e);
		}
	}



}