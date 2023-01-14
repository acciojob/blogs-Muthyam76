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
        Blog b=new Blog();

        b.setTitle(title);
        b.setContent(content);
        User u=userRepository1.findById(userId).get();
        List<Blog>totalBlogs=u.getBlogList();
        totalBlogs.add(b);
        u.setBlogList(totalBlogs);
        userRepository1.save(u);
        blogRepository1.save(b);
        //create a blog at the current time

        //updating the blog details

        //Updating the userInformation and changing its blogs

    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository1.findById(blogId).get();

    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Blog b=blogRepository1.findById(blogId).get();
        List<Image>i=b.getImageList();
        for(Image image : i){
            if(image.getDescription().equals(description) && image.getDimensions().equals(dimensions)){
                image.setDescription(description);
                image.setDimensions(dimensions);
                int id=image.getId();
                Image update=imageRepository.findById(id).get();
                update.setDescription(description);
                update.setDimensions(dimensions);
            }
        }


    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog b=blogRepository1.findById(blogId).get();
        List<Image>i=b.getImageList();
        for(Image image : i){
            imageRepository.delete(image);
        }
        blogRepository1.deleteById(blogId);
    }
}
