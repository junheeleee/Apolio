package com.ssafy.apolio.web;

import com.ssafy.apolio.dto.NewsApiDto;
import com.ssafy.apolio.dto.TrendsDto;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/api")
@RestController
public class HomeController {
    @ApiOperation(value = "최신 IT 동향 정보를 크롤링 하여서 제목과 이미지를 메인 화면에 보여준다.", response = List.class)
    @GetMapping("/")
    public ResponseEntity<List<TrendsDto>> getTrends() throws IOException {
        List<TrendsDto> trendsDtoList = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.itfind.or.kr/trend/trend/bestData/list.do").get();
        Elements item = doc.select("dl");
        for(Element e : item){
            TrendsDto trendsDto = new TrendsDto();
            String title = e.select("a").text();
            Element content = e.select("a").first();
            String content_url = content.attr("href");
            Element img_element = e.select("img").first();
            String img_url = "https://www.itfind.or.kr" + img_element.attr("src");
            trendsDto.setTitle(title);
            trendsDto.setContent_url(content_url);
            trendsDto.setImg_url(img_url);
            trendsDtoList.add(trendsDto);
        }

        return new ResponseEntity<List<TrendsDto>>(trendsDtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "각 나라별 IT 뉴스 api를 파싱하여 제목, 이미지, 내용을 보여준다.", response = List.class)
    @GetMapping("/news/{country}")
    public ResponseEntity<List<NewsApiDto>> getNews(@PathVariable String country) throws IOException, ParseException {
        String address = "http://newsapi.org/v2/top-headlines?country=";
        switch(country){
            case "korea": // 한국 뉴스
                address += "kr";
                break;
            case "usa": // 미국 뉴스
                address += "us";
                break;
            case "france": // 프랑스 뉴스
                address += "fr";
                break;
            case "singapore":// 싱가포르 뉴스
                address += "sg";
                break;
            case "canada":// 캐나다 뉴스
                address += "ca";
                break;
            case "uk":// 영국 뉴스
                address += "gb";
                break;
        }
        address += "&category=technology&apiKey=07d8b4a0dea941ab88cf0e1193f73525";

        URL url = new URL(address);
        String protocol = "GET";
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod(protocol);
//        System.out.println("api url : " + address);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));;
        String news_json = br.readLine();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj = (JSONObject)jsonParser.parse(news_json);
        JSONArray news_list = (JSONArray) jsonObj.get("articles");//articles 배열 추출
        int size = news_list.size();
        List<NewsApiDto> newsApiDtos = new ArrayList<>();
//        System.out.println("news list size : " + size);
        // articles에서 author, title, content, date, url, img 추출
        for(int i=0;i<size;i++){
            NewsApiDto newsApiDto = new NewsApiDto();
            JSONObject object = (JSONObject)news_list.get(i);

            if(object.get("author") != null){
                String author = object.get("author").toString();
//                System.out.println("author : " + author);
                newsApiDto.setAuthor(author);
            }
            if(object.get("title") != null){
                String title = object.get("title").toString();
//                System.out.println("title : " + title);
                newsApiDto.setTitle(title);
            }
            if(object.get("description") != null){
                String description = object.get("description").toString();
//                System.out.println("des : " + description);
                newsApiDto.setDescription(description);
            }
            if(object.get("url") != null){
                String news_url = object.get("url").toString();
//                System.out.println("url : " + news_url);
                newsApiDto.setUrl(news_url);
            }
            if(object.get("urlToImage") != null){
                String urlToImage = object.get("urlToImage").toString();
//                System.out.println("img : " + urlToImage);
                newsApiDto.setUrltoimage(urlToImage);
            }
            if(object.get("publishedAt") != null){
                String publishedAt = object.get("publishedAt").toString();
//                System.out.println("pub : " + publishedAt);
                newsApiDto.setPublishedAt(publishedAt);
            }
            newsApiDtos.add(newsApiDto);
        }
        return new ResponseEntity<List<NewsApiDto>>(newsApiDtos, HttpStatus.OK);
    }
}
