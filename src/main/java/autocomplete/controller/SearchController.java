package autocomplete.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import autocomplete.model.Query;

@CrossOrigin
@Controller
@RequestMapping("/search")
public class SearchController {

	private static String GITHUB_API_BASE_URL = "https://api.github.com/search/";

	@GetMapping
	public ResponseEntity<?> search(Query queryObj) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String category = queryObj.getCategory();
			String query = queryObj.getString();
			String sort = queryObj.getSortOrder() != null ? queryObj.getSortOrder().getString() : "";
			String url = GITHUB_API_BASE_URL + category + query + sort;
			System.out.println("GET " + url);
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
			return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
		} catch (HttpClientErrorException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	private HttpEntity<String> getEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("", "token ");
		return new HttpEntity<>("body", headers);
	}
}
