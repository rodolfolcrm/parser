package com.ef;

import com.ef.parser.ParserRequest;
import com.ef.parser.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class Parser implements CommandLineRunner {

	private ParserService parserService;

	@Autowired
	public Parser(ParserService parserService) {
		this.parserService = parserService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Parser.class, args);
	}

	@Override
	public void run(String... args) {
		parserService.execute(ParserRequest.builder()
				.pathToFile(args[0])
				.startDate(LocalDateTime.parse(args[1], DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm:ss")))
				.duration(ParserRequest.Duration.valueOf(args[2].toUpperCase()))
				.threshold(Integer.valueOf(args[3]))
				.build());
	}
}
