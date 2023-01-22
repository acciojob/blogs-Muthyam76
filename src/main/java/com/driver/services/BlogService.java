package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;
    @Autowired
    private ImageRepository imageRepository;

    public List<Blog> showBlogs(){
        //find all blogs
        List<Blog>b=blogRepository1.findAll();
        return b;

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog b=new Blog();

        //updating the blog details
        b.setTitle(title);
        b.setContent(content);
        b.setPubDate(new Date());
        User u=userRepository1.findById(userId).get();
        b.setUser(u);


        //Updating the userInformation and changing its blogs
        List<Blog>totalBlogs=u.getBlogList();
        totalBlogs.add(b);
        u.setBlogList(totalBlogs);
        userRepository1.save(u);


    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository1.findById(blogId).get();

    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Blog b=blogRepository1.findById(blogId).get();
        Image image=imageService1.createAndReturn(b,description,dimensions);
        List<Image>i=b.getImageList();
        List<Image>imageList=b.getImageList();
        imageList.add(image);
        b.setImageList(imageList);
        blogRepository1.save(b);



    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog b=blogRepository1.findById(blogId).get();
        if(b!=null){
            blogRepository1.delete(b);
        }
    }
}
