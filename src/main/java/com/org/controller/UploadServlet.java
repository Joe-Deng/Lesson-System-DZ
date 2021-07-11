package com.org.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadServlet",urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory 工厂实现类 DiskFileItemFactory;
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //用于解析上传的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for(FileItem item : list){
                    if(item.isFormField()){
                        System.out.println("item.getFieldName()"+item.getFieldName());
                        System.out.println("item.getName()"+item.getName());
                        System.out.println("item.getString()"+item.getString());
                        System.out.println("item.getString('UTF-8')"+item.getString("UTF-8"));
                    }else {
                        System.out.println("FieldName:"+item.getFieldName());
                        System.out.println("name"+item.getName());
                        //判断
                        File fileContext = new File("D:\\ServerUpload\\files\\");
                        if(!fileContext.exists()){
                            fileContext.mkdirs();
                        }
                        item.write(new File("D:\\ServerUpload\\files\\" + item.getName()));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
