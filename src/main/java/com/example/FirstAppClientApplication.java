package com.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FirstAppClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstAppClientApplication.class, args);
        
    }
}

@Component
class BookingCommandLineRunner  implements CommandLineRunner{
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("está corriendo");
		RestTemplate restTemplate = new RestTemplate();
		Bookmark bookmark =  restTemplate.getForObject("http://localhost:8080/davidcalle9430/bookmarks/17", Bookmark.class);
		System.out.println(bookmark.toString());
		Object[] bookmarks = restTemplate.getForObject("http://localhost:8080/davidcalle9430/bookmarks/", Object[].class);
		for (Object book : bookmarks) {
			System.out.println(book.toString());
		}
		
		
		
	}
}