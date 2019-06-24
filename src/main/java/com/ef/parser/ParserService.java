package com.ef.parser;

import com.ef.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Service
@Slf4j
public class ParserService {

    private static final String PIPE = "\\|";

    public void execute(ParserRequest parserRequest) {
        try (Scanner sc = new Scanner(new File(parserRequest.getPathToFile()), StandardCharsets.UTF_8)) {
            var accessByIp = new HashMap<String, List<Access>>();
            while (sc.hasNextLine()) {
                var line = sc.nextLine();
                var access = convert(line.split(PIPE));
                var accessListByIp = accessByIp.computeIfAbsent(access.getIp(), k -> new ArrayList<>());
                accessListByIp.add(access);
            }
            System.out.println(accessByIp);
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
