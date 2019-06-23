package com.ef;

import com.ef.parser.ParserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParserTest {
	private static final String PATH_TO_FILE = "/path/to/file";
	private static final String START_DATE = "2017-01-01.13:00:00";
	private static final String HOURLY = "hourly";
	private static final String THRESHOLD = "100";

	@Mock
	private ParserService parserService;

	@InjectMocks
	private Parser parser;

	@Test
	public void
	run_with_args() {
		parser.run(PATH_TO_FILE, START_DATE, HOURLY, THRESHOLD);
	}

}
