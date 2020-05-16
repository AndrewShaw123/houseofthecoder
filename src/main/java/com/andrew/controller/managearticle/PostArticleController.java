package com.andrew.controller.managearticle;

import com.andrew.model.Article;
import com.andrew.model.SessionUser;
import com.andrew.service.managearticle.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Class
 *
 *
 * @author andrew
 * @date 2020/1/8
 */
@Controller
public class PostArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/userpage/articlemageUpload")
    @ResponseBody
    public Map<String,Object> articlemageUpload(HttpServletRequest request, @RequestParam(value = "editormd-image-file", required = false) MultipartFile file) throws IOException {
        Map<String,Object> map = new HashMap<>(3);
        try {

            String rootPath = request.getSession().getServletContext().getRealPath("/img/uploadimg/");

            LocalDate localDate = LocalDate.now();

            String timePath = localDate.getYear()+"/"+(localDate.getMonthValue())+"/"+(localDate.getDayOfMonth());
            File dateFile = new File(timePath);

            String originalFile = file.getOriginalFilename();

            String postFix = originalFile.substring(originalFile.lastIndexOf("."));
            String newFileName = System.currentTimeMillis()+postFix;
            System.out.println("new File name"+newFileName);

            File newFile = new File(rootPath+"/"+dateFile+"/"+newFileName);

            if(!newFile.getParentFile().exists()){
                newFile.getParentFile().mkdirs();
            }

            file.transferTo(newFile);


            map.put("success",1);
            map.put("message","上传成功");
            map.put("url","/houseofthecoder/viewUploadImg?imageFileName="+dateFile+"/"+newFileName);

        } catch (Exception e) {
            map.put("success",0);
        }
        return map;
    }

    @GetMapping("/viewUploadImg")
    public void viewUploadImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String imageFileName = request.getParameter("imageFileName");
        response.setContentType("text/html; charset=UTF-8");
        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
        String savePath = request.getServletContext().getRealPath("/img/uploadimg");

        int index = imageFileName.lastIndexOf(".");
        String errorString = imageFileName.substring(index - 3, index);
        if(errorString.equals("@2x")){
            imageFileName = imageFileName.substring(0,index-3) + imageFileName.substring(index);
        }

        try (FileImageInputStream input = new FileImageInputStream(new File(savePath + "/"+imageFileName));
             ByteArrayOutputStream output = new ByteArrayOutputStream();) {
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = input.read(buf)) != -1) {
                output.write(buf, 0, len);
            }
            byte[] data = output.toByteArray();
            os.write(data);
            os.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @PostMapping("/userpage/saveArticle")
    public String saveArticle(HttpServletRequest request) {

        Timestamp uploadTime = Timestamp.valueOf(LocalDateTime.now());

        SessionUser login = (SessionUser)request.getSession().getAttribute("login");
        Integer accountId = login.getAccountId();

        String html = request.getParameter("editormdHtml");
        System.out.println(html);
        Integer sortId = Integer.parseInt(request.getParameter("sortId"));
        String title = request.getParameter("title");

        Article article = new Article(null,accountId,sortId,title,html,uploadTime, 0, 0, 0);

        articleService.postArticle(article);
        return "success";
    }

    @GetMapping("/userpage/postSucess")
    public String postSucess(){
        return "redirect:../main.html?page=0";
    }
}
