package telran.imagga.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.imagga.dto.ResponseDto;

public class ImaggaTagApp {
	static RestTemplate restTemplate = new RestTemplate();
	final static String TOKEN = "Basic YWNjX2EwYTU4OTc5NmMzMzY2Mzo4ZTc4N2Q4ODlhNmM0N2M1M2MzNjU2MDEwZmQ5Y2Q2ZA==";

	public static void main(String[] args) {
		String httpUrl = "https://api.imagga.com/v2/tags";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(httpUrl).queryParam("image_url",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjlopdtV9Os0V_RuNRKf5mh3tgGnuVJ7mKbAhrZZoV9BW8zDig4moJCcFP_8dVzYAfBeM")
				.queryParam("language", "ru").queryParam("limit", 3);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", TOKEN);
		RequestEntity<String> requestEntity = new RequestEntity<String>(headers, HttpMethod.GET,
				builder.build().toUri());

		ResponseEntity<ResponseDto> responseEntity = restTemplate.exchange(requestEntity, ResponseDto.class);
		responseEntity.getBody().getResult().getTags().forEach(System.out::println);
		

	}

}
