package com.ef.access;

import com.ef.parser.ParserException;
import com.ef.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Slf4j
public class AccessService {
    private static final String PIPE = "\\|";

    public List<Access> loadFromFile(String pathToFile) {
        try (Scanner sc = new Scanner(new File(pathToFile), StandardCharsets.UTF_8)) {
            var accessList = new ArrayList<Access>();
            while (sc.hasNextLine()) {
                var line = sc.nextLine();
                var access = convert(line.split(PIPE));
                accessList.add(access);
            }
            return accessList;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ParserException(e);
        }
    }

    Access convert(String[] record) {
        return Access.builder()
                .date(DateUtils.convertFileDateTime(record[0]))
                .ip(record[1])
                .request(record[2])
                .status(record[3])
                .userAgent(record[4])
                .build();
    }
}
