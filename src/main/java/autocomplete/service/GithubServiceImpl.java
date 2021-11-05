package autocomplete.service;

import org.springframework.web.client.RestTemplate;

public class GithubServiceImpl implements GithubService {

	private static String GITHUB_API_BASE_URL = "https://api.github.com/search/";

	private void APICall(String url, Class<?> clazz) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForEntity(url, clazz);
	}

	@Override
	public void searchByRepository(String query) {
		String repositories = GITHUB_API_BASE_URL + "repositories";
		repositories.concat(query);
	}

	@Override
	public void searchByTopic() {
		String topicUrl = GITHUB_API_BASE_URL + "topic";
//		APICall(topicUrl)

	}

}