package com.tangyi.learn.controller;

import com.baidu.aip.ocr.AipOcr;
import com.tangyi.learn.util.JsonChange;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class OcrController {

    @PostMapping(value = "/ocr")
    public String ocr(@RequestBody String path) throws Exception {
        AipOcr client = new AipOcr("24150758", "iddEAX45NeH9r32t48u8DiFp", "oeOtV5mRMG1whz8Ab7lQAThTL9yeAC4n");
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>(4);
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        System.out.println(path);
        String str = "";
        // 参数为二进制数组
//        byte[] buf = file.getBytes();
//        JSONObject res = client.basicGeneral(buf, options);
        //String path = "C:\\Users\\23267\\Pictures\\Saved Pictures\\question1.jpg";
        JSONObject res = client.basicGeneral(path, options);
        System.out.println(res);
//        Map<String,Object> map = new HashMap<>();
//        Iterator<String> iterator = res.keys();
//        while(iterator.hasNext())
//        {
//            String key = (String)iterator.next();
//            Object value = res.get(key);
//            map.put(key, value);
//            System.out.println(map);
//
//        }

        Map map = JsonChange.json2map(res.toString());
        //  提取并打印出识别的文字
        List list = (List) map.get("words_result");
        int len = ((List) map.get("words_result")).size();
        for(int i=0; i<len; i++) {
            str = str + ((Map) list.get(i)).get("words") + "\n";
        }
        System.out.println(str);
        return str;
    }

}

