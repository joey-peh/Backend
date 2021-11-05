package autocomplete.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Query {
	// example: popular tetries repositories written in assembly code
	// q=tetris+language:assembly&sort=stars&order=desc
	private String category;
	private String filterBy;
	private Qualifier qualifier; // language:assembly
	private SortOrder sortOrder; // sort=stars&order=desc

	public String getString() {
		return "?q=" + filterBy;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Qualifier {
		private String language;
		private String user;
		private String in;
		private String repo;
	}

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class SortOrder {
		private String sort;
		private String order;

		public String getString() {
			return "&sort=" + sort + "&order=" + order;
		}
	}
}
