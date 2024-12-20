package com.rasysbox.central.controller;

import com.rasysbox.central.model.Post;
import com.rasysbox.central.service.JSONPlaceHolderClient;
import com.rasysbox.central.service.OrderService;
import com.rasysbox.central.service.ProductService;
import com.rasysbox.central.service.UserService;
import com.rasysbox.module_a.entity.Order;
import com.rasysbox.module_b.entity.User;
import com.rasysbox.module_c.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "API Central", description = "API Central Service")
@RequestMapping(path = "${controller.properties.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
public class CentralController {
    private final static Logger log = org.slf4j.LoggerFactory.getLogger(CentralController.class);

    private final OrderService orderService;
    private final UserService userService;
    private final ProductService productService;
    private final JSONPlaceHolderClient jsonPlaceHolderClient;

    @Autowired
    public CentralController(OrderService orderService, UserService userService, ProductService productService, JSONPlaceHolderClient jsonPlaceHolderClient) {
        this.orderService = orderService;
        this.userService = userService;
        this.productService = productService;
        this.jsonPlaceHolderClient = jsonPlaceHolderClient;
    }

    @GetMapping("/all-orders")
    @Operation(summary = "Get all orders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/all-users")
    @Operation(summary = "Get all users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/all-products")
    @Operation(summary = "Get all products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/posts")
    @Operation(summary = "Get all posts")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = jsonPlaceHolderClient.getPosts();
        if (posts.isEmpty()) {
            log.warn("No posts found");
            return ResponseEntity.noContent().build();
        }
        log.info("Returning {} posts", posts.size());
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/get-post-by-id/{id}")
    @Operation(summary = "Get post by id")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = jsonPlaceHolderClient.getPostById(id);
        if (post == null) {
            log.warn("Post with id {} not found", id);
            return ResponseEntity.notFound().build();
        }
        log.info("Returning post with id {}", id);
        return ResponseEntity.ok(post);
    }
}

