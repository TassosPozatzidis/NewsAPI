package model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exception.NewsAPIException;
import services.IpAPIService;
import services.NewsAPIService;

public class NewsAPITest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void test() throws NewsAPIException {
//		final IpAPIService IpSearchService = IpAPI.getIpAPIService();
//		final NewsAPIService newsSearchService = NewsAPI.getNewsAPIService();
//		final String Country = IpSearchService.findCountry(null);
//		final String results = newsSearchService.getSourceByCategory(Country,"");
//		Assert.assertFalse(results.isEmpty());
//		System.out.println(results);
//
//	}//(String country,String category,String q,String language, String from,String to)
	@Test
	public void test2() throws NewsAPIException {
		final IpAPIService IpSearchService = IpAPI.getIpAPIService();
		final NewsAPIService newsSearchService = NewsAPI.getNewsAPIService();
		final String Country = IpSearchService.findCountry(null);
		final List<NewsInfo> results = newsSearchService.searchAllCriteriaCategory(Country,"spor","Ολυμπιακός",null,null,null,null);
		Assert.assertFalse(results.isEmpty());
		results.forEach(System.out::println);

	}
//	@Test
//	public void test3() throws NewsAPIException {
//		final IpAPIService IpSearchService = IpAPI.getIpAPIService();										//Test function for getting the Country through IP Geolocation API results based on parameters
//		final String Country = IpSearchService.findCountry(null);
//		final NewsAPIService newsSearchService = NewsAPI.getNewsAPIService();
//		final List<NewsInfo> results = newsSearchService.getTopHeadlinesInaCountryByCategory(Country,"sport");
//		Assert.assertFalse(results.isEmpty());
//		results.forEach(System.out::println);
//
//	}
//	@Test
//	public void test2() throws NewsAPIException {
//		final NewsAPIService newsSearchService = NewsAPI.getNewsAPIService();
//		final List<NewsInfo> results = newsSearchService.searchARticlesByKeyword("apple","en");
//		Assert.assertFalse(results.isEmpty());
//		results.forEach(System.out::println);
//
//	}
//	@Test
//	public void test4() throws NewsAPIException {																		//Test function for getting the results of a request to NewsAPI, based on parameters
//		final NewsAPIService newsSearchService = NewsAPI.getNewsAPIService();
//		final List<NewsInfo> results = newsSearchService.searchAllCriteria("ol",null,null,"2022-02-10",null);		//get the results of searchAllCriteria and place them to a NewsInfo list /parameters : q,language,source,from,to
//		Assert.assertFalse(results.isEmpty());
//		results.forEach(System.out::println);
//
//	}


//	@Test
//	public void test5() throws NewsAPIException {
//		final IpAPIService IpSearchService = IpAPI.getIpAPIService();
//		final String results = IpSearchService.findCountry("8.8.8.8");//q,language,source,from
//		Assert.assertFalse(results.isEmpty());
//		System.out.println(results);
//	}
}
