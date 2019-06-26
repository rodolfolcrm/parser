package com.ef;

import com.ef.access.AccessRepository;
import com.ef.blockedaccess.BlockedAccessRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.ef.Constants.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParserITTest {

    private static boolean dataLoaded;
    @Autowired
    private Parser parser;
    @Autowired
    private AccessRepository accessRepository;
    @Autowired
    private BlockedAccessRepository blockedAccessRepository;

    @Before
    public void init() {
        if (!dataLoaded) {
            //optimize tests and run daily rule to load the file only once.
            parser.run(PATH_TO_FILE, START_DATE_2017_01_01_00H, DAILY_VALUE, THRESHOLD_500);
            dataLoaded = true;
        }
        blockedAccessRepository.deleteAllInBatch();
    }

    @Test
    public void
    run_daily_rules() {
        parser.run(null, START_DATE_2017_01_01_00H, DAILY_VALUE, THRESHOLD_500); //don't load the file again.
        assertEquals(FILE_TOTAL_ACCESS, accessRepository.count());
        assertEquals(EXPECTED_DAILY_BLOCKED, blockedAccessRepository.count());
    }

    @Test
    public void
    run_hourly_rules() {
        parser.run(null, START_DATE_2017_01_01_13H, HOURLY_VALUE, THRESHOLD_200); //don't load the file again.
        assertEquals(FILE_TOTAL_ACCESS, accessRepository.count());
        assertEquals(EXPECTED_HOURLY_BLOCKED, blockedAccessRepository.count());
    }
}
