package org.hisoka.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hinsteny
 * @version $ID: IndexRes 2018-11-13 20:36 All rights reserved.$
 */
@Controller
public class IndexRes {

    @Value("${app.name}")
    private String appName;

    @RequestMapping(path = "/uuid")
    @ResponseBody
    public List<String> getRandomUUIDList(@RequestParam(name = "size", required = false) Integer size) {
        List<String> uuid = new ArrayList<>();
        if (null == size) {
            size = 10;
        }
        while (size > 0) {
            uuid.add(UUID.randomUUID().toString());
            size-=1;
        }
        return uuid;
    }
}
